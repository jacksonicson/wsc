package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import demo.Test;

public class TestController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("Test controller launched");
		return new ModelAndView("index.jsp");
	}
	
	public void setTest(Test test) {
		System.out.println("TestController controller injection of test");
	}

}
