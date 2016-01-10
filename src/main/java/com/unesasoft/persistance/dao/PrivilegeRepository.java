package com.unesasoft.persistance.dao;

import com.unesasoft.persistance.dto.PrivilegeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Slavyanin on 27.07.2015.
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<PrivilegeDTO, Long> {
    public PrivilegeDTO findByName(String name);

    public void delete(PrivilegeDTO privilege);
}
