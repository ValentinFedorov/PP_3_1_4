package com.springboot.crud.spring_boot_crud.web.dao;

import com.springboot.crud.spring_boot_crud.web.model.Role;

import java.util.List;

public interface RoleDao {
    Role getByIdRole(Long id);
    List<Role> getListRoles();
    Role getByName(String name);
    List<Role> getListByName(List<String> name);
    boolean add(Role user);

    List<Role> getRolesListById(List<Long> roles);
}
