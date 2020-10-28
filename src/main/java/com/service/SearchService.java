package com.service;


import com.domain.Search;
import com.domain.Vehicle;
import com.repository.SearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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
public void saveSearchRequestInHistory(Search search, Principal principal){
    search.setUserId(userService.getUserIdByName(principal.getName()));
    search.setShowSimilar(true);
    log.info("body "+search.getBody()+" similar "+search.getShowSimilar()+" category "+search.getCategory());
    saveSearch(search);
}
private void saveSearch(Search search){
    search.setDate(LocalDate.now());
    searchRepository.save(search);
}
public void switchShowSimilar(Search search){
    search.setShowSimilar(!search.getShowSimilar());
    searchRepository.save(search);
}

/////////

public List<Search> getHistoryByUserId(Long userid){
    return searchRepository.findAllByUserId(userid);
}

//ищет все новые объявления для всех поисков
public List<Vehicle> searchNewForUserHistory(Long userid){
    List<Search> searches = searchRepository.findAllByUserIdAndShowSimilarTrue(userid);
    List<Vehicle> vehicles = searches.stream()
            .flatMap(search -> searchNewSimilar(search).stream())
            .collect(Collectors.toList());
    //может понадобиться отсеять дубликаты
    return vehicles;
}

//ищет все новые объявления соответствующие одному поиску
public List<Vehicle> searchNewSimilar(Search search){
    saveSearch(search);                                         //обновляет дату последнего поиска
    return requestRiaService.findOnRia(search)
            .stream()                                           //удалить после проверки
            .filter(v->                                         //https://habr.com/ru/company/luxoft/blog/270383/
                v.getAddDate().compareTo(search.getDate())>=0)  //https://beginnersbook.com/2017/10/java-localdate-compareto-method-example/
            .collect(Collectors.toList());
}

}
