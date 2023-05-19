package com.codingbox.planner.domain.DTO;

import com.codingbox.planner.domain.enums.MemberGender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MembersDTO {
    private String userId;
    private String pw;
    private String name;
    private String phone;
    private String email;
    private String birth;
    private MemberGender gender;

}
