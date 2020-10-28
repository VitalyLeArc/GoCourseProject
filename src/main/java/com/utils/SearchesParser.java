package com.utils;

import com.domain.Search;
import com.domain.SearchString;
import com.domain.parts.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SearchesParser {
    public SearchString parseToSearchString(Search search){
        SearchString searchString = new SearchString();
        searchString.setCategory(Category.getNameByValue(search.getCategory()));
        if(search.getCategory()==1){
            searchString.setBody(CarBody.getNameByValue(search.getBody()));
        }
        else {
            searchString.setBody(MotoBody.getNameByValue(search.getBody()));
        }
        searchString.setFuelType(FuelType.getNameByValue(search.getFuelType()));
        searchString.setMark(Marks.getNameByValue(search.getMark()));
        searchString.setId(search.getId());
        searchString.setUserId(search.getUserId());
        searchString.setDate(search.getDate().toString());
        searchString.setShowSimilar(search.getShowSimilar());
        log.info(searchString.toString());
        return searchString;
    }

}
