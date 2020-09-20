package com.web;

import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAllUser();
    }
    @GetMapping("/set")
    public void activateUserByLogin(HttpServletRequest request){
        userService.activateUser("temp");
    }

    @GetMapping("/cabinet")
    public String myCabinet(){
        return "cabinet";
    }




}
