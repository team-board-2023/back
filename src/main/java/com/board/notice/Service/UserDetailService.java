package com.board.notice.Service;

import com.board.notice.Entity.Users;
import com.board.notice.Repository.JpaUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final JpaUsersRepository jpaUsersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = jpaUsersRepository.findUser(Long.parseLong(id));
        if(optionalUsers.isPresent()){
            Users users = optionalUsers.get();
                return User.builder()
                        .username(users.getUsername())
                        .password(passwordEncoder.encode(users.getPassword()))
                        .roles(users.getRoles().toArray(new String[0]))
                        .build();
                }
        else{
            throw new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다.");
        }
    }
}
