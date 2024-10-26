package com.foodapp.foodapp.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.foodapp.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// Fetch user details based on email
	Optional<Customer> findByEmail(String Email);

	Optional<Customer> findByEmailAndPassword(String Email, String password);

}
