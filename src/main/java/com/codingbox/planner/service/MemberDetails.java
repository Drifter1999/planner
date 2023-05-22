package com.codingbox.planner.service;

import com.codingbox.planner.domain.Members;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class MemberDetails implements UserDetails {

    private final Members members;

    // 일반 로그인 생성자
    public MemberDetails(Members members) {
        this.members = members;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // User 권한을 리턴하는 메서드
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new SimpleGrantedAuthority((members.getRole())));
        return collect;
    }

    @Override
    public String getUsername() { // User PK 또는 고유한 값을 리턴
        return members.getUserId();
    }
    @Override
    public String getPassword() { // User 비밀번호 리턴
        return members.getPw();
    }
    @Override
    public boolean isAccountNonExpired() { // User 계정 만료 여부 리턴
        return true; // true : 만료 안됨
    }
    @Override
    public boolean isAccountNonLocked() { // User 계정 잠김 여부 리턴
        return true; // true : 잠기지 않음
    }
    @Override
    public boolean isCredentialsNonExpired() { // User 비밀번호 만료 여부 리턴
        return true; // true : 만료 안됨
    }
    @Override
    public boolean isEnabled() { // User 계정 활성화 여부 리턴
        return true; // true : 활성화 됨
    }

}
