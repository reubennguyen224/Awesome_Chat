package com.rikkei.training.morkproject.awesomechat.Model;

import java.io.Serializable;

public class User implements Serializable {

    int id;
    String fullName, password,  email, avatar, dob, phoneNo;

    public User(int id, String phoneNo, String fullName, String avatar, String dob) {
        this.id = id;
        this.phoneNo = phoneNo;
        this.fullName = fullName;
        this.avatar = avatar;
        this.dob = dob;
    }

    public User(String fullName, String password, String email) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phoneNo = "012345678910";
        this.avatar = "";//duong dan toi avatar mac dinh
        this.dob = "01/01/1999"; //ngay sinh mac dinh
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
