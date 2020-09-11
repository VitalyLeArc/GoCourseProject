package com.web;

import com.domain.Advert;
import com.service.AdvertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/adverts")
public class AdvertController  {
    @Autowired
    private AdvertService advertService;
   @GetMapping
    public List<Advert> getAllAdverts(){
       log.info("BEFORE aspect from "+this.getClass().toString());
        return advertService.findAllAdverts();
    }

}
