package com.board.notice.Repository;

import com.board.notice.Entity.Random;
import com.board.notice.Form.RandomForm;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RandomRepository {

    private final EntityManager em;

    public Random create(RandomForm randomForm){
        Random Random = new Random();
        Random.setId(createId());
        Random.setClassname(randomForm.getClassname());
        Random.setProfessor(randomForm.getProfessor());
        Random.setDividedclass(randomForm.getDividedclass());
        Random.setDeadline(randomForm.getDeadline());
        Random.setPersonnel(randomForm.getPersonnel());
        Random.setParticipants(randomForm.getParticipants());

        em.merge(Random);
        return Random;
    }

    public String createId(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        java.util.Random random = new java.util.Random();

        String generatedString = random.ints(leftLimit,rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

//    public List<Long> addUser(Long id, Long userId){
//       return findById(id).map(random ->
//                {
//                    random.addUser(userId); random.plusNum();
//                    if(random.getNum().equals(random.getTotalNum()))
//                    {return random.getUsersStore();}
//                    else return random.getUsersStore();
//                })
//               .orElseThrow(() -> new IllegalStateException("해당하는 id가 없습니다."));
//    }

    public Random showAll(String id){
        return findById(id)
                .orElseThrow(()-> new IllegalStateException("해당하는 id가 없습니다."));
    }

    public Optional<Random> findById(String id){
        Random random = em.find(Random.class, id);
        return Optional.ofNullable(random);
    }
}
