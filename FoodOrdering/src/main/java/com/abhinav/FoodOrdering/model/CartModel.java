package com.abhinav.FoodOrdering.model;

public class CartModel {
	private int cartId;
	private int userId;
	private FoodModel food;
	private int itemCount;
	public CartModel(){
		cartId=0;
		food=null;
		userId=0;
		itemCount=0;
	}

	public FoodModel getFood() {
		return food;
	}

	public void setFood(FoodModel food) {
		this.food = food;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

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
