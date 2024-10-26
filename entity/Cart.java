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

@Entity
@Table(name = "CART")
public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CART_ID")
	private int CartId;
	
	
	@Column(name = "TOTAL_PRICE")
	private int totalPrice;
	
	@OneToMany(mappedBy = "pk.cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartMenuMap> cartMenuMaps;

	public Cart(int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartMenuMap> getCartMenuMaps() {
		return cartMenuMaps;
	}

	public void setCartMenuMaps(List<CartMenuMap> cartMenuMaps) {
		this.cartMenuMaps = cartMenuMaps;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CartId;
		result = prime * result + ((cartMenuMaps == null) ? 0 : cartMenuMaps.hashCode());
		result = prime * result + totalPrice;
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
		Cart other = (Cart) obj;
		if (CartId != other.CartId)
			return false;
		if (cartMenuMaps == null) {
			if (other.cartMenuMaps != null)
				return false;
		} else if (!cartMenuMaps.equals(other.cartMenuMaps))
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}

	public void setNumberOfItems(int numberOfItems) {
		// TODO Auto-generated method stub
		
	}

	public int getNumberOfItems() {
		// TODO Auto-generated method stub
		return 0;
	}

}