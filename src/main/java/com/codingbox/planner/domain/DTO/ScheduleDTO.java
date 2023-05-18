package com.codingbox.planner.domain.DTO;

import com.codingbox.planner.domain.Members;
import com.codingbox.planner.domain.Party;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleDTO {
    private LocalDateTime strDate;
    private LocalDateTime endDate;
    private String name;
    private String destination;
}
