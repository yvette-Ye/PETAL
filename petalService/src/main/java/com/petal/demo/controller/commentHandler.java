package com.petal.demo.controller;

import com.petal.demo.entity.comment_new;
import com.petal.demo.entity.movie_attitude;
import com.petal.demo.repository.comment_newRepository;
import com.petal.demo.repository.movie_attitudeRepository;
import com.petal.demo.tools.loginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/userComment")
public class commentHandler {
    @Autowired
    private comment_newRepository commentNewRepository;

    @Autowired
    private movie_attitudeRepository movie_attitudeRepository;

    @GetMapping("/getComments/{movieid}")
    public List<comment_new> resComments(@PathVariable("movieid") String movieId){
        return commentNewRepository.findAllCommentNewByMovieId(movieId);
    }

    @GetMapping("/submitComment/{movieid}/{rating}/{commentContent}/{userid}")
    public boolean submitComment(@PathVariable("movieid")String movieid,@PathVariable("rating")String rating,@PathVariable("commentContent")String commentContent,@PathVariable("userid")String userid){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        UUID uuid=UUID.randomUUID();

        comment_new comment_new=new comment_new();
        comment_new.setID(uuid.toString());
        comment_new.setTIME(df.format(day));
        comment_new.setMOVIEID(movieid);
        comment_new.setRATING(rating);
        comment_new.setCONTENT(commentContent);
        comment_new.setCREATOR(userid);
        comment_new.setADD_TIME(df.format(day));
        comment_new.setNEWDATA("1");
        comment_new.setUSERID(userid);

        comment_new _comment_new=commentNewRepository.save(comment_new);
        System.out.println(_comment_new.toString());
        return _comment_new.equals(comment_new);
    }

    @GetMapping("/Wanna/{movieid}/{userid}")
    public loginRes Wanna(@PathVariable("movieid")String movieid,@PathVariable("userid")String userid){
        movie_attitude movie_attitude=movie_attitudeRepository.findMovie_attitudeByUserid(userid,movieid,1,0);
        loginRes WannaRes=new loginRes();

        if (movie_attitude==null){
            UUID uuid=UUID.randomUUID();
            movie_attitude _movie_attitude=new movie_attitude(
                    uuid.toString(),
                    userid,
                    movieid,
                    1,
                    0
            );
            movie_attitudeRepository.save(_movie_attitude);

            WannaRes.setMessage("Insert Success");
            WannaRes.setFlag(true);
            WannaRes.setObjectImp(_movie_attitude);

        }else {
            movie_attitudeRepository.deleteById(movie_attitude.getId());

            WannaRes.setMessage("Delete Success");
            WannaRes.setFlag(false);
            WannaRes.setObjectImp(movie_attitude);

        }

        return WannaRes;
    }


    @GetMapping("/Seen/{movieid}/{userid}/{rate}/{comment}")
    public loginRes Seen(@PathVariable("movieid")String movieid,@PathVariable("userid")String userid,@PathVariable("rate")String rate,@PathVariable("comment")String comment){
        movie_attitude movie_attitude=movie_attitudeRepository.findMovie_attitudeByUserid(userid,movieid,0,1);
        loginRes SeenRes=new loginRes();

        if (movie_attitude==null){
            UUID uuid=UUID.randomUUID();
            movie_attitude _movie_attitude=new movie_attitude(
                    uuid.toString(),
                    userid,
                    movieid,
                    0,
                    1
            );
            movie_attitudeRepository.save(_movie_attitude);
            SeenRes.setMessage("Insert Success");
            SeenRes.setFlag(true);
            SeenRes.setObjectImp(_movie_attitude);
        }else {
            movie_attitude _movie_attitude=new movie_attitude(
                    movie_attitude.getId(),
                    userid,
                    movieid,
                    0,
                    1
            );
            movie_attitudeRepository.save(_movie_attitude);
            SeenRes.setMessage("Update Success");
            SeenRes.setFlag(true);
            SeenRes.setObjectImp(_movie_attitude);
        }

        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        UUID uuid=UUID.randomUUID();
        comment_new comment_new=new comment_new();
        comment_new.setID(uuid.toString());
        comment_new.setTIME(df.format(day));
        comment_new.setMOVIEID(movieid);
        comment_new.setRATING(rate);
        comment_new.setCONTENT(comment);
        comment_new.setCREATOR(userid);
        comment_new.setADD_TIME(df.format(day));
        comment_new.setNEWDATA("1");
        comment_new.setUSERID(userid);
        commentNewRepository.save(comment_new);

        return SeenRes;
    }

}
