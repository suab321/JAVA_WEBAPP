package com.simpleAuth.Controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpleAuth.Dao.UserDaoImpl;
import com.simpleAuth.model.LoginModel;

@Controller
public class LoginController {
	
	@Autowired
	private UserDaoImpl ud;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
	}
	
	@RequestMapping(value="/loginProccess",method=RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute("loginData") LoginModel lm) throws SQLException, ClassNotFoundException {
		ModelAndView mv=new ModelAndView();
		if(ud.validate(lm)) {
			mv.setViewName("index.jsp");
			return mv;
		}
		mv.setViewName("error.jsp");
		return mv;
			
	}
}
