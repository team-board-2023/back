package com.board.notice.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Entity
@Table(name="commentlist")
@Setter
@Getter
@Configuration
public class CommentList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identity;

    @Column
    @NonNull
    private String comment;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
