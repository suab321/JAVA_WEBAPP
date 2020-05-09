package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.TestModel;
import com.example.repository.TestRepository;

@Service
public class TestService {
	@Autowired
	private TestRepository tp;
	
	public List<TestModel> getTests(){
		List<TestModel> tests=new ArrayList<TestModel>();
		tp.findAll().forEach(tests::add);
		return tests;
	}
	
	public boolean addTest(TestModel tm) {
		if (tp.save(tm)==null) return false;
		else return true;
	}
	
	public boolean deleteTest(int testId) {
		tp.deleteById(testId);
		return true;
	}
	
	public TestModel getTest(int testId) {
		return tp.findById(testId).orElse(null);
	}

	public boolean updateTest(TestModel tm) {
		tp.save(tm);
		return true;
	}

}
