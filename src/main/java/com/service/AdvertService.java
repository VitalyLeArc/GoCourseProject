package com.service;

import com.domain.Advert;
import com.repository.AdvertRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdvertService {
    @Autowired
    private AdvertRepository advertRepository;

    public List<Advert> findAllAdverts(){
        log.info("BEFORE aspect from "+this.getClass().toString());
        return advertRepository.findAll();
    }

    public List<Advert> findAllAdvertsByParam(){

        return List.of();
    }
}
