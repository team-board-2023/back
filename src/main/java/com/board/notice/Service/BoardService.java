package com.board.notice.Service;

import com.board.notice.Entity.Board;
import com.board.notice.Entity.CommentList;
import com.board.notice.Form.BoardForm;
import com.board.notice.Form.CommentForm;
import com.board.notice.Form.ReturnCommentForm;
import com.board.notice.Form.ShowCommentForm;
import com.board.notice.Repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board create(BoardForm boardForm){
        return boardRepository.create(boardForm);
    }
    @Transactional
    public void addComment(CommentForm commentForm){
        boardRepository.addComment(commentForm);
    }
    @Transactional
    public List<CommentList> showAll(ShowCommentForm showCommentForm){
       return boardRepository.showComment(showCommentForm);
    }

}
