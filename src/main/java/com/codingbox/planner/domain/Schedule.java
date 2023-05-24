package com.codingbox.planner.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SequenceGenerator(
        name = "SCHEDULE_SEQ_GENERATOR"
        , sequenceName = "SCHEDULE_SEQ"
        , initialValue = 1
        , allocationSize = 1
)
@ToString
public class Schedule {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "SCHEDULE_SEQ_GENERATOR"
    )
    @Column(name = "SCHEDULE_ID")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Members membersToSchedule;

    @OneToMany(mappedBy = "scheduleToShare")
    private List<ShareSchedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "schedule")
    private List<Party> parties = new ArrayList<>();
}