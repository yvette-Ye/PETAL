package com.petal.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "comment_new")
public class comment_new {
    @Id
    private String ID;
    private String TIME;
    private String MOVIEID;
    private String RATING;
    private String CONTENT;
    private String CREATOR;
    private String ADD_TIME;
    private String NEWDATA;
    private String USERID;

    public comment_new(String ID, String TIME, String MOVIEID, String RATING, String CONTENT, String CREATOR, String ADD_TIME, String NEWDATA, String USERID) {
        this.ID = ID;
        this.TIME = TIME;
        this.MOVIEID = MOVIEID;
        this.RATING = RATING;
        this.CONTENT = CONTENT;
        this.CREATOR = CREATOR;
        this.ADD_TIME = ADD_TIME;
        this.NEWDATA = NEWDATA;
        this.USERID = USERID;
    }

    @Override
    public String toString() {
        return "comment_new{" +
                "ID='" + ID + '\'' +
                ", TIME='" + TIME + '\'' +
                ", MOVIEID='" + MOVIEID + '\'' +
                ", RATING='" + RATING + '\'' +
                ", CONTENT='" + CONTENT + '\'' +
                ", CREATOR='" + CREATOR + '\'' +
                ", ADD_TIME='" + ADD_TIME + '\'' +
                ", NEWDATA='" + NEWDATA + '\'' +
                ", USERID='" + USERID + '\'' +
                '}';
    }

    public comment_new() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public String getMOVIEID() {
        return MOVIEID;
    }

    public void setMOVIEID(String MOVIEID) {
        this.MOVIEID = MOVIEID;
    }

    public String getRATING() {
        return RATING;
    }

    public void setRATING(String RATING) {
        this.RATING = RATING;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public String getCREATOR() {
        return CREATOR;
    }

    public void setCREATOR(String CREATOR) {
        this.CREATOR = CREATOR;
    }

    public String getADD_TIME() {
        return ADD_TIME;
    }

    public void setADD_TIME(String ADD_TIME) {
        this.ADD_TIME = ADD_TIME;
    }

    public String getNEWDATA() {
        return NEWDATA;
    }

    public void setNEWDATA(String NEWDATA) {
        this.NEWDATA = NEWDATA;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }
}
