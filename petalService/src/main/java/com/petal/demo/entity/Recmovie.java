package com.petal.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class Recmovie {
    @Id
    private String id;
    private String userid;
    private String movieid;
    private Timestamp rectime;
    private String lrrat;
    private String fmrat;
    private String srcmovieid;

    public Recmovie() {
    }

    @Override
    public String toString() {
        return "Recmovie{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", movieid='" + movieid + '\'' +
                ", rectime=" + rectime +
                ", lrrat='" + lrrat + '\'' +
                ", fmrat='" + fmrat + '\'' +
                ", srcmovieid='" + srcmovieid + '\'' +
                '}';
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

    public Timestamp getRectime() {
        return rectime;
    }

    public void setRectime(Timestamp rectime) {
        this.rectime = rectime;
    }

    public String getLrrat() {
        return lrrat;
    }

    public void setLrrat(String lrrat) {
        this.lrrat = lrrat;
    }

    public String getFmrat() {
        return fmrat;
    }

    public void setFmrat(String fmrat) {
        this.fmrat = fmrat;
    }

    public String getSrcmovieid() {
        return srcmovieid;
    }

    public void setSrcmovieid(String srcmovieid) {
        this.srcmovieid = srcmovieid;
    }

    public Recmovie(String id, String userid, String movieid, Timestamp rectime, String lrrat, String fmrat, String srcmovieid) {
        this.id = id;
        this.userid = userid;
        this.movieid = movieid;
        this.rectime = rectime;
        this.lrrat = lrrat;
        this.fmrat = fmrat;
        this.srcmovieid = srcmovieid;
    }
}
