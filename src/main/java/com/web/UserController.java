package com.web;

import com.domain.parts.UserRole;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.security.Principal;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model, Principal principal){
        if(userService.getUserRoleByName(principal.getName())== UserRole.ADMIN) {
            model.addAttribute("users", userService.findAllUser(principal)
                    .stream().map((u) -> u.getLoginname())
                    .collect(Collectors.toList()));
        }
        return "users";
    }

    @PostMapping("/users_activateuser")
    public void activateUserByLogin(@ModelAttribute("username") String username, Principal principal){
        if(userService.getUserRoleByName(principal.getName())== UserRole.ADMIN) {
            userService.activateUser(username);
        }
    }



}
