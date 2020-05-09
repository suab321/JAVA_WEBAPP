package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.SubTest;
import com.example.repository.SubTestRepository;

@Service
public class SubTestService {
	@Autowired
	private SubTestRepository stp;

	public boolean addSubTest(SubTest st) {
		stp.save(st);
		return true;
	}
	
	public List<SubTest> getSubTests(){
		List<SubTest> subtests = new ArrayList<SubTest>();
		stp.findAll().forEach(subtests::add);
		return subtests;
	}
	
//	public List<SubTest> getSubTestOnTest(int id){
////		List<SubTest> substests=new ArrayList<SubTest>();
////		return stp.findByTestId(id);
//	}
}
