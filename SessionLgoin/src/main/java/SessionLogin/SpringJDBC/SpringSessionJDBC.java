package SessionLogin.SpringJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringSessionJDBC {
	
	@RequestMapping(value="/springSession",method=RequestMethod.GET)
	public ModelAndView get(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		HttpSession se=req.getSession();
		se.setAttribute("surname", "singh");
		mv.setViewName("name.jsp");
		return mv;
	}
}