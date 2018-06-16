package at.fh.swenga.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
             


@Controller
public class CalculatorController {     
	       

	@RequestMapping(value = { "/" })
	public String index(Model model) { 

		return "index"; 
	}
	
	@RequestMapping(value = { "/settings" })
	public String settings(Model model) { 

		return "settings"; 
	}
	
	@RequestMapping(value = { "/activities" })
	public String activities(Model model) { 
 
		return "activities";
	}
	
	@RequestMapping(value = { "/items" })
	public String items(Model model) { 
 
		return "items";
	}
	
	@RequestMapping(value = { "/journal" })
	public String journal(Model model) { 

		return "journal";
	}
	
	@RequestMapping(value = { "/guestbook" })
	public String guestbook(Model model) { 

		return "guestbook";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";
	}
}
