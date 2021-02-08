package com.petal.demo.tools;

import com.petal.demo.entity.Movie;

public class MoviePlus extends Movie {

    private String cssS;
    private String cssSS;
    private String cssSSS;

    @Override
    public String toString() {
        return "MoviePlus{" +
                "cssS='" + cssS + '\'' +
                ", cssSS='" + cssSS + '\'' +
                ", cssSSS='" + cssSSS + '\'' +
                '}';
    }

    public String getCssS() {
        return cssS;
    }

    public void setCssS(String cssS) {
        this.cssS = cssS;
    }

    public String getCssSS() {
        return cssSS;
    }

    public void setCssSS(String cssSS) {
        this.cssSS = cssSS;
    }

    public String getCssSSS() {
        return cssSSS;
    }

    public void setCssSSS(String cssSSS) {
        this.cssSSS = cssSSS;
    }

    public MoviePlus(String id, String name, String ADD_TIME, String type, String actors, String region, String director, String trait, String rat, String enable, String description, String img_org, String img, String cssS, String cssSS, String cssSSS) {
        super(id, name, ADD_TIME, type, actors, region, director, trait, rat, enable, description, img_org, img);
        this.cssS = cssS;
        this.cssSS = cssSS;
        this.cssSSS = cssSSS;
    }

    public MoviePlus(String cssS, String cssSS, String cssSSS) {
        this.cssS = cssS;
        this.cssSS = cssSS;
        this.cssSSS = cssSSS;
    }
}
