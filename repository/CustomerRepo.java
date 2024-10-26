package com.foodapp.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapp.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Query(value = "select * from food_app.customer where email =:emailId", nativeQuery = true)
	public void findUserByEmail(@Param("emailId") String emailId);
	
}
