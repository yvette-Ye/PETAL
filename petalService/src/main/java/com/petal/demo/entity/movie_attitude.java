package com.petal.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "movie_attitude")
public class movie_attitude {
    @Id
    private String id;
    private String userid;
    private String movieid;
    private Integer wanna;
    private Integer seen;

    public movie_attitude(String id, String userid, String movieid, Integer wanna, Integer seen) {
        this.id = id;
        this.userid = userid;
        this.movieid = movieid;
        this.wanna = wanna;
        this.seen = seen;
    }

    @Override
    public String toString() {
        return "movie_attitude{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", movieid='" + movieid + '\'' +
                ", wanna=" + wanna +
                ", seen=" + seen +
                '}';
    }

    public movie_attitude() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public Integer getWanna() {
        return wanna;
    }

    public void setWanna(Integer wanna) {
        this.wanna = wanna;
    }

    public Integer getSeen() {
        return seen;
    }

    public void setSeen(Integer seen) {
        this.seen = seen;
    }
}
