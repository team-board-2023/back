package com.board.notice.Service;

import com.board.notice.Repository.JpaUsersRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class UsersConfig {
    private EntityManager em;

    @Bean
    public JpaUsersRepository JpaUsersRepository(){
        return new JpaUsersRepository(em);
    }
}
