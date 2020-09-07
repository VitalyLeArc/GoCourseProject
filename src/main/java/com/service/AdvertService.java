package com.service;

import com.domain.Advert;
import com.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertService {
    @Autowired
    private AdvertRepository advertRepository;

    public List<Advert> findAllAdverts(){
        return advertRepository.findAll();
    }

    public List<Advert> findAllAdvertsByParam(){

        return List.of();
    }
}
