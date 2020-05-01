package com.abhinav.FoodOrdering.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.abhinav.FoodOrdering.Databasedao.FoodDao;
import com.abhinav.FoodOrdering.Databasedao.OrderDao;
import com.abhinav.FoodOrdering.model.CartModel;
import com.abhinav.FoodOrdering.model.FoodModel;
import com.abhinav.FoodOrdering.model.LoginModel;
import com.abhinav.FoodOrdering.model.RegisterModel;
import com.abhinav.FoodOrdering.service.CartIdMapper;
import com.abhinav.FoodOrdering.service.FoodMapper;
import com.abhinav.FoodOrdering.service.LoginMapper;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;

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
		String query1="update cart set itemCount=itemCount+1 where userId=? and foodId=? and ordered=0";
		int res=jt.update(query1,new Object[] {userId,foodId});
		if(res>0)
			return true;
		String query="insert into cart(userId,foodId,itemCount,ordered) values(?,?,?,0);";
		try {
			int a=jt.update(query,new Object[] {userId,foodId,1});
			if(a>0)
				return true;
			else
				return false;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}	
	}

	public boolean updateCart(int userId) {
		String query="update cart set ordered=1 where userId=? and ordered=0";
		try {
			int a=jt.update(query,new Object[] {userId});
			if(a>0)
				return true;
			else
				return false; 
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean placeOrder(int userId) {
		String query1="select cartId,userId from cart where userId=? and ordered=0;";
		try {
			List<CartModel> items=jt.query(query1, new Object[] {userId},new CartIdMapper());
			Date date=Calendar.getInstance().getTime();
			if(items.size()==0)
				return true;
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
				if(result>0) {
					return updateCart(userId);
				}
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

	public Map<String,OrderDao > getOrders(int userId){
		String query="select Food_Id,Name,userId,itemCount,orderDate,orderId from food inner join(select cart.userId,cart.itemCount,cart.foodId,orderDate,orderId from cart inner join (select cartId,orderDate,orderId from orderHistory where userId=? and orderDate in (select distinct orderDate from orderHistory))as carts on carts.cartId=cart.cartId) as foods on foods.foodId=food.Food_Id;";
		Map<String, OrderDao> values=new HashMap<String,OrderDao>();
		jt.query(query,new Object[] {userId},new RowMapper<Pair<OrderDao,String>>() {
			public Pair<OrderDao, String>  mapRow(ResultSet rs,int rowNum) throws SQLException {
				if(values.containsKey(rs.getString(5))) {
					OrderDao od=values.get(rs.getString(5));
					FoodDao fd=new FoodDao();
					fd.setFoodId(rs.getInt(1));
					fd.setFoodName(rs.getString(2));
					fd.setItemCount(rs.getInt(4));
					od.getFoods().add(fd);
				}
				else {
					OrderDao od=new OrderDao();
					od.setUserId(userId);
					od.setOrderDate(rs.getString(5));
					od.setOrderId(rs.getInt(6));
					List<FoodDao> foodList=new ArrayList<FoodDao>();
					od.setFoods(foodList);
					FoodDao fd=new FoodDao();
					fd.setFoodId(rs.getInt(1));
					fd.setFoodName(rs.getString(2));
					fd.setItemCount(rs.getInt(4));
					od.getFoods().add(fd);

					values.put(rs.getString(5), od);
				}
				return null;
			}
		});
		System.out.println(values.size());
		return values;
	}
	
	public List<FoodDao> getCartItem(int userId){
		String query="select foodId,Name,itemCount from food inner join(select cartId,itemCount,foodId from cart where userId=? and ordered=0) as foods on foods.foodId=Food_Id ;";
		List<FoodDao> foodList=jt.query(query,new Object[] {userId},new RowMapper<FoodDao>() {
			public FoodDao mapRow(ResultSet rs,int rowNum) throws SQLException{
				FoodDao fd=new FoodDao();
				fd.setFoodId(rs.getInt(1));
				fd.setFoodName(rs.getString(2));
				fd.setItemCount(rs.getInt(3));
				return fd;
			}
		});
		return foodList;
	}
}
