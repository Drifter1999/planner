package com.codingbox.planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/header")
public class HeaderController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/category")
    public String category() {
        return "category";
    }

    @GetMapping("/listing")
    public String listing() {
        return "listing";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

//    @GetMapping("/blogDetails")
//    public String blogDetails() {
//        return "blogdetails";
//    }

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
