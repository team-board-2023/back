package com.board.notice.Controller;

import com.board.notice.Entity.Postboard;
import com.board.notice.Form.PostboardForm;
import com.board.notice.Service.PostboardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostboardController {

    private final PostboardService postboardService;

    @PostMapping("postboard/create")
    public void create(PostboardForm postboardForm){
        postboardService.create(postboardForm);
    }

    @PostMapping("postboard/addComment")
    public void addComment(Long id, String comment){ postboardService.addComment(id, comment); }

    @PostMapping("postboard/showAll")
    public Postboard showAll(Long id){
        return postboardService.showAll(id);
    }

}
