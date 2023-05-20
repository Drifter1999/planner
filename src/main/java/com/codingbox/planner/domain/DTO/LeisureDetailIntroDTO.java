package com.codingbox.planner.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeisureDetailIntroDTO {
    private String contentid;
    private String contenttypeid;
    private String openperiod;
    private String reservation;
    private String infocenterleports;
    private String scaleleports;
    private String accomcountleports;
    private String restdateleports;
    private String usetimeleports;
    private String expagerangeleports;
    private String parkingleports;
    private String parkingfeeleports;
    private String chkbabycarriageleports;
    private String chkpetleports;
    private String chkcreditcardleports;

}
