package com.realtech.cloudschool.command;

import com.realtech.cloudschool.model.User;

import java.util.Date;

public class UserCommand {

    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String interests;

    public UserCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public User convertToUser(){
        User user = new User();
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setFirstname(getFirstname());
        user.setLastname(getLastname());
        user.setEmail(getEmail());
        user.setInterests(getInterests());
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        return user;
    }
}