/**
 * 
 */
package com.platzi.ereservation.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for customized login
 * @author silex189
 *
 */
@Controller
@RequestMapping("app")
public class LoginController {
	
	@GetMapping(value = {"/login", "/"})
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		String errorMessage = "User not authorized, first login";
		
		modelAndView.addObject("errorMessage", errorMessage);
		modelAndView.setViewName("login");
		
		return modelAndView;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}

}
