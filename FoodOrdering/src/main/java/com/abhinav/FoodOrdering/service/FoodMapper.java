package com.abhinav.FoodOrdering.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.abhinav.FoodOrdering.model.FoodModel;

public class FoodMapper implements RowMapper<FoodModel> {

	@Override
	public FoodModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		FoodModel fm=new FoodModel();
		fm.setFood_Id(rs.getInt(1));
		fm.setFoodName(rs.getString(2));
		return fm;
	}
}
