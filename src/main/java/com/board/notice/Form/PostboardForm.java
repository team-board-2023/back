package com.board.notice.Form;


import lombok.Getter;

import java.util.List;

@Getter
public class PostboardForm {          // id는 자동 생성

    private String title;

    private String story;

    private String writeDate;

    private String endDate;

    private List<String> comments;
}
