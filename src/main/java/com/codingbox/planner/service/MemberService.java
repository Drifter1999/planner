package com.codingbox.planner.service;

import com.codingbox.planner.domain.Members;
import com.codingbox.planner.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Members getMemberByName(String name) {
        return memberRepository.findByName(name);
    }

    public Members findByUserId(String userId) {
        return memberRepository.findByuserId(userId);
    }

    // 마이페이지 구현 도중 오류나서 잠시 주석처리
//    public Members createMember(String name) {
//        Members member = new Members();
//        member.setName(name);
//        return memberRepository.save(member);
//    }
}
