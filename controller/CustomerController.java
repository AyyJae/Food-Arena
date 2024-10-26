package com.foodapp.foodapp.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapp.entity.Customer;
import com.foodapp.foodapp.entity.Role;
import com.foodapp.foodapp.service.ICustomerService;
//com.foodapp.foodapp.service.ICustomerService


	
	@RestController
	@CrossOrigin("*")
	@RequestMapping("/customer")
	public class CustomerController {

		@Autowired
		private ICustomerService customerService;

		// POST request to register user
		@PostMapping("/signup")
		public ResponseEntity<?> registerCustomer(@Valid @RequestBody Customer newCustomer) throws Exception {

			String tempUserName = newCustomer.getUserName();
			Customer customer = null;
			if (tempUserName != null && !tempUserName.isEmpty()) {

				customer = customerService.fetchCustomerByUserName(tempUserName);
				if (customer != null) {
					throw new CustomerException("User with this " + tempUserName + " is already exists");
				} else {

					newCustomer.setRole(Role.valueOf("CUSTOMER"));
					customer = customerService.registerCustomer(newCustomer);
					System.out.println(customer);

				}
				return new ResponseEntity<>(customer, HttpStatus.CREATED);
			}

			return new ResponseEntity<>("User registration failed", HttpStatus.BAD_REQUEST);
		}

		// POST request to verify user
		@PostMapping("/signIn")
		public ResponseEntity<?> loginCustomer(@Valid @RequestBody Customer newUCustomer) throws Exception {

			String tempUserName = newUCustomer.getUserName();
			String tempPass = newUCustomer.getPassword();

			Customer customer = null;

			if (tempUserName != null && tempPass != null) {
				customer = customerService.fetchByUserNameAndPass(tempUserName, tempPass);
				if (customer == null) {
					return new ResponseEntity<>("Bad Credentials", HttpStatus.BAD_REQUEST);
				}
			}
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}
	}

