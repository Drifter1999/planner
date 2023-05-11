package com.codingbox.planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/login")
    public String Login() {
        return "login/login";
    }

    @GetMapping("/findid")
    public String findId(){return "login/find_id";}

    @GetMapping("/findpw")
    public String findPw(){return "login/find_pw";}

    @GetMapping("/findidcom")
    public String findidcom(Model model) {
        model.addAttribute("data", "<h2>Hello Spring</h2>");
        return "login/find_id_com";
    }

    @GetMapping("/findpwcom")
    public String findpwcom() {
        return "login/find_pw_com";
    }
}
