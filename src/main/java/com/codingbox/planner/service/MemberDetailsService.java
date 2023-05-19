package com.codingbox.planner.service;

import com.codingbox.planner.repository.MemberRepository;
import com.codingbox.planner.domain.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailsService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String member_id) throws UsernameNotFoundException {
        Members members = memberRepository.findByuserId(member_id);
        if(members != null) {
            return new MemberDetails(members);
        }
        return null;
    }
}