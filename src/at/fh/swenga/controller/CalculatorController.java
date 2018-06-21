package at.fh.swenga.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import at.fh.swenga.dao.RoleDAO;
import at.fh.swenga.model.Role;
import at.fh.swenga.model.User;
import at.fh.swenga.repositories.UserRepository;
import at.fh.swenga.service.UserService;
             


@Controller
public class CalculatorController {     
	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserService userService;
	
	//Get nickname
	private Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	@RequestMapping(value = { "/" })
	public String index(Model model) { 
		/**String nickName = "";
		
		nickName = authentication.getName();
		User user = userRepo.findByName(nickName);
		// if user has set no weight - send it to the settings page
		if(user != null) {
			if(user.getZielgewicht() < 1) {
				System.out.println("Zielgwicht muas gsetzt sein, oida!");
				
				return "settings";
			} else {
				model.addAttribute("user", user);
				// was er essen darf
				
				// was er gegessen hat (activities)
				model.addAttribute("caloriesPerDay", 120);
				return "index";
			}
		} else {
			return "error";
		}
		//System.out.println("user: " + nickName);**/
		
		return "index"; 
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
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	@Transactional
    public String registration(@Valid UserDto newUser, BindingResult bindingResult, RedirectAttributes attributes) 
	{
		
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
        	attributes.addFlashAttribute("exists", "User already existing!");
        else  
        {
        	userService.save(newUser);
            attributes.addFlashAttribute("registered", "Account created!");
        }
        return "redirect:/login";
    }
	
	@RequestMapping(value = "/fillRoles", method = RequestMethod.GET)
	@Transactional
    public String fillRoles() 
	{
		
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

        userService.createUsers();
        
        /*UsernamePasswordAuthenticationToken authReq =
                new UsernamePasswordAuthenticationToken(user.getName(), user.getPasswort());
            Authentication auth = authManager.authenticate(authReq);
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
            HttpSession session = request.getSession(true);
            session.setAttribute("SPRING_SECURITY_CONTEXT", sc);*/
        
        return "login";
    }
	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";
	}
}
