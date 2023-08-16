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
@Table(name="randompost")
@Setter
@Getter
@Configuration
public class RandomPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String className;

    @Column
    @NonNull
    private String professor;

    @Column
    @NonNull
    private String endDate;

    @Column
    @NonNull
    private Long totalNum;

    @Column
    @Builder.Default
    private Long num = 1L;

    @Column
    @Builder.Default
    private List<Long> usersStore = new ArrayList<>();

//    public RandomPost(){
//        List<Integer> usersStore = new ArrayList<>();
//    }
    public List<Long> addUser(Long userId){
        usersStore.add(userId);
        return usersStore;
    }
    public Long plusNum(){
        this.num += 1;
        return this.num;
    }
}
