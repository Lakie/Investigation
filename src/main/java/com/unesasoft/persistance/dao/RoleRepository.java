package com.unesasoft.persistance.dao;

import com.unesasoft.persistance.dto.RoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Slavyanin on 27.07.2015.
 */
public interface RoleRepository extends JpaRepository<RoleDTO, Long> {
    public RoleDTO findByName(String name);

    public void delete(RoleDTO role);
}
