package com.unesasoft.security;

import com.unesasoft.persistance.dao.RoleRepository;
import com.unesasoft.persistance.dao.UserRepository;
import com.unesasoft.persistance.dto.PrivilegeDTO;
import com.unesasoft.persistance.dto.RoleDTO;
import com.unesasoft.persistance.dto.UserDTO;
import com.unesasoft.service.IUserService;
import com.unesasoft.service.UserDetailsService;
import netscape.security.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Slavyanin on 27.07.2015.
 */
@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IUserService service;
    @Autowired
    private MessageSource messages;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;

    public MyUserDetailsService() {
        super();
    }

    // API

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        String ip = request.getRemoteAddr();
        if (loginAttemptService.isBlocked(ip)) {
            throw new RuntimeException("blocked");
        }

        try {
            final UserDTO user = userRepository.findByEmail(email);
            if (user == null) {
                return new org.springframework.security.core.userdetails.User(" ", " ", true, true, true, true, getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
            }

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorities(user.getRoles()));
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    // UTIL

    public final Collection<? extends GrantedAuthority> getAuthorities(final Collection<RoleDTO> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private final List<String> getPrivileges(final Collection<RoleDTO> roles) {
        final List<String> privileges = new ArrayList<String>();
        final List<PrivilegeDTO> collection = new ArrayList<PrivilegeDTO>();
        for (RoleDTO role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (final PrivilegeDTO item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}
