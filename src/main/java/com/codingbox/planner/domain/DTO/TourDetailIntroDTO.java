package com.codingbox.planner.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourDetailIntroDTO {
    private String contentid;
    private String contenttypeid;
    private String heritage1;
    private String heritage2;
    private String heritage3;
    private String infocenter;
    private String opendate;
    private String restdate;
    private String expguide;
    private String expgerange;
    private String accomcount;
    private String useseason;
    private String usetime;
    private String parking;
    private String chkbabycarriage;
    private String chkpet;
    private String chkcreditcard;

}
