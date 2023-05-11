package com.codingbox.planner.domain.DTO;

import com.codingbox.planner.domain.MemberState;
import com.codingbox.planner.domain.Party;
import com.codingbox.planner.domain.Schedule;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MembersDTO {
    private String pw;
    private String name;
    private String phone;
    private String email;
    private String birth;
    private String gender;
}
