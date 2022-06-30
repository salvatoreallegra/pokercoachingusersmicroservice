package com.pokercoaching.usersmicroservice.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
    @NotNull(message="First Name Cannot Be Null")
    @Size(min=2,message="First Name Must Be Greater than 2 Characters")
    public String firstName;
    @NotNull(message="Last Name Cannot Be Null")
    @Size(min=2,message="First Name Must Be Greater than 2 Characters")
    public String lastName;
    @NotNull(message="Password Cannot Be Null")
    @Size(min=8,max=16,message="Password must be between 8 and 16 Characters")
    public String password;

    @NotNull(message="Email Cannot Be Null")
    @Email
    public String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}