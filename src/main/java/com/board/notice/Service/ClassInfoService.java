package com.board.notice.Service;

import com.board.notice.Form.ClassInfoForm;
import com.board.notice.Repository.ClassInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClassInfoService {

    private final ClassInfoRepository classInfoRepository;

    public void create(ClassInfoForm classInfoForm){
        classInfoRepository.create(classInfoForm);
    }

}
