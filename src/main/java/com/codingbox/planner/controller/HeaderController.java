package com.codingbox.planner.controller;

import com.codingbox.planner.domain.DTO.ApiDTO;
import com.codingbox.planner.service.ListingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/header")
@RequiredArgsConstructor
public class HeaderController {
    private final ListingService openApiServiceGangWon;

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/category")
    public String category() {
        return "category";
    }

    @GetMapping("/listing")
    public String listing(Model model) throws JsonProcessingException {
        List<ApiDTO> ApiArr = openApiServiceGangWon.getApiResponse("강원", "관광지");
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

}
