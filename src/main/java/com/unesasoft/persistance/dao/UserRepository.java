package com.unesasoft.persistance.dao;

import com.unesasoft.persistance.dto.UserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Slavyanin on 27.07.2015.
 */
@Repository
public interface UserRepository extends CrudRepository<UserDTO, Long>{// JpaRepository<UserDTO, Long> {
    public UserDTO findByEmail(String email);

}
