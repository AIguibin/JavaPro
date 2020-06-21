package com.aiguibin.access;


import com.aiguibin.beans.StudentBean;
import com.aiguibin.entities.StudentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAccess {
   void insertStudent(StudentEntity studentEntity);

    List<StudentBean> getAllStudent();

    StudentEntity getStudentEntityByNum(String studentNum);

    void deleteStudent(String studentNum);

    void updateStudentPass(@Param("password") String password, @Param("studentNum") String studentNum);
}
