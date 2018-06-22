package at.fh.swenga.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value = { "/settings" })
	public String settings(Model model) 
	{ 

		authentication = SecurityContextHolder.getContext().getAuthentication();
		String nickname = authentication.getName();

		boolean male = false;

		User currentUser = userRepo.findByName(nickname);
		if(currentUser.getGeschlecht() == 'm')
			male = true;
		else if(currentUser.getGeschlecht()=='\u0000')
			male = false;
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("male", male);
		return "settings"; 
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value = "/changeSettings", method = RequestMethod.POST)
	@Transactional
	public String changeSettings(@Valid User newUser, BindingResult bindingResult, RedirectAttributes attributes, 
			@RequestParam(value="optionsRadios") String radioValue, Model model, 
			@RequestParam(required=false, value="delete") String delete,
			@RequestParam(required=false, value="save") String save) 
	{		
		authentication = SecurityContextHolder.getContext().getAuthentication();
		String nickname = authentication.getName();
		if(delete != null)
		{
			userRepo.deleteByName(nickname);

			return "forward:/login";
		}
		else if(save != null)
		{
			boolean male = false;


			User currentUser = userRepo.findByName(nickname);

			if(currentUser != null)
			{
				currentUser.setGewicht(newUser.getGewicht());
				currentUser.setZielgewicht(newUser.getZielgewicht());
				currentUser.setGroesse(newUser.getGroesse());
				currentUser.setGeburtstag(newUser.getGeburtstag());
				if(radioValue.equals("male"))
				{
					currentUser.setGeschlecht('m');
					male = true;
				}
				else
				{
					currentUser.setGeschlecht('f');
					male = false;
				}
				userRepo.save(currentUser);
				if(newUser.getGeburtstag() == null || radioValue == null || newUser.getGroesse() == 0 || newUser.getGewicht() == 0 || newUser.getZielgewicht() == 0)
					model.addAttribute("error", "The fields must no be empty!");
				else
					model.addAttribute("success", "Information successfully updated!");
			}
			model.addAttribute("male", male);
			return "forward:/settings";
		}
		return "error";
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value="/deleteUser")
	public String delete(Model model) 
	{ 

		authentication = SecurityContextHolder.getContext().getAuthentication();
		String nickname = authentication.getName();
		userRepo.deleteByName(nickname);
		SecurityContextHolder.clearContext();
		return "forward:/login";
	}
}
