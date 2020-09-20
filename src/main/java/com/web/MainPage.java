package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/")
public class MainPage {

    @GetMapping
    public String MainPage(@RequestHeader Map<String,String> headers) {
    return "index";
    }
}
