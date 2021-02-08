package com.petal.demo.controller;

import com.petal.demo.entity.Movie;
import com.petal.demo.entity.Userinfo;
import com.petal.demo.entity.comment_new;
import com.petal.demo.entity.movie_attitude;
import com.petal.demo.repository.MovieRepository;
import com.petal.demo.repository.UserinfoRepository;
import com.petal.demo.repository.comment_newRepository;
import com.petal.demo.repository.movie_attitudeRepository;
import com.petal.demo.tools.MovieAndComment;
import com.petal.demo.tools.loginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/homepage")
public class HomepageHandler {

    @Autowired
    private UserinfoRepository userinfoRepository;

    @Autowired
    private movie_attitudeRepository movie_attitudeRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private comment_newRepository comment_newRepository;

    @PostMapping("/PersonalData")
    public Userinfo PersonalData(@RequestBody Userinfo userinfo) {
        return userinfoRepository.findById(userinfo.getUif_id()).orElse(null);
    }
    @GetMapping("/wanna/{userid}/{coverRoad}")
    public List<Movie> wanna(@PathVariable("userid")String userid,@PathVariable("coverRoad")String coverRoad) {
        List<movie_attitude> movie_attitudes=movie_attitudeRepository.findMovie_attitudeByUseridWanna(userid,1);
        System.out.println(movie_attitudes);
        coverRoad=coverRoad.replace("+","/");
        List<Movie> movieList=new ArrayList<>();
        String finalCoverRoad = coverRoad;
        movie_attitudes.forEach(item->{
            Movie movie=movieRepository.findById(item.getMovieid()).orElse(null);
            if (movie!=null){
                String[] urlHolder = movie.getImg().split("/");
                movie.setImg(finalCoverRoad + urlHolder[urlHolder.length - 1]);
                movieList.add(movie);
            }
        });
        return movieList;
    }

    @GetMapping("/seen/{userid}/{coverRoad}")
    public List<Movie> seen(@PathVariable("userid")String userid,@PathVariable("coverRoad")String coverRoad) {
        List<movie_attitude> movie_attitudes=movie_attitudeRepository.findMovie_attitudeByUseridSeen(userid,1);
        System.out.println(movie_attitudes);
        coverRoad=coverRoad.replace("+","/");
        List<Movie> movieList=new ArrayList<>();
        String finalCoverRoad = coverRoad;
        movie_attitudes.forEach(item->{
            Movie movie=movieRepository.findById(item.getMovieid()).orElse(null);
            if (movie!=null){
                String[] urlHolder = movie.getImg().split("/");
                movie.setImg(finalCoverRoad + urlHolder[urlHolder.length - 1]);
                movieList.add(movie);
            }
        });
        return movieList;
    }

    @GetMapping("/comment/{userid}/{coverRoad}")
    public List<MovieAndComment> movieAndComments(@PathVariable("userid")String userid, @PathVariable("coverRoad")String coverRoad) {
        coverRoad=coverRoad.replace("+","/");
        List<comment_new> comment_news=comment_newRepository.findCommentByUserid(userid);
        List<MovieAndComment> movieAndComments=new ArrayList<>();
        String finalCoverRoad = coverRoad;
        comment_news.forEach(item->{
            Movie movie=movieRepository.findById(item.getMOVIEID()).orElse(null);
            if (movie!=null){
                String[] urlHolder = movie.getImg().split("/");
                movie.setImg(finalCoverRoad + urlHolder[urlHolder.length - 1]);
            }
            MovieAndComment movieAndComment=new MovieAndComment(movie,item);
            movieAndComments.add(movieAndComment);
        });
        return movieAndComments;
    }
}
