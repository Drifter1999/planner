package com.codingbox.planner.domain.DTO;

import com.codingbox.planner.domain.Members;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    private Long blogId;
    private Members members;
    private String title;
    private String content;
    private String imgpath;
    private LocalDateTime date;
}
