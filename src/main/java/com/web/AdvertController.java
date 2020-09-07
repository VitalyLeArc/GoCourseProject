package com.web;

import com.domain.Advert;
import com.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adverts")
public class AdvertController  {
    @Autowired
    private AdvertService advertService;
//не проверял
   @GetMapping
    public List<Advert> getAllAdverts(){
        return advertService.findAllAdverts();
    }
/*
    @GetMapping
    public List<Advert> getAdvertsByParam(){
        return List.of();
    }*/
}
