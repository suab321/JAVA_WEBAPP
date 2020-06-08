package com.example.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dao.joinResponse;
import com.example.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select new com.example.dao.joinResponse(c.name, p.name) from Customer c join c.products p")
	public ArrayList<joinResponse> getsJoinInformation();
}
