package at.fh.swenga.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import at.fh.swenga.model.User;
import at.fh.swenga.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(
	  @ModelAttribute("user") @Valid UserDto accountDto, 
	  BindingResult result, 
	  WebRequest request, 
	  Errors errors) {
	     
	    User registered = new User();
	    if (!result.hasErrors()) {
	        registered = createUserAccount(accountDto, result);
	    }
	    if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
	    if (result.hasErrors()) {
	        return new ModelAndView("registration", "user", accountDto);
	    } 
	    else {
	        return new ModelAndView("successRegister", "user", accountDto);
	    }
	}
	private User createUserAccount(UserDto accountDto, BindingResult result) {
	    User registered = null;
	    try {
	        registered = service.registerNewUserAccount(accountDto);
	    } catch (Exception e) {
	        return null;
	    }
	    return registered;
	}
}
