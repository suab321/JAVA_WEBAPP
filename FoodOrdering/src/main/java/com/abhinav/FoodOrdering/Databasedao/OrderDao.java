package com.abhinav.FoodOrdering.Databasedao;

import java.util.List;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

public class OrderDao {
	private int userId;
	private int orderId;
	private String orderDate;
	private List<FoodDao> foods;
	
	public OrderDao() {}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<FoodDao> getFoods() {
		return foods;
	}

	public void setFoods(List<FoodDao> foods) {
		this.foods = foods;
	}
}
