package com.board.notice.Controller;

import com.board.notice.Entity.RandomPost;
import com.board.notice.Form.RandomPostForm;
import com.board.notice.Service.RandomPostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RandomPostController {
    private final RandomPostService randomPostService;

    @PostMapping("randomPost/create")
    public void create(RandomPostForm randomPostForm){
        randomPostService.create(randomPostForm);
    }

    @PostMapping("randomPost/addComment")
    public void addUser(Long id, Long userId){ randomPostService.addUser(id, userId); }

    @PostMapping("randomPost/showAll")
    public RandomPost showAll(Long id){
        return randomPostService.showAll(id);
    }

}
