package com.codingbox.planner.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PartyDTO {
    private Long Id;
    private String memberId;
    private String scheduleId;
}
