package com.board.notice.Repository;

import com.board.notice.Entity.RandomPost;
import com.board.notice.Form.RandomPostForm;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RandomPostRepository {

    private final EntityManager em;

    public RandomPost create(RandomPostForm randomPostForm){
        RandomPost RandomPost = new RandomPost();
        RandomPost.setClassName(randomPostForm.getClassName());
        RandomPost.setProfessor(randomPostForm.getProfessor());
        RandomPost.setEndDate(randomPostForm.getEndDate());
        RandomPost.setNum(randomPostForm.getNum());

        em.merge(RandomPost);
        return RandomPost;
    }

    public List<Long> addUser(Long id, Long userId){
       return findById(id).map(randomPost ->
                {randomPost.addUser(userId); randomPost.plusNum();
                    if(randomPost.getNum().equals(randomPost.getTotalNum()))
                    {return randomPost.getUsersStore();}
                    else return randomPost.getUsersStore();
                })
               .orElseThrow(() -> new IllegalStateException("해당하는 id가 없습니다."));
    }

    public RandomPost showAll(Long id){
        return findById(id)
                .orElseThrow(()-> new IllegalStateException("해당하는 id가 없습니다."));
    }

    public Optional<RandomPost> findById(Long id){
        RandomPost randomPost = em.find(RandomPost.class, id);
        return Optional.ofNullable(randomPost);
    }
}
