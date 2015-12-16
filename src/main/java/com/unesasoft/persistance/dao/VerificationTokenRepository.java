package com.unesasoft.persistance.dao;

import com.unesasoft.persistance.dto.UserDTO;
import com.unesasoft.persistance.dto.VerificationTokenDTO;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by Slavyanin on 27.07.2015.
 */

public interface VerificationTokenRepository extends JpaRepository<VerificationTokenDTO, Long> {

    public VerificationTokenDTO findByToken(String token);

    public VerificationTokenDTO findByUser(UserDTO user);
}