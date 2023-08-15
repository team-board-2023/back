package com.board.notice.Controller;

import com.board.notice.DTO.TokenInfo;
import com.board.notice.Entity.Users;
import com.board.notice.Form.FindUserForm;
import com.board.notice.Form.LoginForm;
import com.board.notice.Form.UsersJoinForm;
import com.board.notice.Service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping("users/show")
    public List<Users> show(){
        return usersService.showAll();
    }

    @PostMapping("users/join")
    public List<Users> join(@RequestBody Users users){
        Long userid = users.getId();
        String userpassword = users.getPassword();
        String username = users.getName();
        String usermajor = users.getMajor();

        usersService.join(userid, userpassword, username, usermajor);
        return usersService.showAll();
    }

    @PostMapping("users/login")
    public TokenInfo login(@RequestBody LoginForm loginForm){
        TokenInfo tokenInfo = usersService.login(loginForm);
        return tokenInfo;
    }

    @PostMapping("users/findPassword")
    public Optional<String> findPassword(@RequestBody FindUserForm findUserForm){
        return usersService.findPassword(findUserForm.getId());
    }
}
