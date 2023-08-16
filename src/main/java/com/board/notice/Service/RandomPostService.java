package com.board.notice.Service;

import com.board.notice.Entity.RandomPost;
import com.board.notice.Form.RandomPostForm;
import com.board.notice.Repository.RandomPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RandomPostService {
    private final RandomPostRepository randomPostRepository;

    public void create(RandomPostForm randomPostForm){
        randomPostRepository.create(randomPostForm);
    }
    public void addUser(Long id, Long userId){
        randomPostRepository.addUser(id, userId);
    }
    public RandomPost showAll(Long id){
        return randomPostRepository.showAll(id);
    }
}
