package com.board.notice.Controller;

import com.board.notice.Entity.Board;
import com.board.notice.Entity.CommentList;
import com.board.notice.Form.BoardForm;
import com.board.notice.Form.CommentForm;
import com.board.notice.Form.ShowCommentForm;
import com.board.notice.Service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("board/create")
    public Board create(@RequestBody BoardForm boardForm){
        return boardService.create(boardForm);
    }

    @PostMapping("board/addComment")
    public void addComment(@RequestBody CommentForm commentForm){ boardService.addComment(commentForm); }

    @PostMapping("board/showComment")
    public Map<Board, String> showComment(@RequestBody ShowCommentForm showCommentForm){
        return boardService.showAll(showCommentForm);
    }

}
