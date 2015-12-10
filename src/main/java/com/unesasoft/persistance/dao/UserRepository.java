package com.unesasoft.persistance.dao;

import com.unesasoft.persistance.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Slavyanin on 27.07.2015.
 */
public interface UserRepository extends JpaRepository<UserDTO, Long> {
    public UserDTO findByEmail(String email);

    public void delete(UserDTO user);
}
