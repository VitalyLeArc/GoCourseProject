package com.web;

import com.service.SearchService;
import com.service.UserService;
import com.utils.SearchesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class UserCabinetController {
    @Autowired
    SearchService searchService;
    @Autowired
    UserService userService;
    @Autowired
    SearchesParser searchesParser;

    @GetMapping("/cabinet")
    public String myCabinet(){
        return "cabinet";
    }


    //в истории хранится по айди пользователя
    @GetMapping("/cabinet/history")
    public String getMyHistory(Principal principal, Model model){
        //в модель заходит List<SearchString>
         model.addAttribute("userhistory",
                 searchService.getHistoryByUserId(
                         userService.getUserIdByName(principal.getName()))
                         .stream().map(s->searchesParser.parseToSearchString(s))
                         .collect(Collectors.toList()));
        return "history";
    }

}
