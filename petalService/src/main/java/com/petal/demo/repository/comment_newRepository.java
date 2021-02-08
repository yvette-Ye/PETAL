package com.petal.demo.repository;

import com.petal.demo.entity.comment_new;
import com.petal.demo.entity.movie_attitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface comment_newRepository extends JpaRepository<comment_new, String> , JpaSpecificationExecutor<comment_new> {
    @Modifying
    @Query(value = "from comment_new where MOVIEID = ?1")
    List<comment_new> findAllCommentNewByMovieId(String movieId);

    @Query(value = "from comment_new where USERID = ?1")
    List<comment_new> findCommentByUserid(String userid);
}
