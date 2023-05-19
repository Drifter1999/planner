package com.codingbox.planner.domain;

import com.codingbox.planner.domain.enums.MemberGender;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Members {
    @Id
    @Column(name = "MEMBER_ID", unique = true)
    private String userId;

    @Column(name = "MEMBER_PW")
    private String pw;

    @Column(name = "MEMBER_NAME")
    private String name;

    @Column(name = "MEMBER_PHONE")
    private String phone;

    @Column(name = "MEMBER_EMAIL")
    private String email;

    @Column(name = "MEMBER_BIRTH")
    private String birth;

    @Column(name = "MEMBER_ROLE")
    private String role;

    @Enumerated(EnumType.STRING)
    @Column(name = "MEMBER_GENDER")
    private MemberGender gender;

    @OneToOne
    @JoinColumn(name = "STATE_ID")
    private MemberState memberState;

    @OneToMany(mappedBy = "membersToSchedule")
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "membersToParty")
    private List<Party> parties = new ArrayList<>();

    @Builder
    public Members(String id, String pw, String name, String phone, String email, String birth, MemberGender gender, String role){
        this.userId = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
        this.role = role;
    }
}