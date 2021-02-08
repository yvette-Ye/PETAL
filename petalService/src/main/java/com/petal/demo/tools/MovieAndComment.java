package com.petal.demo.tools;

import com.petal.demo.entity.Movie;
import com.petal.demo.entity.comment_new;

public class MovieAndComment {
    private Movie movie;
    private comment_new comment_new;

    public MovieAndComment(Movie movie, comment_new comment_new) {
        this.movie = movie;
        this.comment_new = comment_new;
    }

    @Override
    public String toString() {
        return "MovieAndComment{" +
                "movie=" + movie +
                ", comment_new=" + comment_new +
                '}';
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public com.petal.demo.entity.comment_new getComment_new() {
        return comment_new;
    }

    public void setComment_new(com.petal.demo.entity.comment_new comment_new) {
        this.comment_new = comment_new;
    }
}
