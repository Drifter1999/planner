package com.codingbox.planner.controller;

import com.codingbox.planner.repository.MemberRepository;
import com.codingbox.planner.domain.Members;
import com.codingbox.planner.parser.ParsingToList;
import com.codingbox.planner.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AjaxController {
    private final MemberRepository memberRepository;
    private MemberService memberService;

    @GetMapping("/cities")
    public List<String> findAreaCategory (@RequestParam("province") String province, Model model) {
        List<String> AreaList = new ParsingToList().AreaJsonArray(province);
        return AreaList;
    }


    // boolean으로 중복 여부 체크

    @GetMapping("/checkUserId")
    public boolean checkUserId(@RequestParam("result") String userId) {
        Members existingUser = memberRepository.findByuserId(userId);
        System.out.println("jhkjgkj:"+userId);
        return existingUser == null;
    }

//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    @PostMapping
//    public Member createMember(@RequestParam String name) {
//        return memberService.createMember(name);
//    }
//
//    @GetMapping("/{name}")
//    public Member getMemberByName(@PathVariable String name) {
//        return memberService.getMemberByName(name);
//    }

    // bean을 못 찾아서 Autowired 추가
    // Autowired를 사용하려면 set@@@으로 써야함
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

}


