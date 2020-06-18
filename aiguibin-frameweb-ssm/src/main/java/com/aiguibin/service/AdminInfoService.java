package com.aiguibin.service;

import com.aiguibin.access.AdminInfoAccess;
import com.aiguibin.access.StudentAccess;
import com.aiguibin.access.StudentInfoAccess;
import com.aiguibin.beans.StudentBean;
import com.aiguibin.entities.AdminInfoEntity;
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

    public void updateStudentInfo(StudentBean studentBean) {
    }
}
