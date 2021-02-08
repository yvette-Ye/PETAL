package com.petal.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Userinfo {
    @Id
    private String uif_id;
    private Integer uif_password;
    private String uif_school;
    private Integer uif_age;
    private String uif_address;
    private String uif_gender;
    private String uif_profession;
    private String uif_type;

    @Override
    public String toString() {
        return "Userinfo{" +
                "uif_id='" + uif_id + '\'' +
                ", uif_password=" + uif_password +
                ", uif_school='" + uif_school + '\'' +
                ", uif_age=" + uif_age +
                ", uif_address='" + uif_address + '\'' +
                ", uif_gender='" + uif_gender + '\'' +
                ", uif_profession='" + uif_profession + '\'' +
                ", uif_type='" + uif_type + '\'' +
                '}';
    }

    public String getUif_id() {
        return uif_id;
    }

    public void setUif_id(String uif_id) {
        this.uif_id = uif_id;
    }

    public Integer getUif_password() {
        return uif_password;
    }

    public void setUif_password(Integer uif_password) {
        this.uif_password = uif_password;
    }

    public String getUif_school() {
        return uif_school;
    }

    public void setUif_school(String uif_school) {
        this.uif_school = uif_school;
    }

    public Integer getUif_age() {
        return uif_age;
    }

    public void setUif_age(Integer uif_age) {
        this.uif_age = uif_age;
    }

    public String getUif_address() {
        return uif_address;
    }

    public void setUif_address(String uif_address) {
        this.uif_address = uif_address;
    }

    public String getUif_gender() {
        return uif_gender;
    }

    public void setUif_gender(String uif_gender) {
        this.uif_gender = uif_gender;
    }

    public String getUif_profession() {
        return uif_profession;
    }

    public void setUif_profession(String uif_profession) {
        this.uif_profession = uif_profession;
    }

    public String getUif_type() {
        return uif_type;
    }

    public void setUif_type(String uif_type) {
        this.uif_type = uif_type;
    }

    public Userinfo(String uif_id, Integer uif_password, String uif_school, Integer uif_age, String uif_address, String uif_gender, String uif_profession, String uif_type) {
        this.uif_id = uif_id;
        this.uif_password = uif_password;
        this.uif_school = uif_school;
        this.uif_age = uif_age;
        this.uif_address = uif_address;
        this.uif_gender = uif_gender;
        this.uif_profession = uif_profession;
        this.uif_type = uif_type;
    }

    public Userinfo() {
    }
}
