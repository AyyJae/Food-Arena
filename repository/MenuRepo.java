package com.foodapp.foodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.foodapp.foodapp.entity.Menu;



@Repository
public interface MenuRepo extends JpaRepository<Menu, Integer> {
	@Query(value = "SELECT * FROM food_app.menu;", nativeQuery = true)
	public List<Menu> FindMenu();
	
	
}
