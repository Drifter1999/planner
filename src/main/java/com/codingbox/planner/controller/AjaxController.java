package com.codingbox.planner.controller;

import com.codingbox.planner.domain.DTO.ResponseDTO;
import com.codingbox.planner.domain.DTO.ScheduleCartDTO;
import com.codingbox.planner.domain.Members;
import com.codingbox.planner.parser.ParsingToList;
import com.codingbox.planner.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AjaxController {
    private MemberService memberService;
    private final HttpSession httpSession;

    @GetMapping("/cities")
    public List<String> findAreaCategory (@RequestParam("province") String province,
                                          Model model) {
        List<String> AreaList = new ParsingToList().AreaJsonArray(province);
        return AreaList;
    }


    // boolean으로 중복 여부 체크

    @GetMapping("/checkUserId")
    public boolean checkUserId(@RequestParam("result") String userId) {
        Members existingUser = memberService.findByUserId(userId);
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

    @PostMapping("/remove")
    public ResponseEntity<?> removeCartItem(@RequestBody Map<String, Long> request) {
        int id = Integer.parseInt(String.valueOf(request.get("id")));
        // 세션에서 필요한 값 가져오기
        List<ScheduleCartDTO> cartArrSec = (List<ScheduleCartDTO>) httpSession.getAttribute("CartArrSec");
        // 처리 로직 작성
        for (int i = 0 ; i < cartArrSec.size(); i++) {
            if (id == cartArrSec.get(i).getScheduleCartId()) {
                cartArrSec.remove(i);
            }
        }

        if (cartArrSec != null) {
            httpSession.setAttribute("CartArr", cartArrSec);
        }else {
            RedirectView redirectView = new RedirectView("/home");
            return new ResponseEntity<>(redirectView, HttpStatus.OK);
        }

        // 응답 반환
        Map<String, Object> response = new HashMap<>();

        response.put("success", true); // 또는 false
        response.put("CartArr", cartArrSec);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/member")
    public ResponseDTO<Integer> updatePassword(@RequestBody Members member) {
        memberService.memberModify(member);

        // 세션값을 바꿔줘야 함
        return new ResponseDTO<>(String.valueOf(HttpStatus.OK.value()), Arrays.asList(1));
    }
}


