package com.aiguibin.service;

import com.aiguibin.access.AdminInfoAccess;
import com.aiguibin.access.StudentAccess;
import com.aiguibin.access.StudentInfoAccess;
import com.aiguibin.beans.StudentBean;
import com.aiguibin.entities.AdminInfoEntity;
import com.aiguibin.entities.StudentEntity;
import com.aiguibin.entities.StudentInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AdminInfoService {

    @Autowired
    AdminInfoAccess adminInfoAccess;
    @Autowired
    StudentAccess studentAccess;
    @Autowired
    StudentInfoAccess studentInfoAccess;


    public AdminInfoEntity getAdminEntityByNum(String adminNum) {

        return adminInfoAccess.getAdminEntityByNum(adminNum);
    }

    public void insertAdminInfo(AdminInfoEntity adminInfoEntity) {
        adminInfoAccess.insertAdminInfo(adminInfoEntity);
    }

    public void updateAdminInfo(String password, String adminNum) {
        adminInfoAccess.updateAdminInfo(password, adminNum);
    }

    // 更新学生信息表
    public void updateStudentInfo(StudentBean studentBean) {
        StudentInfoEntity studentInfoEntity=new StudentInfoEntity();
        studentInfoEntity.setStudentNum(studentBean.getStudentNum());
        studentInfoEntity.setStudentAdd(studentBean.getStudentAdd());
        studentInfoEntity.setStudentEmail(studentBean.getStudentEmail());
        studentInfoEntity.setStudentTel(studentBean.getStudentTel());
        studentInfoEntity.setStudentNation(studentBean.getStudentNation());
        studentInfoEntity.setStudentSex(studentBean.getStudentSex());
        studentInfoEntity.setStudentAge(studentBean.getStudentAge());
        studentInfoAccess.updateStudentInfoByNum(studentInfoEntity);
    }

    // 删除学生表以及学生信息表中的该学生
    public void deleteStudent(String studentNum) {
        studentAccess.deleteStudent(studentNum);
        studentInfoAccess.deleteStudent(studentNum);
    }
}
