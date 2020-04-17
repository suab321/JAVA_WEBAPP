package com.abhinav.BootWeb.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {
	@GetMapping("/abhi")
	public int abhi(HttpServletRequest req) {
		req.getSession().setAttribute("name", "abhinav");
		return 1;
	}
	@GetMapping("/singh")
	public int singh(HttpServletRequest req) {
		System.out.println(req.getSession().getAttribute("name"));
		return 1;
	}
}
