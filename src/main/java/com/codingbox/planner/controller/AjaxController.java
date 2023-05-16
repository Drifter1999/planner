package com.codingbox.planner.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
    @GetMapping("/header/cities")
    public JSONObject findAreaCategory (@RequestParam("province") String province, Model model) {
        System.out.println("name : " + province);
        JSONObject jsonObj = new JSONObject();

        return jsonObj;
    }
}
