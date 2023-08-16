package com.board.notice.Repository;

import com.board.notice.Form.UsersJoinForm;
import com.board.notice.Entity.Users;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaUsersRepository {
    private final EntityManager em;
    public JpaUsersRepository(EntityManager em){ this.em = em; }


    public Users save(UsersJoinForm usersJoinForm){
        Users users = new Users();
        users.setId(usersJoinForm.getId());
        users.setPassword(usersJoinForm.getPassword());
        users.setName(usersJoinForm.getName());
        users.setMajor(usersJoinForm.getMajor() );

        em.merge(users);                  // 디비에 저장
        return users;
    }

    public Optional<Users> findById(Long id){
        Users users = em.find(Users.class, id);
        return Optional.ofNullable(users);
    }
    public Optional<String> findByPassword(Long id) {
        List<String> result = em.createQuery("select u.password from Users u where u.id = :id", String.class)
                .setParameter("id", id).getResultList();

        return result.stream().findAny();
    }
    public Optional<String> findByName(Long id) {
        List<String> result = em.createQuery("select u.name from Users u where u.id = :id", String.class)
                .setParameter("id", id).getResultList();

        return result.stream().findAny();
    }
    public Optional<String> findByMajor(Long id) {
        List<String> result = em.createQuery("select u.major from Users u where u.id = :id", String.class)
                .setParameter("id", id).getResultList();

        return result.stream().findAny();
    }
    public Optional<Users> findUser(Long id){
        List<Users> result =  em.createQuery("select u from Users u where u.id = :id", Users.class)
                .setParameter("id", id).getResultList();
        return result.stream().findAny();
    }
    public List<Users> findAll() {
        return em.createQuery("select u from Users u", Users.class).getResultList();          // 객체를 대상으로 쿼리를 날림
    }
}
