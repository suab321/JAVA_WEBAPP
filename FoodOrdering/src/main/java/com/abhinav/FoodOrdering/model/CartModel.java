package com.abhinav.FoodOrdering.model;

public class CartModel {
	private int cartId;
	private int userId;

	public CartModel(){}
	
	public CartModel(int cartId,int userId) {
		this.cartId=cartId;
		this.userId=userId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
