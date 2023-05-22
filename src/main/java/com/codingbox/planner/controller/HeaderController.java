package com.codingbox.planner.controller;

import com.codingbox.planner.domain.DTO.AreaDTO;
import com.codingbox.planner.domain.DTO.SearchKeyWordDTO;
import com.codingbox.planner.service.ListingService;
import com.codingbox.planner.service.MultiSelectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/header")
@RequiredArgsConstructor
public class  HeaderController {
    private final ListingService listingService;
    private final MultiSelectService multiSelectService;

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/category")
    public String category(Model model) {
        List<AreaDTO> ApiArr = multiSelectService.getApiAreaResponse();
        model.addAttribute("ApiArr", ApiArr);
        return "category";
    }

    @GetMapping("/listing")
    public String listing(@RequestParam("area") String area,
            @RequestParam("content") String content,
            Model model) throws JsonProcessingException {

        List<SearchKeyWordDTO> ApiArr = listingService.getApiResponse(area, content);
        model.addAttribute("ApiArr", ApiArr);

        return "listing";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/blogDetails")
    public String blogDetails() {
        return "blogdetails";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/elements")
    public String elements() {
        return "elements";
    }

    @GetMapping("/listing_details")
    public String listing_details() {
        return "listing_details";
    }

    @GetMapping("/Calendar")
    public String Calendar() {
        return "Calendar";
    }

}
