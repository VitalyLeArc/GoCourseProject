package com.service;

import com.domain.Search;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RequestRiaService {
    public String createRiaRequest(Search search){
        StringBuilder sb = new StringBuilder();
        sb.append("${values.autoria}");
        sb.append("${values.supersecret}");


        log.info("ria request is:  "+sb.toString());



        return null;
    }

}
