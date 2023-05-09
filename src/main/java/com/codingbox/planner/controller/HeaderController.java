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
}
