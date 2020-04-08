package springFirst;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springFirst.model.TestModel;

@Controller
public class Add {
	
	//simple getmethod
	@RequestMapping(value= "/test",method=RequestMethod.GET)
	public ModelAndView test(HttpServletRequest req,HttpServletResponse res) {
		int i=Integer.parseInt(req.getParameter("n1"));
		int j=Integer.parseInt(req.getParameter("n2"));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("abhi.jsp");
		mv.addObject("h1",(i+j));
		return mv;
	}
	
	//path parameter
	@ResponseBody
	@RequestMapping(value="/abhi/{id}/{subid}",method=RequestMethod.GET)
	public String abhi(@PathVariable(value="id") String id,@PathVariable(value="subid")String subid) {
		return (id+subid);
	}
	
	//queryParameter
	@ResponseBody
	@RequestMapping(value="/abhi2",method=RequestMethod.GET)
	public String abhi2(@RequestParam(value="id") String id) {
		return id;
	}
	//post body request
	@RequestMapping(value="/abhi3",method=RequestMethod.POST,consumes="application/json")
	@ResponseBody
//	@PostMapping(path="/abhi3")
	public String abhi3(@RequestBody TestModel tm) {
		return tm.getName()+tm.getPass();
	}

	@RequestMapping(value="/form",method=RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("form.jsp");
		return mv;
	}
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
		public String submit(@ModelAttribute("test") TestModel tm,BindingResult br) {
			if(br.hasErrors())
				return "";
			System.out.println(tm.getName()+" "+tm.getPass());
			ModelAndView mv=new ModelAndView();
			mv.setViewName("form.jsp");
			mv.addObject("name", tm.getName());
			return "form.jsp";
	}
}
