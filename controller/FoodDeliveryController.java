package com.foodapp.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapp.dto.AdminDTO;
import com.foodapp.foodapp.dto.CustomerDTO;
import com.foodapp.foodapp.dto.LoginDTO;
import com.foodapp.foodapp.entity.Menu;
import com.foodapp.foodapp.entity.Restaurant;
import com.foodapp.foodapp.repository.MenuRepo;
import com.foodapp.foodapp.repository.RestaurantRepo;
import com.foodapp.foodapp.repository.RestaurantRepository;
import com.foodapp.foodapp.repository.adminLoginRepo;
import com.foodapp.foodapp.service.FoodDeliveryService;
import com.foodapp.foodapp.utility.Response;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping(value = "/fooddelivery")
public class FoodDeliveryController {

	@Autowired
	FoodDeliveryService foodDeliveryService;
	@Autowired
	RestaurantRepo restaurantrepo;
	@Autowired
	MenuRepo menurepo;
	@Autowired
	adminLoginRepo adminrepo;
	@Autowired
	RestaurantRepository restrepo; 
	
	
	@PostMapping(value = "/register")
	public ResponseEntity<Response> register(@RequestBody CustomerDTO customer){
		Response response = foodDeliveryService.register(customer);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login")
	public ResponseEntity<Response> login(@RequestBody LoginDTO loginUser){
		Response response = foodDeliveryService.loginUser(loginUser);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	/*@RequestMapping(value = "/getAllRestaurant")
	public ResponseEntity<Response> getAllRestaurant(){
		Response response = foodDeliveryService.getRestaurants();
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}*/
	@RequestMapping(value = "/getAllRestaurant")
	public ResponseEntity<?> getAllRestaurant(){
		List<Restaurant> res =restaurantrepo.findAll();
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllMenu")
	public ResponseEntity<?> getAllMenu(){
		List<Menu> res =menurepo.findAll();
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@RequestMapping(value = "/Adminlogin")
	public ResponseEntity<Response> loginAdmin(@RequestBody AdminDTO loginAdmin){
		Response response = foodDeliveryService.loginAdmin(loginAdmin);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
}
