package com.pokercoaching.usersmicroservice.data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="users")
public class Users implements Serializable {
    @Serial
    private static final long serialVersionUID = 4798614476118531385L;
    @Id
    @GeneratedValue
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable=false,length=50)
    private String name;

    @Column(nullable=false,length=120,unique=true)
    private String email;
    @Column(nullable=false,unique=true)
    private String userId;

    @Column(nullable=false,unique=true)
    private String encryptedPassword;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
