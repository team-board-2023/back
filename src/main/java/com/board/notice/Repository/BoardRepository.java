package com.board.notice.Repository;

import com.board.notice.DTO.BoardDTO;
import com.board.notice.Entity.Board;
import com.board.notice.Entity.CommentList;
import com.board.notice.Form.BoardForm;
import com.board.notice.Form.CommentForm;
import com.board.notice.Form.ShowCommentForm;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public Board create(BoardForm boardForm){
        Board board = new Board();

        board.setId(createId());
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent());
        board.setWritetime(boardForm.getWritetime());
        board.setWriter(boardForm.getWriter());

        em.merge(board);
        return board;
    }

    public String createId(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit,rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public void addComment(CommentForm commentForm){
        Optional<Board> board = findById(commentForm.getId());
        Board commentboard = board.orElseThrow(() ->
                new IllegalStateException("Board를 찾을 수 없습니다."));
        board.map(Board::getId)
                .ifPresent(id -> {
                    CommentList commentList = new CommentList();
                    commentList.setComment(commentForm.getComment());
                    commentList.setBoard(commentboard);
                    em.merge(commentList);
                });
    }

    public List<BoardDTO> showAll(){
        List<Board> listBoard =  em.createQuery("select b from Board b", Board.class).getResultList();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for(Board b:listBoard){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setId(b.getId());
            boardDTO.setCount(b.getCount());
            boardDTO.setTitle(b.getTitle());
            boardDTO.setContent(b.getContent());
            boardDTO.setWritetime(b.getWritetime());
            boardDTO.setWriter(b.getWriter());
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }

    public List<String> showComment(ShowCommentForm showCommentForm){

        Board postId = findById(showCommentForm.getId())
                .orElseThrow(() -> new IllegalStateException("해당하는 id가 없습니다."));
        List<String> result = em.createQuery(
                "select c.comment from CommentList c c.board where c.board = :id", String.class
                )
                .setParameter("id", postId.getId()).getResultList();

        if(result.isEmpty())
        {
            throw new IllegalStateException("해당하는 댓글이 없습니다.");
        }
        return result;
    }

    public Optional<Board> findById(String id){
        Board board = em.find(Board.class, id);
        return Optional.ofNullable(board);
    }

    public Optional<CommentList> findCommentById(String id){
        CommentList commentList = em.find(CommentList.class, id);
        return Optional.ofNullable(commentList);
    }
}
