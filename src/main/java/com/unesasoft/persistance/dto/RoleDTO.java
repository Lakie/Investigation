package com.unesasoft.persistance.dto;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Slavyanin on 27.07.2015.
 */
@Entity
public class RoleDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "roles")
    private Collection<UserDTO> users;

    @ManyToMany
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id") )
    private Collection<PrivilegeDTO> privileges;

    private String name;

    public RoleDTO() {
        super();
    }

    public RoleDTO(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserDTO> users) {
        this.users = users;
    }

    public Collection<PrivilegeDTO> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<PrivilegeDTO> privileges) {
        this.privileges = privileges;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final RoleDTO role = (RoleDTO) obj;
        if (!role.equals(role.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Role [name=").append(name).append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }
}
