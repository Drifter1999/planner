package com.codingbox.planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/header/listing")
public class ListingController {

    @GetMapping("/hotel")
    public String hotel() {
        return "hotel";
    }

    @GetMapping("/nightLife")
    public String nightLife() {
        return "nightLife";
    }

    @GetMapping("/culturePlace")
    public String culturePlace() {
        return "culturePlace";
    }

    @GetMapping("/Restaurant")
    public String Restaurant() {
        return "Restaurant";
    }

}