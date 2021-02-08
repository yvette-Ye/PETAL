package com.petal.demo.controller;

import com.petal.demo.entity.Movie;
import com.petal.demo.entity.Recmovie;
import com.petal.demo.entity.movie_attitude;
import com.petal.demo.repository.MovieRepository;
import com.petal.demo.repository.RecmovieRepository;
import com.petal.demo.repository.movie_attitudeRepository;
import com.petal.demo.tools.MoviePlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/userRecommend")
public class MovieHandler {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RecmovieRepository recmovieRepository;

    @Autowired
    private movie_attitudeRepository movie_attitudeRepository;


    @GetMapping("/getRecommends/{userid}/{coverRoad}")
    public List<MoviePlus> resRecommends(@PathVariable("userid") String userid,@PathVariable("coverRoad") String coverRoad){
        List<Recmovie> recmovies=recmovieRepository.findAllRecmovieByUserid(userid);
        ArrayList<MoviePlus> movies=new ArrayList<>();
        coverRoad=coverRoad.replace("+","/");
        for (Recmovie recmovie : recmovies) {
            Movie movie = movieRepository.findById(recmovie.getMovieid()).orElse(null);
            assert movie != null;
            String[] urlHolder = movie.getImg().split("/");
            movie.setImg(coverRoad + urlHolder[urlHolder.length - 1]);
            movie_attitude movie_attitudeWanna=movie_attitudeRepository.findMovie_attitudeByUserid(userid,movie.getId(),1,0);
            movie_attitude movie_attitudeSeen=movie_attitudeRepository.findMovie_attitudeByUserid(userid,movie.getId(),0,1);

            MoviePlus moviePlus=new MoviePlus(
                    movie.getId(),
                    movie.getName(),
                    movie.getADD_TIME(),
                    movie.getType(),
                    movie.getActors(),
                    movie.getRegion(),
                    movie.getDirector(),
                    movie.getTrait(),
                    movie.getRat(),
                    movie.getEnable(),
                    movie.getDescription(),
                    movie.getImg_org(),
                    movie.getImg(),
                    "display:none",
                    "color:#ff9900",
                    "color:#ff9900"
            );

            if (movie_attitudeWanna!=null){
                moviePlus.setCssSS("color:indianred");
            }
            if (movie_attitudeSeen!=null){
                moviePlus.setCssSSS("color:indianred");
            }
            movies.add(moviePlus);
        }
        return movies;
    }

    @GetMapping("/findAll/{coverRoad}")
    public List<Movie> findAll(@PathVariable("coverRoad") String coverRoad){
        Sort sort=Sort.by(Sort.Direction.DESC,"rat");
        List<Movie> movieList=movieRepository.findAll(sort);
        ArrayList<Movie> resMovies=new ArrayList<>();
        coverRoad=coverRoad.replace("+","/");
        String finalCoverRoad = coverRoad;
        int count=1;
        for (Movie movie:movieList){
            String[] urlHolder = movie.getImg().split("/");
            movie.setImg(finalCoverRoad + urlHolder[urlHolder.length - 1]);
            if(count<101){
                resMovies.add(movie);
                count+=1;
            }else {
                break;
            }
        }

        return resMovies;
    }

}
