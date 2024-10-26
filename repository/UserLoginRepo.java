package com.foodapp.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapp.entity.UserCredential;

@Repository
public interface UserLoginRepo extends JpaRepository<UserCredential, Integer>{
	
	@Query(value = "select * from food_app.user_credential where user_name =:userName",nativeQuery = true)
	public UserCredential findUserByUserName(@Param("userName") String userName);

}
