package com.codingbox.planner.domain;

import com.codingbox.planner.domain.enums.MemberGender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Members {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;

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
}
