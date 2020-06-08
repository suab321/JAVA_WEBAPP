package com.example.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repository.CustomerRepository;
import com.example.Repository.ProductRepository;
import com.example.dao.joinResponse;
import com.example.entity.Customer;
import com.example.entity.Product;

@RestController
public class Ordercontroller {
	
	@Autowired
	private CustomerRepository cp;
	@Autowired
	private ProductRepository pr;
	
	@PostMapping("/addCustomer")
	public boolean addCustomer(@RequestBody Customer c) {
		System.out.println(c.getAddress());
		cp.save(c);
		return true;
	}
	
	@PostMapping("/addProduct")
	public boolean addProduct(@RequestBody Product pro) {
		pr.save(pro);
		return true;
	}
	@GetMapping("/join")
	public ArrayList<joinResponse> getinfo(){
		return  cp.getsJoinInformation();
	}
}
