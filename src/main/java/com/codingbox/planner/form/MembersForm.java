package com.codingbox.planner.form;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MembersForm {
    private String userId;
    private String pw;
    private String name;
    private String phone;
    private String email;
    private String birth;
    private String gender;
}
