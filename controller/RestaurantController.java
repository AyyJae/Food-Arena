package com.foodapp.foodapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapp.entity.Restaurant;
import com.foodapp.foodapp.repository.RestaurantRepository;



@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping(value="/sanket")
	public class RestaurantController {

		@Autowired
		private RestaurantRepository restaurantRepository;
		
		// get all Restaurant
		@GetMapping("/restaurants")
		public List<Restaurant> getRestaurantsList(){
			return restaurantRepository.findAll();
		}		
		
		// create Restaurant rest api
		@PostMapping("/restaurants")
		public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
			return restaurantRepository.save(restaurant);
		}
		
		// get Restaurant by id rest api
		@GetMapping("/restaurants/{restaurantId}")
		public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long restaurantId) {
			Restaurant restaurant = restaurantRepository.findById(restaurantId)
					.orElseThrow(() -> new ResourceNotFoundException("Restaurant not exist with id :" + restaurantId));
			return ResponseEntity.ok(restaurant);
		}
		
		// update Restaurant rest api
		
		@PutMapping("/restaurants/{restaurantId}")
		public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long restaurantId, @RequestBody Restaurant restaurantDetails){
			Restaurant restaurant = restaurantRepository.findById(restaurantId)
					.orElseThrow(() -> new ResourceNotFoundException("restaurant not exist with restaurantId :" + restaurantId));
			
			restaurant.setRestaurantId(restaurantDetails.getRestaurantId());
			restaurant.setAddress(restaurantDetails.getAddress());
			restaurant.setRating(restaurantDetails.getRating());
			restaurant.setRestaurantName(restaurantDetails.getRestaurantName());

			
			
			Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
			return ResponseEntity.ok(updatedRestaurant);
		}
		
		// delete Restaurant rest api
		@DeleteMapping("/restaurants/{restaurantId}")
		public ResponseEntity<Map<String, Boolean>> deleteRestaurant(@PathVariable Long restaurantId){
			Restaurant restaurant = restaurantRepository.findById(restaurantId)
					.orElseThrow(() -> new ResourceNotFoundException("Restaurant not exist with restaurantId :" + restaurantId));
			
			restaurantRepository.delete(restaurant);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		
	}


