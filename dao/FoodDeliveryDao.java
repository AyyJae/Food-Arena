package com.foodapp.foodapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapp.entity.Admin;
import com.foodapp.foodapp.entity.Customer;
import com.foodapp.foodapp.entity.Menu;
import com.foodapp.foodapp.entity.Restaurant;
import com.foodapp.foodapp.entity.UserCredential;

import com.foodapp.foodapp.repository.CustomerRepo;
import com.foodapp.foodapp.repository.MenuRepo;
import com.foodapp.foodapp.repository.RestaurantRepo;
import com.foodapp.foodapp.repository.RestaurantRepository;
import com.foodapp.foodapp.repository.UserLoginRepo;
import com.foodapp.foodapp.repository.adminLoginRepo;

@Repository
public class FoodDeliveryDao {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	UserLoginRepo loginRepo;
	
	@Autowired
	RestaurantRepo restaurantRepo;
	@Autowired
	MenuRepo menurepo;
	@Autowired
	adminLoginRepo adminrepo;
	@Autowired
	RestaurantRepository resRepo;
	

	public Customer customerRegistration(Customer customer) {
		Customer customerResponse = null;
		try {
			if(customer != null)
				customerResponse = customerRepo.save(customer);
		} catch (Exception e) {
			System.out.println("Exception in FoodDeliveryDao->customerRegistration");
		}
		return customerResponse;
	}

	public UserCredential login(String userName) {
		UserCredential validUserName = null;
		try {
			if (userName != null)
				validUserName = loginRepo.findUserByUserName(userName);
		} catch (Exception e) {
			System.out.println("Exception in FoodDeliveryDao->login");
			System.out.println("Error "+e.getMessage());
		}
		return validUserName;
	}
	
	public Admin loginAdmin(String userid) {
		Admin validUserid = null;
		try {
			if (userid != null)
				validUserid = adminrepo.findAdminByUserId(userid);
		} catch (Exception e) {
			System.out.println("Exception in FoodDeliveryDao->login");
			System.out.println("Error "+e.getMessage());
		}
		return validUserid;
	}

	public List<Restaurant> getAllRestaurants() {
		// TODO Auto-generated method stub
		List<Restaurant> restaurants=null;
		try {
			restaurants=restaurantRepo.findAllRestaurant();
		} catch (Exception e) {
			System.out.println("Exception in FoodDeliveryDao->login");
			
		} 
		return restaurants;
	}
	
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		List<Menu> menus=null;
		try {
			menus=menurepo.FindMenu();
		} catch (Exception e) {
			System.out.println("Exception in FoodDeliveryDao->login");
			
		} 
		return menus;
	}

	public Restaurant RestaurantRegistration(Restaurant restaurant) {
		// TODO Auto-generated method stub
		Restaurant restaurantResponse = null;
		try {
			if(restaurant != null)
				restaurantResponse = resRepo.save(restaurant);
		} catch (Exception e) {
			System.out.println("Exception in FoodDeliveryDao->customerRegistration");
		}
		
		
		return null;
	}

	

}
