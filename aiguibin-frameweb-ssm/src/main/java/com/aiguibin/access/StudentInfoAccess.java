package com.aiguibin.access;

import com.aiguibin.entities.StudentInfoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoAccess {


    void updateStudentInfo(StudentInfoEntity studentInfoEntity);

    void insertStudentInfo(StudentInfoEntity studentInfoEntity);
}
