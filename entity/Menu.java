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
@Table(name = "MENU")
@JsonIgnoreType
public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENU_ID")
	private int menuId;
	
	@Column(name = "ITEM_NAME")
	private String itemName;
	
	@Column(name = "ITEM_PRICE")
	private double itemPrice;
	
	@Column(name = "RATING")
	private String rating;
	
	@Column(name = "QUANTITY")
	private int quantity;

	@OneToMany(mappedBy = "pk.menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartMenuMap> cartMenuMaps;
	
	@OneToMany(mappedBy = "pk.menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RestaurantMenuMap> restaurantMenuMaps;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<CartMenuMap> getCartMenuMaps() {
		return cartMenuMaps;
	}

	public void setCartMenuMaps(List<CartMenuMap> cartMenuMaps) {
		this.cartMenuMaps = cartMenuMaps;
	}

	public List<RestaurantMenuMap> getRestaurantMenuMaps() {
		return restaurantMenuMaps;
	}

	public void setRestaurantMenuMaps(List<RestaurantMenuMap> restaurantMenuMaps) {
		this.restaurantMenuMaps = restaurantMenuMaps;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartMenuMaps == null) ? 0 : cartMenuMaps.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(itemPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + menuId;
		result = prime * result + quantity;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((restaurantMenuMaps == null) ? 0 : restaurantMenuMaps.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (cartMenuMaps == null) {
			if (other.cartMenuMaps != null)
				return false;
		} else if (!cartMenuMaps.equals(other.cartMenuMaps))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(itemPrice) != Double.doubleToLongBits(other.itemPrice))
			return false;
		if (menuId != other.menuId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (restaurantMenuMaps == null) {
			if (other.restaurantMenuMaps != null)
				return false;
		} else if (!restaurantMenuMaps.equals(other.restaurantMenuMaps))
			return false;
		return true;
	}
	
}