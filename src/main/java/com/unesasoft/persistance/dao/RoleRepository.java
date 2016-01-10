package com.unesasoft.persistance.dao;

import com.unesasoft.persistance.dto.RoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Slavyanin on 27.07.2015.
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleDTO, Long> {
    public RoleDTO findByName(String name);

}
