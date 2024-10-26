package com.foodapp.foodapp.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_RESTAURANT")
public class CustomerRestaurantMap implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CustomerRestaurantPK pk;

	public CustomerRestaurantPK getPk() {
		return pk;
	}

	public void setPk(CustomerRestaurantPK pk) {
		this.pk = pk;
	}

}