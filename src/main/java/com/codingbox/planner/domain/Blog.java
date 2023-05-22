package com.codingbox.planner.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@SequenceGenerator(
        name = "BLOG_SEQ_GENERATOR"
        , sequenceName = "Blog_SEQ"
        , initialValue = 101
        , allocationSize = 1
)
public class Blog {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "BLOG_SEQ_GENERATOR"
    )
    @Column(name = "BLOG_ID")
    private Long blogId;

    @Column(name="BLOG_TITLE")
    private String title;

    @Column(columnDefinition = "CLOB", name="BLOG_CONTENT")
    private String content;

    @Column(name="IMG_PATH")
    private String imgpath;

    @Column(name="IMG_NAME")
    private String imgname;

    @Column(name = "UPDATE_DATE")
    private String date;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Members membersToBoard;

    private LocalDateTime time;
}
