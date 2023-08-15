package com.board.notice.Service;

import com.board.notice.DTO.JwtTokenProvider;
import com.board.notice.DTO.TokenInfo;
import com.board.notice.Form.LoginForm;
import com.board.notice.Form.UsersJoinForm;
import com.board.notice.Entity.Users;
import com.board.notice.Repository.JpaUsersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsersService {
    private final JpaUsersRepository jpaUsersRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenInfo login(LoginForm loginForm) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginForm.getId(), loginForm.getPassword());

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }

    @Transactional
    public void join(Long id, String password, String name, String major){
        // validateDuplicateUser(id, password, name, major);

        jpaUsersRepository.save(id, password, name, major);
    }

    private void validateDuplicateUser(Long id, String password, String name, String major) {
        jpaUsersRepository.findById(id)
                .ifPresent(m -> {                  // NUll이 아닌 값이 있으면 동작( Optional이기에 가능, 아니었다면 ifNull )
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Users> showAll(){                   // 조회
        return jpaUsersRepository.findAll();
    }

    public Optional<Long> findId(Long id){ return jpaUsersRepository.findById(id);}
    public Optional<String> findPassword(Long id){ return jpaUsersRepository.findByPassword(id);}
    public Optional<String> findName(Long id){ return jpaUsersRepository.findByName(id);}
    public Optional<String> findMajor(Long id){ return jpaUsersRepository.findByMajor(id);}


}
