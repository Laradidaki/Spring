package com.springdemo.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showFrom() {
		return "helloworld-form";
	}
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read form data and add data to the model
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		String name=request.getParameter("studentName");
		
		name=name.toUpperCase();
		
		String result="Ciao "+name;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormThree")
	public String processFormVersionThree(@RequestParam("studentName")String name, Model model) {
		
		name=name.toUpperCase();
		
		String result="Hello "+name+"!";
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
