package com.springdemo.mvc;

import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	//add InitBinder to convert trim input strings
	//remove leading and trailing white space
	//resolve issues for the validation form
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor= new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("user", new User());
		
		return "userForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		
		System.out.println("Binding Result: " + bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "userForm";
		}else {
			return "user-confirmation";
		}
		
	}
}
