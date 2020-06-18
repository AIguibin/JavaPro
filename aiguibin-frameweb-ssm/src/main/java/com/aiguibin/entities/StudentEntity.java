package com.aiguibin.entities;


import java.sql.Date;

public class StudentEntity {
    private int  id;
    private String studentNum;
    private String studentName;
    private int studentPass;
    private Date studentDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentPass() {
        return studentPass;
    }

    public void setStudentPass(int studentPass) {
        this.studentPass = studentPass;
    }

    public Date getStudentDate() {
        return studentDate;
    }

    public void setStudentDate(Date studentDate) {
        this.studentDate = studentDate;
    }
}
