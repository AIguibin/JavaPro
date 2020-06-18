package com.aiguibin.service;

import com.aiguibin.access.StudentAccess;
import com.aiguibin.beans.StudentBean;
import com.aiguibin.entities.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {
    @Autowired
    StudentAccess studentAccess;


    public  void insertStudent(StudentEntity studentEntity) {
        studentAccess.insertStudent(studentEntity);

    }

    public List<StudentBean> getAllStudent() {
       //  连表查询返回数据对象
        return studentAccess.getAllStudent();
    }

    public StudentEntity getStudentEntityByNum(String studentNum) {
        return studentAccess.getStudentEntityByNum(studentNum);
    }
}
