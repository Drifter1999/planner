package com.codingbox.planner.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SequenceGenerator(
        name = "SHARED_SCHEDULE_SEQ_GENERATOR"
        , sequenceName = "SHARED_SCHEDULE_SEQ"
        , initialValue = 1
        , allocationSize = 1
)
public class ShareSchedule {
    @javax.persistence.Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "SHARED_SCHEDULE_SEQ_GENERATOR"
    )
    @Column(name = "SHARE_SCHEDULE_ID")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "SCHEDULE_ID")
    private Schedule scheduleToShare;

    @Column(name = "SCHEDULE_START")
    private String strDate;

    @Column(name = "SCHEDULE_END")
    private String endDate;

    @Column(name = "SCHEDULE_TITLE")
    private String title;

    @Column(name = "SCHEDULE_DEST")
    private String destination;



}
