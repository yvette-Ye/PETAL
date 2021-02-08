package com.petal.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "user_friend")
public class user_friend {
    @Id
    private String id;
    private String useridH;
    private String useridC;

    public user_friend(String id, String useridH, String useridC) {
        this.id = id;
        this.useridH = useridH;
        this.useridC = useridC;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUseridH() {
        return useridH;
    }

    public void setUseridH(String useridH) {
        this.useridH = useridH;
    }

    public String getUseridC() {
        return useridC;
    }

    public void setUseridC(String useridC) {
        this.useridC = useridC;
    }

    @Override
    public String toString() {
        return "user_friend{" +
                "id='" + id + '\'' +
                ", useridH='" + useridH + '\'' +
                ", useridC='" + useridC + '\'' +
                '}';
    }
}
