package com.web;

import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users",userService.findAllUser()
                .stream().map((u)->u.getLoginname()).collect(Collectors.toList()));
        return "users";
    }

    @PostMapping("/users_activateuser")
    public void activateUserByLogin(@ModelAttribute("username") String username, Principal principal){
        userService.activateUser(username,principal);
    }

    @GetMapping("/cabinet")
    public String myCabinet(){
        return "cabinet";
    }




}
