package com.abhinav.FoodOrdering.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinav.FoodOrdering.Database.SpringDataBaseService;
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
}
