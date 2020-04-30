package com.abhinav.FoodOrdering.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.abhinav.FoodOrdering.model.CartModel;

public class CartIdMapper implements RowMapper<CartModel>  {

	@Override
	public CartModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartModel cm=new CartModel();
		cm.setCartId(rs.getInt(1));
		cm.setUserId(rs.getInt(2));
		return cm;
	}
}
