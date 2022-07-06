package com.pokercoaching.usersmicroservice.models;

public class LoginRequestModel {
    public Object email;
    public Object password;

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }
}
