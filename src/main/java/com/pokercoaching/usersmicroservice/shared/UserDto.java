package com.pokercoaching.usersmicroservice.shared;

import java.io.Serial;
import java.io.Serializable;

public class UserDto implements Serializable {


    @Serial
    private static final long serialVersionUID = 1700128946939083761L;
    //private String firstName;
    private String name;
    private String email;
    private String password;
    private String userId;
    private String encryptedPassword;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }


}
