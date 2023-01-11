package com.springboot.crud.spring_boot_crud.web.service;



import com.springboot.crud.spring_boot_crud.web.model.Role;
import com.springboot.crud.spring_boot_crud.web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    public List<User> getAllUsers();

    public void deleteUser(long id);

    public User getUserById(long id);

    public void updateUser(long id, User updatedUser);
    public User findByUsername(String username);

    public void update(User user, List<Role> role);

}
