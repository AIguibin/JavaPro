package com.aiguibin.access;

import com.aiguibin.entities.AdminInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminInfoAccess {
    // 根据Id获取管理员信息
    AdminInfoEntity getAdminEntityByNum(String adminNum);
    // 管理员注册
    void insertAdminInfo(AdminInfoEntity adminInfoEntity);
    // 修改密码
    void updateAdminInfo(@Param("password") String password, @Param("adminNum") String adminNum);
}
