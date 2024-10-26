package com.foodapp.foodapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "CUSTOMER")
@JsonInclude(Include.NON_DEFAULT)
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@Column(name = "ADDRESS",length=40)
	@NotNull(message = "Address cannot be null")
	private String address;
	

	@Column(name = "F_NAME",length=40)
	@NotNull(message = "Name cannot be null")
	private String firstName;

	@Column(name = "L_NAME",length=30)
	@NotNull(message = "Name cannot be null")
	private String lastName;

	@Column(name = "PHONE")
	private String mobileNumber;

	@Column(name = "EMAIL",length=20)
	@Email(message = "Email should be valid")
	private String email;
	
	@Column(name = "USERNAME",length=30)
	@NotNull(message = "userName cannot be null")
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD",length=30)
	@NotNull(message = "Password cannot be null")
	private String password;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "CART_ID")
	private Cart cart;

	public Customer( Long customerId,@NotNull(message = "Address cannot be null")  String address,@NotNull(message = "Name cannot be null")  String firstName,@NotNull(message = "Name cannot be null")  String lastName, String mobileNumber,
			@Email(message = "Email cannot be null")  String email) {
		super();
		this.customerId = customerId;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "CREDENTIAL_ID")
	
	private UserCredential userCredential;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	

	@OneToMany(mappedBy = "pk.customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CustomerRestaurantMap> customerRestaurantMaps;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<CustomerRestaurantMap> getCustomerRestaurantMaps() {
		return customerRestaurantMaps;
	}

	public void setCustomerRestaurantMaps(List<CustomerRestaurantMap> customerRestaurantMaps) {
		this.customerRestaurantMaps = customerRestaurantMaps;
	}

	public UserCredential getUserCredential() {
		return userCredential;
	}

	public void setUserCredential(UserCredential userCredential) {
		this.userCredential = userCredential;
	}

	
	

	

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", address=" + address + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", email=" + email + ", password="
				+ password + ", cart=" + cart + ", userCredential=" + userCredential + ", role=" + role
				+ ", customerRestaurantMaps=" + customerRestaurantMaps + "]";
	}

	
}
