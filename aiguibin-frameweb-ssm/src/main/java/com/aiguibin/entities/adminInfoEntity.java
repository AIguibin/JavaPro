package com.aiguibin.entities;


import java.sql.Date;

public class AdminInfoEntity {
    private int  id;
    private String adminNum;
    private String adminName;
    private int adminPass;
    private int adminAge;
    private int adminTel;
    private String adminAdd;
    private String adminSex;
    private Date adminDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminNum() {
        return adminNum;
    }

    public void setAdminNum(String adminNum) {
        this.adminNum = adminNum;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(int adminPass) {
        this.adminPass = adminPass;
    }

    public int getAdminAge() {
        return adminAge;
    }

    public void setAdminAge(int adminAge) {
        this.adminAge = adminAge;
    }

    public int getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(int adminTel) {
        this.adminTel = adminTel;
    }

    public String getAdminAdd() {
        return adminAdd;
    }

    public void setAdminAdd(String adminAdd) {
        this.adminAdd = adminAdd;
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex;
    }

    public Date getAdminDate() {
        return adminDate;
    }

    public void setAdminDate(Date adminDate) {
        this.adminDate = adminDate;
    }
}
