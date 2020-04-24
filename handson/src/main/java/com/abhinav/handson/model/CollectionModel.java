package com.abhinav.handson.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CollectionModel {
	
	@Autowired
	private List<Integer> value;
	
	public CollectionModel() {}

	public void values() {
		for(int i:this.value)
			System.out.println(i);
	}
}
