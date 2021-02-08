package com.petal.demo.repository;

import com.petal.demo.entity.user_friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface user_friendRepository extends JpaRepository<user_friend, String>, JpaSpecificationExecutor<user_friend> {

    @Query(value = "from user_friend where useridH = ?1")
    List<user_friend> findUserFriendsByUseridH(String useridH);
}
