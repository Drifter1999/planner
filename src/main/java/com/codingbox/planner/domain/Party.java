package com.codingbox.planner.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SequenceGenerator(
    name = "PARTY_SEQ_GENERATOR"
    , sequenceName = "PARTY_SEQ"
    , initialValue = 1
    , allocationSize = 1
)
public class Party {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE
        , generator = "PARTY_SEQ_GENERATOR"
    )
    @Column(name = "PARTY_ID")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "SCHEDULE_ID")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Members membersToParty;


}
