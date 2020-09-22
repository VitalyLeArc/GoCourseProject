package com.web;

import com.domain.Search;
import com.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public void search(){

    }
    @GetMapping("/search_simplerequest")
    public void searchHardcodeSimpleRequest(){
        Search searchHardcode = new Search();
        searchHardcode.setMark(98);
        searchHardcode.setBody(-1);
        searchHardcode.setFuelType(1);
        searchHardcode.setVehicleType(-1);
        searchService.searchOnRia(searchHardcode);
    }

}
