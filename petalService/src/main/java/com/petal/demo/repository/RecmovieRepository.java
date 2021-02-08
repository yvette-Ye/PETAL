package com.petal.demo.repository;

import com.petal.demo.entity.Recmovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecmovieRepository extends JpaRepository<Recmovie, String>, JpaSpecificationExecutor<Recmovie> {
    @Modifying
    @Query(value = "from Recmovie where userid = ?1")
    List<Recmovie> findAllRecmovieByUserid(String userid);
}
