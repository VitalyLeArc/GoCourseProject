package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class MainPage {

    @RequestMapping (method = RequestMethod.GET)
    public String MainPage(ModelMap model) {
    model.addAttribute("msg","AnyMessage");
    return "Test";
    }
}
