package com.dto;

import com.datamodel.ERole;
import com.datamodel.Role;
import com.datamodel.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class UserDto {
    private long id;
    private String username;
    private String password;
    private String passwordConfirmed;
    private String country;
    private String area;
    private String city;
    private String street;
    private String number;
    private Set<ERole> roles = new HashSet<>();
    private String name;
    private Date birthDay;
    private String gender;
    private String email;

    public String getPasswordConfirmed() {
        return passwordConfirmed;
    }

    public void setPasswordConfirmed(String passwordConfirmed) {
        this.passwordConfirmed = passwordConfirmed;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UserDto(String username, String password, String passwordConfirmed, String country, String area, String city, String street, String number, Set<ERole> roles, String name, Date birthDay, String gender, String email) {
        this.username = username;
        this.password = password;
        this.passwordConfirmed = passwordConfirmed;
        this.country = country;
        this.area = area;
        this.city = city;
        this.street = street;
        this.number = number;
        this.roles = roles;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.email = email;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
