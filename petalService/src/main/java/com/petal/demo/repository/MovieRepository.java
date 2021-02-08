package com.petal.demo.repository;

import com.petal.demo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> , JpaSpecificationExecutor<Movie> {
    @Query(value = "from Movie where type like %?1%")
    List<Movie> findMoviesLikeType(String type);

    @Query(value = "FROM Movie where name like %?1%")
    List<Movie> findMoviesToSearch(@Param("searchtext")String searchtext);
}
