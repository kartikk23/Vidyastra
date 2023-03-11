package com.kartik.evidya.model;

public class StudentListEntity {
    private int userImage;
    private String userName;
    private String subDetail;
    private String time;
    private int userMedal;

    public StudentListEntity(int userImage, String userName, String subDetail, String time, int userMedal) {
        this.userImage = userImage;
        this.userName = userName;
        this.subDetail = subDetail;
        this.time = time;
        this.userMedal = userMedal;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubDetail() {
        return subDetail;
    }

    public void setSubDetail(String subDetail) {
        this.subDetail = subDetail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUserMedal() {
        return userMedal;
    }

    public void setUserMedal(int userMedal) {
        this.userMedal = userMedal;
    }
}
