package com.board.notice.Service;

import com.board.notice.DTO.BoardDTO;
import com.board.notice.Entity.Board;
import com.board.notice.Entity.CommentList;
import com.board.notice.Form.BoardForm;
import com.board.notice.Form.CommentForm;
import com.board.notice.Form.ShowCommentForm;
import com.board.notice.Repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<String> showAll(ShowCommentForm showCommentForm){
       return boardRepository.showComment(showCommentForm);
    }
    public List<BoardDTO> showAll(){
        return boardRepository.showAll();
    }

}
