package com.codingbox.planner.domain;

import com.codingbox.planner.domain.enums.MemberStateEnum;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class MemberState {
    @Id
    @Column(name = "STATE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private MemberStateEnum memberState;

    @OneToOne(mappedBy = "memberState")
    private Members members;
}
