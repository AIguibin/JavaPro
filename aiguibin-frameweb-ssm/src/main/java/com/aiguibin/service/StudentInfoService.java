package com.aiguibin.service;


import com.aiguibin.access.StudentInfoAccess;
import com.aiguibin.entities.StudentInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoService {

    @Autowired
    StudentInfoAccess studentInfoAccess;

    public void updateStudentInfo(StudentInfoEntity studentInfoEntity) {
        studentInfoAccess.updateStudentInfoByNum(studentInfoEntity);
    }
    public void insertStudentInfo(StudentInfoEntity studentInfoEntity) {
        studentInfoAccess.insertStudentInfo(studentInfoEntity);
    }
}
