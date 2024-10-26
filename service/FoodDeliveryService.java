package com.foodapp.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.foodapp.foodapp.dao.FoodDeliveryDao;
import com.foodapp.foodapp.dto.AdminDTO;
import com.foodapp.foodapp.dto.CustomerDTO;
import com.foodapp.foodapp.dto.LoginDTO;
import com.foodapp.foodapp.entity.Admin;
import com.foodapp.foodapp.entity.Cart;
import com.foodapp.foodapp.entity.Customer;
import com.foodapp.foodapp.entity.Menu;
import com.foodapp.foodapp.entity.Restaurant;
import com.foodapp.foodapp.entity.UserCredential;

import com.foodapp.foodapp.utility.Response;
import com.foodapp.foodapp.utility.StatusResponse;

@Service
public class FoodDeliveryService {

	@Autowired
	FoodDeliveryDao foodDeliveryDao;

	public Response register(CustomerDTO customerdto) {
		Response response = new Response();
		Customer customer = new Customer();
		Customer customerResponse = null;
		Cart cart = new Cart(0, 0);
		UserCredential userCredential = new UserCredential();
		customer.setFirstName(customerdto.getFirstName());
		customer.setLastName(customerdto.getLastName());
		customer.setEmail(customerdto.getEmail());
		customer.setMobileNumber(customerdto.getMobileNumber());
		customer.setAddress(customerdto.getAddress());
		customer.setCart(cart);

		userCredential.setUserName(customerdto.getUserName());
		userCredential.setPassword(customerdto.getPassword());

		customer.setUserCredential(userCredential);

		customerResponse = foodDeliveryDao.customerRegistration(customer);
		
		if (customerResponse != null) {
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Customer Registered successfully");
			response.setStatusResponse(StatusResponse.SUCCESS);
		} else {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Invalid");
			response.setStatusResponse(StatusResponse.Failure);
		}
		return response;
	}

	public Response loginUser(LoginDTO loginUser) {
		Response response = new Response();
		UserCredential user = null;
		UserCredential userCredential = new UserCredential();
		userCredential.setUserName(loginUser.getUserName());
		userCredential.setPassword(loginUser.getPassword());

		user = foodDeliveryDao.login(userCredential.getUserName());
		if (user != null && (user.getPassword().equals(userCredential.getPassword()))) {
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Login validated successfully");
			response.setStatusResponse(StatusResponse.SUCCESS);
		} else {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Invalid Credentials");
			response.setStatusResponse(StatusResponse.Failure);
		}
		return response;
	}

	public Response loginAdmin(AdminDTO loginAdmin) {
		Response response = new Response();
		Admin d1 = null;
		Admin admin = new Admin();
		admin.setUserid(loginAdmin.getUserId());
		admin.setPassword(loginAdmin.getPassword());

		admin = foodDeliveryDao.loginAdmin(admin.getUserid());
		if (admin != null && (admin.getPassword().equals(admin.getPassword()))) {
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Login validated successfully");
			response.setStatusResponse(StatusResponse.SUCCESS);
		} else {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Invalid Credentials");
			response.setStatusResponse(StatusResponse.Failure);
		}
		return response;
	}

	
	public Response getRestaurants() {
		// TODO Auto-generated method stub
		Response response = new Response();
		List<Restaurant> restaurants=foodDeliveryDao.getAllRestaurants();
		if (!restaurants.isEmpty()) {
			response.setData(restaurants);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Restaurant Fetched");
			response.setStatusResponse(StatusResponse.SUCCESS);
		} else {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Invalid Request");
			response.setStatusResponse(StatusResponse.Failure);
		}
		return response;
	}
	
	public Response getMenus() {
		// TODO Auto-generated method stub
		Response response = new Response();
		List<Menu> menus=foodDeliveryDao.getAllMenu();
		if (!menus.isEmpty()) {
			response.setData(menus);
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Menu Fetched");
			response.setStatusResponse(StatusResponse.SUCCESS);
		} else {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Invalid Request");
			response.setStatusResponse(StatusResponse.Failure);
		}
		return response;
	}

}
