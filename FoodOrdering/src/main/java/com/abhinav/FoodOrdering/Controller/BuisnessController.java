package com.abhinav.FoodOrdering.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav.FoodOrdering.Databasedao.FoodDao;
import com.abhinav.FoodOrdering.Databasedao.OrderDao;
import com.abhinav.FoodOrdering.model.FoodModel;
import com.abhinav.FoodOrdering.service.UserService;

@RestController
public class BuisnessController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/getFoods")
	public ArrayList<FoodModel> getFoods(){
		return userService.getFood();
	}
	
	@GetMapping("/addToCart")
	public boolean addToCart(@RequestParam("userId")int userId,@RequestParam("foodId")int foodId,HttpServletRequest req) {
		return userService.addFoodToCart(userId, foodId);
	}
	@GetMapping("/placeOrder")
	public boolean placeOrder(@RequestParam("userId")int userId) {
		return userService.placeOrder(userId);
	}
	@GetMapping("/getOrder")
	public List<OrderDao> place(@RequestParam("userId")int userId) {
		return userService.getOrders(userId);
	}
	@GetMapping("/getCart")
	public List<FoodDao> getCartItem(@RequestParam("userId")int userId){
		return userService.getCartItem(userId);
	}
}
