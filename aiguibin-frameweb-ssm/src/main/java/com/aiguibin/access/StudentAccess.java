package com.aiguibin.access;


import com.aiguibin.beans.StudentBean;
import com.aiguibin.entities.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAccess {
   void insertStudent(StudentEntity studentEntity);

    List<StudentBean> getAllStudent();

    StudentEntity getStudentEntityByNum(String studentNum);
}
