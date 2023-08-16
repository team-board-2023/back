package com.board.notice.Service;

import com.board.notice.Entity.Postboard;
import com.board.notice.Form.PostboardForm;
import com.board.notice.Repository.PostboardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostboardService {

    private final PostboardRepository postboardRepository;

    public void create(PostboardForm postboardForm){
        postboardRepository.create(postboardForm);
    }
    public void addComment(Long id, String comment){
        postboardRepository.addComment(id, comment);
    }
    public Postboard showAll(Long id){
       return postboardRepository.showAll(id);
    }

}
