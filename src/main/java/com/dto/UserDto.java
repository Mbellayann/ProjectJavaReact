package com.dto;

import com.datamodel.ERole;
import com.datamodel.Role;
import com.datamodel.User;

import java.util.HashSet;
import java.util.Set;


public class UserDto {
    private long id;
    private String username;
    private String password;
    private Set<ERole> roles = new HashSet<>();

    public User MapUser(){
        User user = new User();
        user.setPassword(this.password);
        user.setUsername(this.username);
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<ERole> getRoles() {
        return roles;
    }

    public void setRoles(Set<ERole> roles) {
        this.roles = roles;
    }
}
