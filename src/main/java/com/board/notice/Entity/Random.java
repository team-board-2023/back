package com.board.notice.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="random")
@Setter
@Getter
@Configuration
public class Random {

    @Id
    private String id;

    @Column
    @NonNull
    private String classname;

    @Column
    @NonNull
    private String professor;

    @Column
    @NonNull
    private String dividedclass;

    @Column
    @NonNull
    private String deadline;

    @Column
    private Long personnel;

    @Column
    private String participants;
}
