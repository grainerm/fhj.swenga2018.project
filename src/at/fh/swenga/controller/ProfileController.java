package at.fh.swenga.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import at.fh.swenga.model.User;
import at.fh.swenga.repositories.UserRepository;

@Controller
public class ProfileController 
{
	@Autowired
	UserRepository userRepo;
	
	private Authentication authentication;
	
	@RequestMapping(value = "/changeSettings", method = RequestMethod.POST)
	@Transactional
    public String changeSettings(@Valid User newUser, BindingResult bindingResult, RedirectAttributes attributes, @RequestParam boolean male) 
	{
		System.out.println(newUser.getGeburtstag());
		System.out.println("Geschlecht "+male);

		
		authentication = SecurityContextHolder.getContext().getAuthentication();
		String nickname = authentication.getName();
		
		User currentUser = userRepo.findByName(nickname);
		if(currentUser != null)
		{
			currentUser.setGewicht(newUser.getGewicht());
			currentUser.setZielgewicht(newUser.getZielgewicht());
			userRepo.save(currentUser);
		}
		
		return "settings";
	}

}
