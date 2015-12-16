package com.unesasoft.spring;

import com.unesasoft.persistance.dao.PrivilegeRepository;
import com.unesasoft.persistance.dao.RoleRepository;
import com.unesasoft.persistance.dao.UserRepository;
import com.unesasoft.persistance.dto.PrivilegeDTO;
import com.unesasoft.persistance.dto.RoleDTO;
import com.unesasoft.persistance.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Slavyanin on 27.07.2015.
 */
@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final PrivilegeDTO readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        final PrivilegeDTO writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        // == create initial roles
        final List<PrivilegeDTO> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        final RoleDTO adminRole = roleRepository.findByName("ROLE_ADMIN");
        final UserDTO user = new UserDTO();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setRoles(Arrays.asList(adminRole));
        user.setEnabled(true);
        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    private final PrivilegeDTO createPrivilegeIfNotFound(final String name) {
        PrivilegeDTO privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new PrivilegeDTO(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private final RoleDTO createRoleIfNotFound(final String name, final Collection<PrivilegeDTO> privileges) {
        RoleDTO role = roleRepository.findByName(name);
        if (role == null) {
            role = new RoleDTO(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}
