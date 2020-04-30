package com.abhinav.FoodOrdering.Database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.abhinav.FoodOrdering.model.CartModel;
import com.abhinav.FoodOrdering.model.FoodModel;
import com.abhinav.FoodOrdering.model.LoginModel;
import com.abhinav.FoodOrdering.model.RegisterModel;
import com.abhinav.FoodOrdering.service.CartIdMapper;
import com.abhinav.FoodOrdering.service.FoodMapper;
import com.abhinav.FoodOrdering.service.LoginMapper;

@Service
public class SpringDataBaseService {
	private static JdbcTemplate jt;
	static {
		jt=new JdbcTemplate(ConnectionPool.getDataSource());
	}
	public boolean isUserValid(LoginModel lm) {
		String query="select * from user where Email=? and Password=?";
		System.out.println(lm.getEmail());
		System.out.println(lm.getPassword());
		try {
			LoginModel l=jt.queryForObject(query,new Object[] {lm.getEmail(),lm.getPassword()},new LoginMapper());
			if(l==null)
				return false;
			else
				return true;
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	public boolean insertUser(RegisterModel rm) {
		String query="insert into user(Name,Email,Password,Address) values(?,?,?,?)";
		int a=0;
		try {
			a=jt.update(query,new Object[]{rm.getName(),rm.getEmail(),rm.getPassword(),rm.getAddress()});
			if(a==1)
				return true;
			else
				return false;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public List<FoodModel> getFood(){
		String query="select * from food";
		try {
			List<FoodModel> foods=jt.query(query,new FoodMapper());
			return foods;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return new ArrayList<FoodModel>();
		}
	}
	
	public boolean addFoodToCart(int userId,int foodId) {
		String query="insert into cart(userId,foodId,itemCount) values(?,?,?) on duplicate key update itemCount=itemCount+1;";
		try {
			int a=jt.update(query,new Object[] {userId,foodId,1});
			if(a!=0)
				return true;
			else
				return false;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
	}

	public boolean placeOrder(int userId) {
		String query1="select cartId,userId from cart where userId=?;";
		try {
			List<CartModel> items=jt.query(query1, new Object[] {userId},new CartIdMapper());
			Date date=Calendar.getInstance().getTime();
			String query2="insert into orderHistory(cartId,userId,orderDate) values";
			int cnt=0;
			for(CartModel i:items) {
				if(cnt>0)
					query2=query2+",("+i.getCartId()+","+i.getUserId()+","+"'"+date+"'"+")";
				else
					query2=query2+"("+i.getCartId()+","+i.getUserId()+","+"'"+date+"'"+")";
				++cnt;
			}
			System.out.println(query2);
			try {
				int result=jt.update(query2);
				if(result>0)
					return true;
				else
					return false;
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
				return false;
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}
