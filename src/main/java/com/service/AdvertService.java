package com.service;

import com.domain.Advert;
import com.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdvertService {
    @Autowired
    private AdvertRepository advertRepository;

    public List<Advert> findAllAdvertsByParam(){

        return List.of();
    }
}
