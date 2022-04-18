package com.example.dao;

import com.example.entites.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query("select c from User c where c.userId= :id")
    public User findUserById(@Param("id") Long id);
}
