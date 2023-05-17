package com.codingbox.planner.controller;

import com.codingbox.planner.Repository.MemberRepository;
import com.codingbox.planner.domain.DTO.AreaDTO;
import com.codingbox.planner.domain.Members;
import com.codingbox.planner.parser.ParsingToList;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AjaxController {
    private final MemberRepository memberRepository;

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

}


