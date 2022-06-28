package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.domain.Customer;

@Controller // 컨트롤러 어노테이션을 등록만해도 빈으로 등록 된다.
public class APIController {
	// id, age로 파라미터 전송하는 web query 데이터 처리 
	@RequestMapping("getData1.do")// 확인을 위한 url : http://localhost:8080/mvc/getData1.do?id=busan!!&age=290
	public ModelAndView getOne(@RequestParam("id") String id, @RequestParam("age") int age) {
		System.out.println("id + age: "+id+"+"+age);
		ModelAndView model = new ModelAndView();
		//view 
		model.setViewName("view2");
		return model;
	}
	/*
		Model API
			- Model 클래스는 getParameter로 추출 할 수 없는 데이터를 
			  request객체에 저장하고자 할 때 사용 가능한 API이다.
			  model.addAttribute() = request.setAttribute() 함수와 같은 기능을 한다.
	*/
	@RequestMapping("getData2.do")// 확인을 위한 url : http://localhost:8080/mvc/getData2.do?name=busanKYJ&age=32
	public String getTwo(Model model, Customer customer) {
		System.out.println("customer 값 :  "+customer);
		model.addAttribute("msg","전달되는 문자열 AAA");
		model.addAttribute("name",customer.getName());
		model.addAttribute("age",customer.getAge());
		model.addAttribute("customer",customer);
		return "view2";
	}

	/*
		Customer customer = new Customer("busanKYJ",32);
		request.setAttribute("customer", customer); 를 한번에 해결한게 ModelAttribute이며, 사용법은 아래와 같다.
	*/
	@GetMapping(value = "getData3.do")// 확인을 위한 url : http://localhost:8080/mvc/getData3.do?name=busanKYJ&age=32
	public String getThree(@ModelAttribute("customer") Customer customer) {
		return "view2";
	}
	
	// 예외처리 확인을 위한 test 메소드 
	@GetMapping(value = "getData4.do") // 확인을 위한 url : http://localhost:8080/mvc/getData4.do?name=busanKYJ&age=32
	public String getFour() throws Exception {
		if(true) {
			throw new Exception("URL Exception");
		}
		return null;
	}
	@ExceptionHandler()
	public String exceptionHandling(Exception e) {
		return "failView.jsp?msg="+e.getMessage();
	}
	
	
}
