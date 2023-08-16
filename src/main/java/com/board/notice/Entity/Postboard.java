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
@Table(name="postboard")
@Setter
@Getter
@Configuration
public class Postboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String title;

    @Column
    @NonNull
    private String story;

    @Column
    @NonNull
    private String writeDate;

    @Column
    @NonNull
    private String endDate;

    @Column
    @Builder.Default
    private List<String> comments = new ArrayList<>();

//    public Postboard(){
//        List<String> commentsStore = new ArrayList<>();
//    }
    public List<String> store(String comment){
        comments.add(comment);
        return comments;
    }

}
