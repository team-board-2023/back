package com.board.notice.Repository;

import com.board.notice.Entity.Postboard;
import com.board.notice.Entity.Users;
import com.board.notice.Form.PostboardForm;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
public class PostboardRepository {

    private final EntityManager em;

    public Postboard create(PostboardForm postboardForm){
        Postboard postboard = new Postboard();
        postboard.setComments(postboardForm.getComments());
        postboard.setTitle(postboardForm.getTitle());
        postboard.setStory(postboardForm.getStory());
        postboard.setWriteDate(postboardForm.getWriteDate());
        postboard.setEndDate(postboardForm.getEndDate());

        em.merge(postboard);
        return postboard;
    }

    public List<String> addComment(Long id, String comment){
        return findById(id).map(postboard ->
                {postboard.store(comment); return postboard.getComments();})
                .orElseThrow(()->new IllegalStateException("해당하는 id가 없습니다."));
    }

    public Postboard showAll(Long id){
        return findById(id)
                .orElseThrow(()-> new IllegalStateException("해당하는 id가 없습니다."));
    }

    public Optional<Postboard> findById(Long id){
        Postboard postboard = em.find(Postboard.class, id);
        return Optional.ofNullable(postboard);
    }
}
