package com.service;

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

    public List<History> findAllHistoryByUserid(User user) {
        return historyRepository.findAllByUserId(user.getId());
    }

    public List<History> findAllHistoryByUseridAndSimilarTrue(User user){
        return historyRepository.findAllByUserIdAndShowSimilarTrue(user.getId());
    }
    public void switchShowSimilarHistoryById(History history) {
        history.setShowSimilar(!history.getShowSimilar());
        historyRepository.save(history);
    }
}
