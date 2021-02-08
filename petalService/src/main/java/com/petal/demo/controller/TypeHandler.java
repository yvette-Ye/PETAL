package com.petal.demo.controller;

import com.petal.demo.entity.Movie;
import com.petal.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Type")
public class TypeHandler {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/findMovieByType/{type}/{coverRoad}")
    public List<Movie> findMovieByType(@PathVariable("type")String type,@PathVariable("coverRoad") String coverRoad){
        coverRoad=coverRoad.replace("+","/");
        String finalCoverRoad = coverRoad;
        List<Movie> moviesLikeType = movieRepository.findMoviesLikeType(type);
        moviesLikeType.forEach(item->{
            String[] urlHolder=item.getImg().split("/");
            item.setImg(finalCoverRoad +urlHolder[urlHolder.length - 1]);
        });
        return moviesLikeType;
    }
}
