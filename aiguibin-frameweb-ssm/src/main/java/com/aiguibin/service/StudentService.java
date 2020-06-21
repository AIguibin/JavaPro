package com.aiguibin.service;

import com.aiguibin.access.StudentAccess;
import com.aiguibin.access.StudentInfoAccess;
import com.aiguibin.beans.StudentBean;
import com.aiguibin.entities.StudentEntity;
import com.aiguibin.entities.StudentInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {
    @Autowired
    StudentAccess studentAccess;
    @Autowired
    StudentInfoAccess studentInfoAccess;


    public void insertStudent(StudentEntity studentEntity) {
        studentAccess.insertStudent(studentEntity);

    }

    public List<StudentBean> getAllStudent() {
        //  连表查询返回数据对象
        return studentAccess.getAllStudent();
    }

    public StudentBean getStudentEntityByNum(String studentNum) {
        StudentBean studentBean=null;
        StudentEntity studentEntity=studentAccess.getStudentEntityByNum(studentNum);
        StudentInfoEntity studentInfoEntity=studentInfoAccess.getStudentInfoByNum(studentNum);
        if (studentEntity!=null && studentInfoEntity!=null){
            studentBean.setStudentNum(studentEntity.getStudentNum());
            studentBean.setStudentName(studentEntity.getStudentName());
            studentBean.setStudentAdd(studentInfoEntity.getStudentAdd());
            studentBean.setStudentAge(studentInfoEntity.getStudentAge());
            studentBean.setStudentEmail(studentInfoEntity.getStudentEmail());
            studentBean.setStudentNation(studentInfoEntity.getStudentNation());
            studentBean.setStudentTel(studentInfoEntity.getStudentTel());
            studentBean.setStudentDate(studentEntity.getStudentDate());
            studentBean.setStudentSex(studentInfoEntity.getStudentSex());
        }
        return studentBean;
    }

    public void updateStudentPass(String password, String studentNum) {
        studentAccess.updateStudentPass(password, studentNum);
    }
}
