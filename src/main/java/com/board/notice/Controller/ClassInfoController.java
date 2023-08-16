package com.board.notice.Controller;

import com.board.notice.Form.ClassInfoForm;
import com.board.notice.Service.ClassInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClassInfoController {

    private final ClassInfoService classInfoService;

    @PostMapping("classinfo/create")
    public void create(ClassInfoForm classInfoForm){
        classInfoService.create(classInfoForm);
    }
}
