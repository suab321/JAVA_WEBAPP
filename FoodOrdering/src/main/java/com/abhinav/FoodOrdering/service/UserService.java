package com.abhinav.FoodOrdering.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinav.FoodOrdering.Database.SpringDataBaseService;
import com.abhinav.FoodOrdering.Databasedao.FoodDao;
import com.abhinav.FoodOrdering.Databasedao.OrderDao;
import com.abhinav.FoodOrdering.model.FoodModel;

@Service
public class UserService {
	
	@Autowired
	private SpringDataBaseService sdbs;
	
	public ArrayList<FoodModel> getFood(){
		return (ArrayList<FoodModel>) sdbs.getFood();
	}
	
	public boolean addFoodToCart(int userId,int foodId) {
		return sdbs.addFoodToCart(userId, foodId);
	}
	public boolean placeOrder(int userId) {
		return sdbs.placeOrder(userId);
	}
	public List<OrderDao> getOrders(int userId) {
		Map<String,OrderDao> value=	 sdbs.getOrders(userId);
		List<OrderDao> values=new ArrayList<OrderDao>();
		for(Map.Entry<String, OrderDao> i :value.entrySet())
			values.add(i.getValue());
		return values;
	}
	public List<FoodDao> getCartItem(int userId){
		return sdbs.getCartItem(userId);
	}
}
