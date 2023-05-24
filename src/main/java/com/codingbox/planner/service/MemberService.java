package com.codingbox.planner.service;

import com.codingbox.planner.domain.Members;

import com.codingbox.planner.repository.MemberRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;

    public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public Members getMemberByName(String name) {
        return memberRepository.findByName(name);
    }

    public Members findByUserId(String userId) {
        return memberRepository.findByuserId(userId);
    }



    @Transactional
    public void memberModify(Members members) {
        //수정시에는 영속성 컨텍스트 User 오브젝트를 영속화 시키고, 영속화된 User 오브젝트를 수정
        //select를 해서 user오브젝트를 DB로부터 가져오는 이유는 영속화를 하기 위해서
        //영속화된 오브젝트를 변경하면 자동으로 DB에 update문을 날림
        Members persistance = memberRepository.findByuserId(members.getUserId());
        if (persistance == null) {
            throw new IllegalArgumentException("회원찾기 실패");
        }
        String encPassword = bCryptPasswordEncoder.encode(members.getPw());
        persistance.setPw(encPassword);

        //세션 등록
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(members.getUserId(), members.getPw()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //회원수정 합수 종료 = 서비스 종료 = 트랜잭션 종료 = commit 자동으로 됨
        //영속화된 persistance 객체의 변화가 감지되면 더티체킹이 되어 update문을 날림
    }

}


