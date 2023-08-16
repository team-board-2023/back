package com.board.notice.Form;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class RandomPostForm {
    private String className;

    private String professor;

    private String endDate;

    private Long totalNum;

    private Long num;
}
