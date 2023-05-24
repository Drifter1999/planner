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
@NoArgsConstructor
public class ScheduleDTO {

    private String userId;
    private String strDate;
    private String endDate;
    private String title;
    private String destination;
}
