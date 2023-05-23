package com.codingbox.planner.controller;

import com.codingbox.planner.domain.Members;
import com.codingbox.planner.repository.MemberRepository;
import com.codingbox.planner.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    @Autowired
    private final LoginService loginService;

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/findid")
    public String showFindIdForm() {

        return "login/findid";
    }

    @PostMapping("/findid")
    public String findId(@RequestParam("name") String name,@RequestParam("email") String email, Model model) {

        Members members = loginService.findId(name, email);

        if (members != null) {
            model.addAttribute("members", members);
        } else {
            model.addAttribute("error", "사용자를 찾을 수 없습니다.");
        }

        log.info("Login controller");

        return "login/findidcom";
    }

    @GetMapping("/findpw")
    public String showFindPWForm() {
        return "login/findpw";
    }

    @PostMapping("/findpw")
    public String findpw(String userId, String email, Model model) {

        Members members = loginService.findPw(userId, email);

        if(members != null) {
            String tempPw = members.createtempPw();
            String encPassword = bCryptPasswordEncoder.encode(tempPw);
            members.setPw(encPassword);
            memberRepository.save(members);

            model.addAttribute("tempPw", tempPw);

            return "login/findpwcom";

        } else {
            model.addAttribute("error", "아이디와 이메일이 일치하는 사용자를 찾을 수 없습니다.");
            return "login/findpw";
        }
    }





}
