package com.unesasoft.service;

import com.unesasoft.dto.UserBean;
import com.unesasoft.exception.EmailExistsException;
import com.unesasoft.persistance.dao.PasswordResetTokenRepository;
import com.unesasoft.persistance.dao.RoleRepository;
import com.unesasoft.persistance.dao.UserRepository;
import com.unesasoft.persistance.dao.VerificationTokenRepository;
import com.unesasoft.persistance.dto.PasswordResetTokenDTO;
import com.unesasoft.persistance.dto.UserDTO;
import com.unesasoft.persistance.dto.VerificationTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Slavyanin on 27.07.2015.
 */
@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;

    //@Autowired
    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();;

    @Autowired
    private RoleRepository roleRepository;

    // API

    @Override
    public UserDTO registerNewUserAccount(final UserBean accountBean) throws EmailExistsException {
        if (emailExist(accountBean.getEmail())) {
            throw new EmailExistsException("There is an account with that email adress: " + accountBean.getEmail());
        }
        final UserDTO user = new UserDTO();

        user.setFirstName(accountBean.getFirstName());
        user.setLastName(accountBean.getLastName());
        user.setPassword(passwordEncoder.encode(accountBean.getPassword()));
        user.setEmail(accountBean.getEmail());

        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return repository.save(user);
    }

    @Override
    public UserDTO getUser(final String verificationToken) {
        final UserDTO user = tokenRepository.findByToken(verificationToken).getUser();
        return user;
    }

    @Override
    public VerificationTokenDTO getVerificationToken(final String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void saveRegisteredUser(final UserDTO user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(final UserDTO user) {
        repository.delete(user);
    }

    @Override
    public void createVerificationTokenForUser(final UserDTO user, final String token) {
        final VerificationTokenDTO myToken = new VerificationTokenDTO(token, user);
        tokenRepository.save(myToken);
    }

    @Override
    public VerificationTokenDTO generateNewVerificationToken(final String existingVerificationToken) {
        VerificationTokenDTO vToken = tokenRepository.findByToken(existingVerificationToken);
        vToken.updateToken(UUID.randomUUID().toString());
        vToken = tokenRepository.save(vToken);
        return vToken;
    }

    @Override
    public void createPasswordResetTokenForUser(final UserDTO user, final String token) {
        final PasswordResetTokenDTO myToken = new PasswordResetTokenDTO(token, user);
        passwordTokenRepository.save(myToken);
    }

//    @Override
//    public UserDTO findUserByEmail(final String email) {
//        return repository.findByEmail(email);
//    }

    @Override
    public PasswordResetTokenDTO getPasswordResetToken(final String token) {
        return passwordTokenRepository.findByToken(token);
    }

    @Override
    public UserDTO getUserByPasswordResetToken(final String token) {
        return passwordTokenRepository.findByToken(token).getUser();
    }

    @Override
    public UserDTO getUserByID(final long id) {
        return repository.findOne(id);
    }

    @Override
    public void changeUserPassword(final UserDTO user, final String password) {
        user.setPassword(passwordEncoder.encode(password));
        repository.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(final UserDTO user, final String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    private boolean emailExist(final String email) {
//        final UserDTO user = repository.findByEmail(email);
//        if (user != null) {
//            return true;
//        }
        return false;
    }
}
