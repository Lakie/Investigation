package com.unesasoft.service;

import com.unesasoft.dto.UserBean;
import com.unesasoft.exception.EmailExistsException;
import com.unesasoft.persistance.dto.PasswordResetTokenDTO;
import com.unesasoft.persistance.dto.UserDTO;
import com.unesasoft.persistance.dto.VerificationTokenDTO;

/**
 * Created by Slavyanin on 27.07.2015.
 */
public interface IUserService {
    UserDTO registerNewUserAccount(UserBean accountBean) throws EmailExistsException;

    UserDTO getUser(String verificationToken);

    void saveRegisteredUser(UserDTO user);

    void deleteUser(UserDTO user);

    void createVerificationTokenForUser(UserDTO user, String token);

    VerificationTokenDTO getVerificationToken(String VerificationToken);

    VerificationTokenDTO generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(UserDTO user, String token);

//    UserDTO findUserByEmail(String email);

    PasswordResetTokenDTO getPasswordResetToken(String token);

    UserDTO getUserByPasswordResetToken(String token);

    UserDTO getUserByID(long id);

    void changeUserPassword(UserDTO user, String password);

    boolean checkIfValidOldPassword(UserDTO user, String password);
}
