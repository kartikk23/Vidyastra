package com.kartik.evidya.model;

import com.google.gson.annotations.SerializedName;


public class UserEntity {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;
    @SerializedName("school_id")
    private String school_id;

    @SerializedName("first_name")
    private String first_name;
    @SerializedName("last_name")
    private String last_name;

    @SerializedName("mobile_number")
    private String mobile_number;

    @SerializedName("profile_image")
    private String profile_image;

    @SerializedName("address")
    private String address;

    @SerializedName("state_id")
    private String state_id;

    @SerializedName("city_id")
    private String city_id;

    @SerializedName("taluka_id")
    private String taluka_id;

    @SerializedName("education")
    private String education;

    @SerializedName("panchayat_samiti_name")
    private String panchayat_samiti_name;

    @SerializedName("google_meet_link")
    private String google_meet_link;

    @SerializedName("leadership_id")
    private String leadership_id;

    @SerializedName("status")
    private String status;

    @SerializedName("email")
    private String email;

    @SerializedName("email_verified_at")
    private String email_verified_at;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getTaluka_id() {
        return taluka_id;
    }

    public void setTaluka_id(String taluka_id) {
        this.taluka_id = taluka_id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPanchayat_samiti_name() {
        return panchayat_samiti_name;
    }

    public void setPanchayat_samiti_name(String panchayat_samiti_name) {
        this.panchayat_samiti_name = panchayat_samiti_name;
    }

    public String getGoogle_meet_link() {
        return google_meet_link;
    }

    public void setGoogle_meet_link(String google_meet_link) {
        this.google_meet_link = google_meet_link;
    }

    public String getLeadership_id() {
        return leadership_id;
    }

    public void setLeadership_id(String leadership_id) {
        this.leadership_id = leadership_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(String email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
