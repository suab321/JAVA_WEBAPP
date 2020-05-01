package com.abhinav.FoodOrdering.Databasedao;

public class FoodDao {
	private int foodId;
	private String foodName;
	private int itemCount;

	public FoodDao(){}
	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
}
