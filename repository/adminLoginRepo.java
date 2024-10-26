package com.foodapp.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.foodapp.foodapp.entity.Admin;
import com.foodapp.foodapp.utility.Response;

@Repository
public interface adminLoginRepo extends JpaRepository<Admin, Integer> {
	
	@Query(value = "select * from food_app.admin where userName =:userName",nativeQuery = true)
	public Admin findAdminByUserId(@Param("userName") String userName);

	
	
}
