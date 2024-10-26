package com.foodapp.foodapp.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodapp.foodapp.controller.CustomerException;
import com.foodapp.foodapp.entity.Customer;
import com.foodapp.foodapp.repository.CustomerRepository;
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer registerCustomer(Customer newCustomer) {
		return customerRepo.save(newCustomer);

	}

	@Override
	public Customer fetchCustomerByUserName(String UserName) {
		Optional<Customer> customerOptional = customerRepo.findByEmail(UserName);
		if (customerOptional.isPresent()) {
			return customerOptional.get();
		}
		return null;
	}

	@Override
	public Customer fetchByUserNameAndPass(String UserName, String pass) {
		Optional<Customer> customerOptional = customerRepo.findByEmailAndPassword(UserName, pass);
		if (customerOptional.isPresent()) {
			return customerOptional.get();
		}
		throw new CustomerException(
				"Bad Credentials : Invalid Email ID or Password => Email : " + UserName + "\tPassword : " + pass);
	}


}
