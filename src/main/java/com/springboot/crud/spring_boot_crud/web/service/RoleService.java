package com.springboot.crud.spring_boot_crud.web.service;

import com.springboot.crud.spring_boot_crud.web.model.Role;

import java.util.List;

public interface RoleService {
    void add(Role role);

    List<Role> getListRoles();

    List<Role> getRolesListById(List<Long> id);
}
