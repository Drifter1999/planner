package com.codingbox.planner.service;

import com.codingbox.planner.domain.Members;
import com.codingbox.planner.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    @Autowired
    private final MemberRepository memberRepository;
    // 아이디 찾기
    public Members findId(String name, String email) {
        log.info("Login Service");
        return memberRepository.findByNameAndEmail(name, email);
    }

    public Members findPw(String userId, String email) {
        return memberRepository.findByUserIdAndEmail(userId, email);
    }
}
