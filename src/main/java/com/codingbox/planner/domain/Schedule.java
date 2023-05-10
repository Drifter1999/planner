package com.codingbox.planner.domain;

import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "SCHEDULE_START")
    private LocalDateTime strDate;

    @Column(name = "SCHEDULE_END")
    private LocalDateTime endDate;

    @Column(name = "SCHEDULE_NAME")
    private LocalDateTime name;

    @Column(name = "SCHEDULE_DEST")
    private LocalDateTime destination;

    @OneToMany(mappedBy = "schedule")
    private List<Party> parties = new ArrayList<>();
}
