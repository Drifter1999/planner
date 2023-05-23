package com.codingbox.planner.controller;

import com.codingbox.planner.domain.DTO.AreaDTO;
import com.codingbox.planner.domain.DTO.ScheduleCartDTO;
import com.codingbox.planner.domain.DTO.ScheduleDTO;
import com.codingbox.planner.domain.DTO.SearchKeyWordDTO;
import com.codingbox.planner.service.ListingService;
import com.codingbox.planner.service.MultiSelectService;
import com.codingbox.planner.service.ScheduleCartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/header")
@RequiredArgsConstructor
public class  HeaderController {
    private final ListingService listingService;
    private final MultiSelectService multiSelectService;

    private final ScheduleCartService scheduleCartService;

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
    public String listingDetailsRedirect() {
        return "redirect:/listing/details";
    }

    @PostMapping("/Calendar")
    public String Calendar(@RequestParam("startDate") String startDate,
                           @RequestParam("endDate") String endDate,
                           @RequestParam("contentTitleList") String contentTitleList,
                           @RequestParam("ContentType") String ContentType,
                           Model model) throws ParseException {
        contentTitleList = contentTitleList.substring(0, contentTitleList.length()-2);
        contentTitleList = contentTitleList.replaceAll("\"", "");
        String contentName = "";
        switch (ContentType) {
            case "12" : contentName = "관광지"; break;
            case "28" : contentName = "레포츠"; break;
            case "32" : contentName = "숙박"; break;
            case "39" : contentName = "음식점"; break;
            default:
                System.out.println("잘못된 값입니다.");
        }
        System.out.println(startDate+" : "+endDate);
        List<ScheduleCartDTO> CartArr = scheduleCartService.createCartList(startDate, endDate, contentTitleList, contentName);

        model.addAttribute("cartArr", CartArr);

        return "Calendar";
    }

}
