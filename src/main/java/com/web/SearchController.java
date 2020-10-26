package com.web;

import com.domain.Search;
import com.domain.Vehicle;
import com.domain.parts.*;
import com.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public String search(Model model){
        model.addAttribute("carBody", CarBody.values());
        model.addAttribute("category", Category.values());
        model.addAttribute("fuelTypes", FuelType.values());
        model.addAttribute("marks", Marks.values());
        model.addAttribute("motoBody", MotoBody.values());
        return "search";
    }

    @PostMapping("/search_request")
    public String searchRequest(@ModelAttribute("search")Search search, Principal principal, Model model){
        log.info("search is " + search.toString());
        List<Vehicle> vehicles = searchService.searchOnRia(search);
        searchService.saveSearchRequestInHistory(search,principal);
        model.addAttribute("vehicles",vehicles);
        log.info("first vehicle mark "+vehicles.get(0).getMarkName());
        return "result";
    }

}
