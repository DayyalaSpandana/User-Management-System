package com.example.spandy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String username;
    @Column
    String email;
    @Column
    String password;
    public void setName(String name) {
        this.username=name;
    }
    public void setEmail(String em) {
        this.email=em;
    }
    public void setPassword(String psw) {
        this.password=psw;
    }
    public String getPassword() {
            return this.password;

       
    }
    public String getUsername() {
            return this.username;
        
    }
    public String getEmail()
    {
        return this.email;
    }

}




