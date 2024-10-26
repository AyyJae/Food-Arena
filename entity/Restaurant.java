package com.foodapp.foodapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
@Table(name = "RESTAURANT")
@JsonIgnoreType
public class Restaurant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESTAURANT_ID")
	private long restaurantId;

	@Column(name = "RESTAURANT_NAME")
	private String restaurantName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	public Restaurant() {
		super();
	}
	
	@Column(name = "RATING")
	private String rating;
	
	@OneToMany(mappedBy = "pk.restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RestaurantMenuMap> restaurantMenuMaps;
	
	@OneToMany(mappedBy = "pk.restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CustomerRestaurantMap> customerRestaurantMaps;
	public Restaurant(int restaurantId, String restaurantName, String address, String rating) {
		super();
		this.restaurantId = restaurantId;
		this.address = address;
		this.rating = rating;
		this.restaurantName = restaurantName;
		
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public int setRestaurantId(long l) {
		this.restaurantId = l;
		return 0;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<RestaurantMenuMap> getRestaurantMenuMaps() {
		return restaurantMenuMaps;
	}

	public void setRestaurantMenuMaps(List<RestaurantMenuMap> restaurantMenuMaps) {
		this.restaurantMenuMaps = restaurantMenuMaps;
	}

	public List<CustomerRestaurantMap> getCustomerRestaurantMaps() {
		return customerRestaurantMaps;
	}

	public void setCustomerRestaurantMaps(List<CustomerRestaurantMap> customerRestaurantMaps) {
		this.customerRestaurantMaps = customerRestaurantMaps;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
				+ address + ", rating=" + rating + ", restaurantMenuMaps=" + restaurantMenuMaps
				+ ", customerRestaurantMaps=" + customerRestaurantMaps + "]";
	}

	

}