package com.coderscampus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coderscampus.api.domain.User;

public interface FarmRegisterRepository extends JpaRepository <User,Long>{
	
	@Query(value="select * from user where email_address = :emailAddress AND password = :password", nativeQuery=true)
	User findUserByEmailAndPassword(@Param("emailAddress") String emailAddress, @Param("password") String password);
}
