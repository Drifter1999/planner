package com.codingbox.planner.form;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleForm {
    private LocalDateTime strDate;
    private LocalDateTime endDate;
    private LocalDateTime name;
    private LocalDateTime destination;
}
