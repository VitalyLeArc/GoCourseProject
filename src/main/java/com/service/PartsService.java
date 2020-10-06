package com.service;

import com.domain.parts.Mark;
import com.repository.parts.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {
    @Autowired
    private MarkRepository markRepository;

    public List<Mark> getAllMarks(){
        return markRepository.findAll();
    }

    public void loadMarksInDB (){
        //взять сриа
        //
        List<Mark> marks= List.of();
        //
        //
        markRepository.saveAll(marks);
    }
}
