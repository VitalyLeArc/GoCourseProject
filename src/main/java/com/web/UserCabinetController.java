package com.web;

import com.service.SearchService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class UserCabinetController {
    @Autowired
    SearchService searchService;
    @Autowired
    UserService userService;

    @GetMapping("/cabinet")
    public String myCabinet(){
        return "cabinet";
    }


    //в истории хранится с айди пользователя и искать надо по айди пользователя
    //логин, ник может меняться в отличии от айди
    @GetMapping("/cabinet/history")
    public String getMyHistory(Principal principal, Model model){
         model.addAttribute(searchService.getHistoryByUserId(userService.getUserIdByName(principal.getName())));
        return "history";
    }

}
