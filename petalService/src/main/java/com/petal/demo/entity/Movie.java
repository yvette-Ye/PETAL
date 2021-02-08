package com.petal.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
public class Movie {
    @Id
    private String id;
    private String name;
    private String ADD_TIME;
    private String type;
    private String actors;
    private String region;
    private String director;
    private String trait;
    private String rat;
    private String enable;
    private String description;
    private String img_org;
    private String img;

    public Movie(String id, String name, String ADD_TIME, String type, String actors, String region, String director, String trait, String rat, String enable, String description, String img_org, String img) {
        this.id = id;
        this.name = name;
        this.ADD_TIME = ADD_TIME;
        this.type = type;
        this.actors = actors;
        this.region = region;
        this.director = director;
        this.trait = trait;
        this.rat = rat;
        this.enable = enable;
        this.description = description;
        this.img_org = img_org;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ADD_TIME='" + ADD_TIME + '\'' +
                ", type='" + type + '\'' +
                ", actors='" + actors + '\'' +
                ", region='" + region + '\'' +
                ", director='" + director + '\'' +
                ", trait='" + trait + '\'' +
                ", rat='" + rat + '\'' +
                ", enable='" + enable + '\'' +
                ", description='" + description + '\'' +
                ", img_org='" + img_org + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public Movie() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getADD_TIME() {
        return ADD_TIME;
    }

    public void setADD_TIME(String ADD_TIME) {
        this.ADD_TIME = ADD_TIME;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public String getRat() {
        return rat;
    }

    public void setRat(String rat) {
        this.rat = rat;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_org() {
        return img_org;
    }

    public void setImg_org(String img_org) {
        this.img_org = img_org;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
