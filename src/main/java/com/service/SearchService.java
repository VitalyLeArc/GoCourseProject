package com.service;


import com.domain.Search;
import com.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
@Autowired
    private SearchRepository searchRepository;
@Autowired
private RequestRiaService requestRiaService;

public List<Search> searchOnRia(Search reqSearch){
    requestRiaService.findOnRia(reqSearch);
    return List.of();
}
}
