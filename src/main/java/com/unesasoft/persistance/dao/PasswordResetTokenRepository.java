package com.unesasoft.persistance.dao;

import com.unesasoft.persistance.dto.PasswordResetTokenDTO;
import com.unesasoft.persistance.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Slavyanin on 27.07.2015.
 */
@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetTokenDTO, Long> {

    public PasswordResetTokenDTO findByToken(String token);

    public PasswordResetTokenDTO findByUser(UserDTO user);
}
