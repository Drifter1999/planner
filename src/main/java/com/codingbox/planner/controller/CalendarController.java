package com.codingbox.planner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/header/Calendar")
@RequiredArgsConstructor
public class CalendarController {

    @GetMapping("/schedule")
    public String schedule() {
        return "schedule";
    }
}