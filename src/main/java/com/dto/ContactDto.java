package com.dto;

import com.datamodel.Contact;

import java.util.Date;

public class ContactDto {

    private String name;
    private Date birthDay;
    private String gender;
    private String email;

    public Contact MapContact(String name, Date birthDay, String gender, String email) {
        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setGender(gender);
        contact.setName(name);
        contact.setBirthDay(birthDay);
        return contact;
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
