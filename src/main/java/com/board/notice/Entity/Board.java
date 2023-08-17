package com.board.notice.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="board")
@Setter
@Getter
@Configuration
public class Board {

    @Id
    private String id;

    @Column
    private Long count;

    @Column
    @NonNull
    private String title;

    @Column
    @NonNull
    private String content;

    @Column
    @NonNull
    private String writetime;

    @Column
    @NonNull
    private String writer;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<CommentList> comments = new ArrayList<>();
}
