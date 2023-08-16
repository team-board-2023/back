package com.board.notice.Repository;

import com.board.notice.Entity.ClassInfo;
import com.board.notice.Form.ClassInfoForm;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassInfoRepository {

    List<ClassInfo> store = new ArrayList<>();

    public void create(ClassInfoForm classInfoForm){
        ClassInfo classInfo = new ClassInfo();
        classInfo.setClassInfo(
                classInfoForm.getClassName(), classInfoForm.getDivision(),
                classInfoForm.getSubject(), classInfoForm.getMajor(),
                classInfoForm.getProfessor(), classInfoForm.getDivide()
        );
        store.add(classInfo);
    }

    public void join(String index, Long id){

    }


}
