package com.aiguibin.action;

import com.aiguibin.beans.StudentBean;
import com.aiguibin.entities.AdminInfoEntity;
import com.aiguibin.service.AdminInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class AdminInfoController {
    private static Logger logger = LogManager.getLogger(AdminInfoController.class);
    @Autowired
    private AdminInfoService adminInfoService;
    // 根据管理员账号获取管理员
    @RequestMapping(value = "/getAdminInfo", method = RequestMethod.GET)
    @ResponseBody
    public AdminInfoEntity getAdminInfo(@RequestParam String adminNum) {
        return adminInfoService.getAdminEntityByNum(adminNum);
    }
    // 管理员注册
    @RequestMapping(value = "/insertAdminInfo", method = RequestMethod.POST)
    @ResponseBody
    public void insertAdminInfo(@RequestBody AdminInfoEntity insertAdminInfo) {
        adminInfoService.insertAdminInfo(insertAdminInfo);
    }
    // 修改密码
    @RequestMapping(value = "/updateAdminInfo", method = RequestMethod.GET)
    @ResponseBody
    public void updateAdminInfo(@RequestParam("password") String password, @RequestParam("adminNum") String adminNum) {
        adminInfoService.updateAdminInfo(password, adminNum);
    }
    // 更新学生信息
    @RequestMapping(value = "/updateStudentInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateStudentInfo(@RequestBody StudentBean studentBean) {
        adminInfoService.updateStudentInfo(studentBean);
    }
    // 删除学生信息
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    @ResponseBody
    public void deleteStudent(@RequestParam String studentNum) {
        adminInfoService.deleteStudent(studentNum);
    }
}
