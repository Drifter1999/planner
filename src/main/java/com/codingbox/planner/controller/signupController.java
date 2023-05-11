package com.codingbox.planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class signupController {
    @GetMapping("/signup")
    public String signup() {

        return "signup/signup";
    }
}
