package com.aiguibin.action;

import com.aiguibin.entities.StudentInfoEntity;
import com.aiguibin.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/studentInfo")
public class StudentInfoController {

    @Autowired
    StudentInfoService studentInfoService;
    @RequestMapping("/updateInfo")
    public void updateStudentInfo(@RequestBody StudentInfoEntity studentInfoEntity){
        studentInfoService.updateStudentInfo(studentInfoEntity);
    }
}
