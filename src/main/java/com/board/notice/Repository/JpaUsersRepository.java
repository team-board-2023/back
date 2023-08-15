package com.board.notice.Repository;

import com.board.notice.Form.UsersJoinForm;
import com.board.notice.Entity.Users;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaUsersRepository {
    private final EntityManager em;
    public JpaUsersRepository(EntityManager em){ this.em = em; }


    public Users save(Long id, String password, String name, String major){
        Users users = new Users();
        users.setId(id);
        users.setPassword(password);
        users.setName(name);
        users.setMajor(major);

        em.merge(users);                  // 디비에 저장
        return users;
    }

    public Optional<Long> findById(Long id){
        Long ID = em.find(Long.class, id);
        return Optional.ofNullable(ID);
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
