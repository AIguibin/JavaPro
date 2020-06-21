package com.aiguibin.access;

import com.aiguibin.entities.StudentInfoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoAccess {


    void updateStudentInfoByNum(StudentInfoEntity studentInfoEntity);

    void insertStudentInfo(StudentInfoEntity studentInfoEntity);


    void deleteStudent(String studentNum);

    StudentInfoEntity getStudentInfoByNum(String studentNum);
}
