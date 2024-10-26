package com.foodapp.foodapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.foodapp.foodapp.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	

}
