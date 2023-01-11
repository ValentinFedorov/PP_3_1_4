package com.springboot.crud.spring_boot_crud.web.controller;

import com.springboot.crud.spring_boot_crud.web.model.Role;
import com.springboot.crud.spring_boot_crud.web.model.User;
import com.springboot.crud.spring_boot_crud.web.repositories.RoleRepository;
import com.springboot.crud.spring_boot_crud.web.service.RoleService;
import com.springboot.crud.spring_boot_crud.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping()
    public String showAllUsers (Model model) {
        List<User> allUsers = userService.getAllUsers();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user1 = userService.findByUsername(auth.getName());
        List<Role> roles = roleRepository.findAll();


        model.addAttribute("user", user1);
        model.addAttribute("allUsers", allUsers);
        model.addAttribute("role", roles);

        return "all-users";
    }

    @RequestMapping(value = "/addUsers")
    public String addUsers (Model model) {
        User user = new User();
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roles);
        return "addUser";
    }

    @RequestMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @RequestMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

//    @GetMapping("/changeUser/{id}")
//    public String updateUser(@PathVariable("id") long id, Model model) {
//        List<Role> roles = roleRepository.findAll();
//        model.addAttribute("allRoles", roles);
//        model.addAttribute(userService.getUserById(id));
//        return "updateUsers";
//    }

//    @PostMapping("/changeUser/{id}")
//    public String editUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
//        userService.updateUser(id, user);
//        return "redirect:/admin";
//    }
        @PostMapping("/changeUser/{id}")
        public String editUser(@ModelAttribute("user") User user,
                               @RequestParam("listRoles") ArrayList<Long> roles) {
            userService.update(user, roleService.getRolesListById(roles));
            return "redirect:/admin";
}
}
