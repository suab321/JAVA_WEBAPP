package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.TestModel;
import com.example.service.TestService;

@RestController
public class TestController {
	@Autowired
	private TestService ts;
	
	@RequestMapping("/test")
	public String test() {
		return "yes";
	}
	
	@RequestMapping("/list")
	public List<TestModel> getTests(){
		return ts.getTests();
	}

	@RequestMapping(value="/addTest",method=RequestMethod.POST)
	public boolean addTest(@RequestBody TestModel tm) {
		return ts.addTest(tm);
	}
	
	@RequestMapping("/getTest")
	public TestModel getTest(@RequestParam("id") int id) {
		return ts.getTest(id);
	}
	
	@RequestMapping("/updateTest")
	public boolean updateTest(@RequestBody TestModel tm) {
		return ts.updateTest(tm);
	}
	
	@RequestMapping("/deleteTest")
	public boolean deleteTest(@RequestParam("id") int id) {
		return ts.deleteTest(id);
	}
}
