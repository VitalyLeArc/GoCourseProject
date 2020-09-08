package com.service;

import com.domain.Advert;
import com.domain.History;
import com.domain.User;
import com.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    History history;
    private LocalDate localDate;
//очень грубо И топорно
    //нужна ещё одна связанная таблица куда будет просто кидаться просто запрос или тупо записывать строку JSON
    public void saveOneSearchInHistory(Advert advert,User user){
        localDate = LocalDate.now();
        history.setUserId(user.getId());
        history.setBrand(advert.getBrand());
        history.setModel(advert.getModel());
        history.setType(advert.getType());
        history.setVehicle(advert.getVehicle());
        historyRepository.save(history);
    }

    public List<History> findAllHistoryByUserid(User user){
        return historyRepository.findAllByUserId(user.getId());
    }
    public void switchShowSimilarHistoryById(History history){

    }
}
