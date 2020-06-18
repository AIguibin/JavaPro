package com.aiguibin.action;


import com.aiguibin.beans.StudentBean;
import com.aiguibin.entities.AdminInfoEntity;
import com.aiguibin.entities.StudentEntity;
import com.aiguibin.entities.StudentInfoEntity;
import com.aiguibin.service.StudentInfoService;
import com.aiguibin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentInfoService studentInfoService;


    // 根据学生账号获取学生
    @RequestMapping(value = "/getStudentInfo", method = RequestMethod.GET)
    @ResponseBody
    public StudentEntity getStudentInfo(@RequestParam String studentNum) {
        return studentService.getStudentEntityByNum(studentNum);
    }
    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    public void insertStudent(@RequestBody StudentBean studentBean) {
        // 保存学生
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setStudentNum(studentBean.getStudentNum());
        studentEntity.setStudentName(studentBean.getStudentName());
        studentEntity.setStudentPass(studentBean.getStudentPass());
        studentEntity.setStudentDate(studentBean.getStudentDate());
        studentService.insertStudent(studentEntity);
        // 保存学生信息
        StudentInfoEntity studentInfoEntity=new StudentInfoEntity();
        studentInfoEntity.setStudentNum(studentBean.getStudentNum());
        studentInfoEntity.setStudentAge(studentBean.getStudentAge());
        studentInfoEntity.setStudentSex(studentBean.getStudentSex());
        studentInfoEntity.setStudentAdd(studentBean.getStudentAdd());
        studentInfoEntity.setStudentTel(studentBean.getStudentTel());
        studentInfoEntity.setStudentEmail(studentBean.getStudentEmail());
        studentInfoEntity.setStudentNation(studentBean.getStudentNation());
        studentInfoService.insertStudentInfo(studentInfoEntity);
    }
    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentBean> getAllStudent() {
      return   studentService.getAllStudent();
    }
}
