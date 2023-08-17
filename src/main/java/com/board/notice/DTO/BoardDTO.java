package com.board.notice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private String id;

    private Long count;

    private String title;

    private String content;

    private String writetime;

    private String writer;
}
