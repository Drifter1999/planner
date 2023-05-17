package com.codingbox.planner.controller;

import com.codingbox.planner.Repository.MemberRepository;
import com.codingbox.planner.domain.Members;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
    public AjaxController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/header/cities")
    public JSONObject findAreaCategory (@RequestParam("province") String province, Model model) {
        System.out.println("name : " + province);
        JSONObject jsonObj = new JSONObject();

        return jsonObj;
    }


    // boolean으로 중복 여부 체크
    @Autowired
    private final MemberRepository memberRepository;
    @GetMapping("/checkUserId")
    public boolean checkUserId(@RequestParam("result") String userId) {
        Members existingUser = memberRepository.findByuserId(userId);
        System.out.println("jhkjgkj:"+userId);
        return existingUser == null;
    }

}


