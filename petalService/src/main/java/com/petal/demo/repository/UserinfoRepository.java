package com.petal.demo.repository;

import com.petal.demo.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserinfoRepository extends JpaRepository<Userinfo, String> {
}
