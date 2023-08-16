package com.board.notice.Service;

import com.board.notice.Entity.Random;
import com.board.notice.Form.RandomForm;
import com.board.notice.Repository.RandomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RandomService {
    private final RandomRepository randomRepository;

    public void create(RandomForm randomForm){
        randomRepository.create(randomForm);
    }
//    public void addUser(Long id, Long userId){
//        randomRepository.addUser(id, userId);
//    }
    public Random showAll(String id){
        return randomRepository.showAll(id);
    }
}
