package com.petal.demo.controller;

import com.petal.demo.entity.Movie;
import com.petal.demo.entity.user_friend;
import com.petal.demo.repository.MovieRepository;
import com.petal.demo.repository.user_friendRepository;
import com.petal.demo.tools.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/friend")
public class userFriendHandler {

    @Autowired
    private user_friendRepository user_friendRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/getFriends/{userid}")
    public List<user_friend> findUserFriends(@PathVariable("userid")String userid){
        return user_friendRepository.findUserFriendsByUseridH(userid);
    }

    @GetMapping("/shareMovie/{movieid}/{userid}/{useridH}")
    public String getMoviePath(@PathVariable("movieid")String movieid,@PathVariable("userid")String userid,@PathVariable("useridH")String useridH) throws IOException {
        WebSocket ws = new WebSocket();
        String flag="movieid";
        Movie movie=movieRepository.findById(movieid).orElse(null);
        String moviename=movie.getName();
        String shareWith=moviename+"!&!"+userid+"!&!"+flag+"!&!"+useridH;
        ws.onMessage(shareWith);
        return "waiting for "+userid+"'s response";
    }

    @GetMapping("/accept/{usernameTo}/{usernameH}")
    public void accept(@PathVariable("usernameTo")String usernameTo,@PathVariable("usernameH")String usernameH) throws IOException {
        WebSocket ws = new WebSocket();

        String flag="attitude";
        String messages="accept"+"!&!"+usernameTo+"!&!"+flag+"!&!"+usernameH;
        ws.onMessage(messages);
    }

    @GetMapping("/reject/{usernameTo}/{usernameH}")
    public void reject(@PathVariable("usernameTo")String usernameTo,@PathVariable("usernameH")String usernameH) throws IOException {
        WebSocket ws = new WebSocket();

        String flag="attitude";
        String messages="reject"+"!&!"+usernameTo+"!&!"+flag+"!&!"+usernameH;
        ws.onMessage(messages);
    }

    @GetMapping("/play/{currentTime}/{usernameTo}/{usernameH}")
    public void play(@PathVariable("currentTime")String currentTime, @PathVariable("usernameTo")String usernameTo, @PathVariable("usernameH")String usernameH) throws IOException {
        WebSocket ws = new WebSocket();
        String flag="timePlay";
        String messages=currentTime+"!&!"+usernameTo+"!&!"+flag+"!&!"+usernameH;
        ws.onMessage(messages);
    }

    @GetMapping("/pause/{currentTime}/{usernameTo}/{usernameH}")
    public void pause(@PathVariable("currentTime")String currentTime, @PathVariable("usernameTo")String usernameTo, @PathVariable("usernameH")String usernameH) throws IOException {
        WebSocket ws = new WebSocket();
        String flag="timePause";
        String messages=currentTime+"!&!"+usernameTo+"!&!"+flag+"!&!"+usernameH;
        ws.onMessage(messages);
    }

    @GetMapping("/bullet/{bulletText}/{usernameTo}/{usernameH}")
    public void bulletText(@PathVariable("bulletText")String bulletText, @PathVariable("usernameTo")String usernameTo, @PathVariable("usernameH")String usernameH) throws IOException {
        WebSocket ws = new WebSocket();
        String flag="bulletText";
        String messages1=bulletText+"!&!"+usernameTo+"!&!"+flag+"!&!"+usernameH;
        String messages2=bulletText+"!&!"+usernameH+"!&!"+flag+"!&!"+usernameTo;
        ws.onMessage(messages1);
        ws.onMessage(messages2);
    }

}
