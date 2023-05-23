package com.codingbox.planner.service;

import com.codingbox.planner.domain.Members;
import com.codingbox.planner.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MemberDetailsService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private HttpSession httpSession; // HttpSession 객체를 주입 받음

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Members members = memberRepository.findByuserId(userId);
        if (members == null) {
            String errorMessage = "User not found with username: " + userId;
            System.err.println(errorMessage); // 에러 메시지를 콘솔에 출력
            throw new UsernameNotFoundException("User not found with username: " + userId);
        }

        // memberinfo 로그인 정보 저장
        httpSession.setAttribute("memberinfo", members);

        return new MemberDetails(members);
    }
}