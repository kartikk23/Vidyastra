package com.kartik.evidya.model;

public class TeacherLogEntity {
    private String date;
    private String month;
    private String teacherlog;

    public TeacherLogEntity(String date, String month, String teacherlog) {
        this.date = date;
        this.month = month;
        this.teacherlog = teacherlog;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTeacherlog() {
        return teacherlog;
    }

    public void setTeacherlog(String teacherlog) {
        this.teacherlog = teacherlog;
    }
}
