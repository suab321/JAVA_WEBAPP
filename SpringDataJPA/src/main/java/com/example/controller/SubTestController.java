package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SubTest;
import com.example.service.SubTestService;

@RestController
public class SubTestController {
	
	@Autowired
	private SubTestService sts;
	
	@RequestMapping(value="/addSubTest", method=RequestMethod.POST)
	public boolean addSubTest(@RequestBody SubTest st) {
		System.out.println(st.getTm());
		return sts.addSubTest(st);
	}

	@RequestMapping("/getSubTests")
	public List<SubTest> getSubTests(){
		return sts.getSubTests();
	}
	@RequestMapping("/getSubTest")
	public SubTest getSubTest(@RequestParam String name) {
		return sts.getSubTest(name);
	}
	@RequestMapping("/getBytopic")
	public List<SubTest> getList(@RequestParam int id){
		return sts.getSubTestbyTmId(id);
	}
}
