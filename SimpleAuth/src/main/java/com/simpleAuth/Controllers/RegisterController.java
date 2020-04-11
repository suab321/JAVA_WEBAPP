package com.simpleAuth.Controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpleAuth.Dao.UserDaoImpl;
import com.simpleAuth.Service.PasswordValidation;
import com.simpleAuth.model.RegisterModel;

@Controller
public class RegisterController {
	
	@Autowired
	private UserDaoImpl ud;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView registerPage() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("register.jsp");
		return mav;
	}
	
	@RequestMapping(value="/registerProcess",method=RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute("registerData") RegisterModel rm) throws ClassNotFoundException, SQLException {
		ModelAndView mav=new ModelAndView();
		if(!PasswordValidation.validate(rm.getPassword(), rm.getCPassword())) {
			mav.setViewName("error.jsp");
			mav.addObject("error","password invalid does not match");
			return mav;
		}
		if(ud.insert(rm))
			mav.setViewName("index.jsp");
		else
			mav.setViewName("error.jsp");
		return mav;
	}
}
