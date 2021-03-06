package com.example.dao;

import com.example.entites.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query("select c from User c where c.userId= :id")
    public User findUserById(@Param("id") Long id);

    @Query("select u from User u where u.userName= :name")
    public User getUserByUserName(@Param("name") String name);

    @Query("select u.userName from User u where u.userName= :name")
    public String getUserName(@Param("name") String name);
}
