package com.board.notice.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClassInfo {
    private String className;
    private String division = "001";
    private String subject;
    private String major;
    private String professor;
    private Integer divide = 1;

    public void setClassInfo(String className, String division, String subject,
                                   String major, String professor, Integer divide){
        this.className = className; this.division = division; this.subject = subject;
        this.major = major; this.professor = professor; this.divide = divide;
    }
}
