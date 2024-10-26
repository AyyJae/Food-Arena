package com.foodapp.foodapp.service;
import com.foodapp.foodapp.entity.Customer;

public interface ICustomerService {
	// For Registration : Sign-Up
	Customer registerCustomer(Customer newCustomer);

	Customer fetchCustomerByUserName(String UserName);

	Customer fetchByUserNameAndPass(String UserName, String pass);

}
