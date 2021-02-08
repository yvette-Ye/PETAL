package com.petal.demo.controller;

import com.petal.demo.entity.Movie;
import com.petal.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/userSearch")
public class SearchHandler {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/findMovieTosearch/{searchtext}/{coverRoad}")
    public List<Movie> findMovieTosearch(@PathVariable("searchtext") String searchtext,@PathVariable("coverRoad") String coverRoad){
        coverRoad=coverRoad.replace("+","/");
        String finalCoverRoad = coverRoad;
        List<Movie> movieToSearch=movieRepository.findMoviesToSearch(searchtext);
        movieToSearch.forEach(movie -> {
            String[] urlHolder=movie.getImg().split("/");
            movie.setImg(finalCoverRoad +urlHolder[urlHolder.length - 1]);
        });
        return movieToSearch;
    }
}
