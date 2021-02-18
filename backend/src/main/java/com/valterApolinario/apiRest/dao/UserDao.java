package com.valterApolinario.apiRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.valterApolinario.apiRest.model.User;

public interface UserDao extends JpaRepository<User, Long> { 


	@Query("SELECT u FROM User u WHERE u.userName = :userName")
	User findByUserName(@Param("userName") String username);

}
