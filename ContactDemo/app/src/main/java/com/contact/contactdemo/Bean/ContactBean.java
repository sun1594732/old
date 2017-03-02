package com.contact.contactdemo.Bean;

import java.io.Serializable;

/**
 * Created by wubin on 2017/3/2.
 */

public class ContactBean implements Serializable{
    private String name;
    private String age;
    private String gender;
    private String job;
    private String skill;
    private String phoneNumber;
    private String content;
    private String date;

    public ContactBean() {
    }

    public ContactBean(String name, String age, String gender, String job, String skill, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.job = job;
        this.skill = skill;
        this.phoneNumber = phoneNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
