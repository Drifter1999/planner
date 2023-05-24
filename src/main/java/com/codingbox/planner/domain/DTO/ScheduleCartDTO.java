package com.codingbox.planner.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleCartDTO {

    //추가
    private int ScheduleCartId;
    private String strDate;
    private String endDate;
    private String contentTitleList;
    private String contentName;

}
