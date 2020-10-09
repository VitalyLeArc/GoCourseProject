package com.service;


import com.domain.Search;
import com.domain.Vehicle;
import com.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SearchService {
@Autowired
    private SearchRepository searchRepository;
@Autowired
private UserService userService;
@Autowired
private RequestRiaService requestRiaService;

public List<Vehicle> searchOnRia(Search reqSearch){
    return requestRiaService.findOnRia(reqSearch);
}
//не проверял
public void saveSearchRequestInHistory(Search search, Principal principal){
    search.setUserId(userService.getUserIdByName(principal.getName()));
    search.setShowSimilar(true);
    search.setDate(LocalDateTime.now());
    searchRepository.save(search);
}
public List<Search> getHistoryByUserId(Long userid){
    return searchRepository.findAllByUserIdAndShowSimilarTrue(userid);
}

}
