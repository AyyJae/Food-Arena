package com.foodapp.foodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.foodapp.foodapp.entity.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
	@Query(value = "SELECT * FROM food_app.restaurant;", nativeQuery = true)
	public List<Restaurant> findAllRestaurant();
	
	
}
