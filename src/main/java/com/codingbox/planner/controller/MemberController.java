package com.codingbox.planner.controller;

import com.codingbox.planner.domain.Members;
import com.codingbox.planner.repository.MemberRepository;
import com.codingbox.planner.service.MemberDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    private MemberService memberService;

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager() {
        return "manager";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login/login";
    }

    @GetMapping("/home.in")
    public String LoginSucess() {
        return "/home";
    }

    @GetMapping("/login.out")
    public String LogOutSucess() {
        return "/home";
    }

    @GetMapping("/signup")
    public String joinForm() {
        return "signup/signup";
    }

    @PostMapping("/signup")
    public String join(Members members) {
        System.out.println(members);
        members.setRole("ROLE_USER");
        String rawPassword = members.getPw();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        members.setPw(encPassword);
        memberRepository.save(members);
        return "redirect:/login";
    }

    @GetMapping("/members")
    public @ResponseBody String user(@AuthenticationPrincipal MemberDetails memberDetails) {
        System.out.println("principalDetails : " + memberDetails.getMembers());
        return "members";

    }

}
