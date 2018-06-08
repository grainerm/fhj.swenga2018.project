package at.fh.swenga.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import at.fh.swenga.dao.UserDAO;
import at.fh.swenga.model.User;
             


@Controller
public class CalculatorController {     
	     
	@Autowired
	UserDAO userDao;
	
	@RequestMapping(value = { "/", "list" })
	public String index(Model model) { 

		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerAccount(@Valid User newUser, BindingResult bindingResult,
			Model model) 
	{
		User user = userDao.getUser(newUser.getName());

		if (user != null) {
			model.addAttribute("errorMessage", "This account already exists!<br>");
		} else {
			userDao.persist(newUser);
			model.addAttribute("message", "Account created!");
		}
	    return "forward:/index";
	}
	

	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";
	}
}
