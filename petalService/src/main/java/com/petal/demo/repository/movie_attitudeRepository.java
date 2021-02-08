package com.petal.demo.repository;

import com.petal.demo.entity.comment_new;
import com.petal.demo.entity.movie_attitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface movie_attitudeRepository extends JpaRepository<movie_attitude, String>, JpaSpecificationExecutor<movie_attitude> {

    @Query(value = "from movie_attitude where userid = ?1 and movieid = ?2 and wanna=?3 and seen=?4")
    movie_attitude findMovie_attitudeByUserid(String userid,String movieid,int wanna,int seen);

    @Query(value = "from movie_attitude where userid = ?1 and wanna = ?2")
    List<movie_attitude> findMovie_attitudeByUseridWanna(String userid,int wanna);

    @Query(value = "from movie_attitude where userid = ?1 and seen = ?2")
    List<movie_attitude> findMovie_attitudeByUseridSeen(String userid,int seen);
}
