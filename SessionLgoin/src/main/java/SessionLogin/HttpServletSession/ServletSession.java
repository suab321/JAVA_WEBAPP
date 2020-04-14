package SessionLogin.HttpServletSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServletSession {
	
//	@RequestMapping(value="/name1", method=RequestMethod.GET)
//	public String page1() {
////		HttpSession se=req.getSession();
////		se.setAttribute("name", "abhinav");
//		return "name";
//	}

	@RequestMapping(value="/name", method=RequestMethod.GET)
	public ModelAndView page(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("name.jsp");
		HttpSession se=req.getSession();
		System.out.println(se.getAttribute("name"));
		se.setAttribute("name", "abhinav");
		
		return mv;
	}

	@RequestMapping(value="/setValue",method=RequestMethod.GET)
	public ModelAndView show(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("name.jsp");
		HttpSession se=req.getSession();
		System.out.println(se.getAttribute("name"));
		return mv;
	}

	@RequestMapping(value="/expire",method=RequestMethod.GET)
	public ModelAndView expire(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("name.jsp");
		HttpSession se=req.getSession();
		se.invalidate();
		return mv;
	}

}
