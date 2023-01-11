package com.springboot.crud.spring_boot_crud.web.service;

import com.springboot.crud.spring_boot_crud.web.dao.RoleDao;
import com.springboot.crud.spring_boot_crud.web.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public List<Role> getListRoles() {
        return roleDao.getListRoles();
    }

    @Override
    public List<Role> getRolesListById(List<Long> id) {
        return roleDao.getRolesListById(id);
    }
}
