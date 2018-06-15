package at.fh.swenga.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import at.fh.swenga.dao.RoleDAO;
import at.fh.swenga.dao.UserDAO;
import at.fh.swenga.model.Role;
import at.fh.swenga.model.User;
import at.fh.swenga.service.UserService;
             


@Controller
public class CalculatorController {     
	@Autowired     
	private UserDAO userDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "/", "list" })
	public String index(Model model) { 

		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	@Transactional
    public String registration(@Valid UserDto newUser, BindingResult bindingResult, RedirectAttributes attributes) 
	{
		boolean error = false;
		
		if(roleDao.getRole(1)==null)
		{
			Role admin = new Role("ROLE_ADMIN");
			roleDao.persist(admin);
		}
		if(roleDao.getRole(2)==null)
		{
			Role user = new Role("ROLE_USER");
			roleDao.persist(user);
		}
		if(roleDao.getRole(3)==null)
		{
			Role guest = new Role("ROLE_GUEST");
			roleDao.persist(guest);
		}
		
        if (bindingResult.hasErrors()) {
            return "error";
        }
        

        if(userService.exists(newUser.getNickname()))
        	attributes.addFlashAttribute("exists", "User existiert bereits!");
        else
        {
        	userService.save(newUser);
            attributes.addFlashAttribute("registered", "Account wurde erstellt!");
        }
        return "redirect:/login";
    }
	

	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";
	}
}
