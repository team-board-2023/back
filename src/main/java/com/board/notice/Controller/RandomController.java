package com.board.notice.Controller;

import com.board.notice.Entity.Random;
import com.board.notice.Form.RandomForm;
import com.board.notice.Service.RandomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RandomController {
    private final RandomService randomService;

    @PostMapping("random/create")
    public void create(@RequestBody RandomForm randomForm){
        randomService.create(randomForm);
    }

    //@PostMapping("random/addComment")
    // public void addUser(@RequestBody Long id, Long userId){ randomService.addUser(id, userId); }

    @PostMapping("random/showAll")
    public Random showAll(@RequestBody String id){
        return randomService.showAll(id);
    }

}
