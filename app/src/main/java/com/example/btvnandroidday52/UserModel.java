package com.example.btvnandroidday52;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String userName;
    private String passwords;
    private String phone;
    private String email;

    public UserModel() {
    }

    public UserModel(String userName, String passwords, String phone, String email) {
        this.userName = userName;
        this.passwords = passwords;
        this.phone = phone;
        this.email = email;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getPasswords() {

        return passwords;
    }

    public void setPasswords(String passwords) {

        this.passwords = passwords;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
}
