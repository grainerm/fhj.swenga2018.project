package at.fh.swenga.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import org.thymeleaf.util.DateUtils;

import at.fh.swenga.dao.RoleDAO;
import at.fh.swenga.model.Activity;
import at.fh.swenga.model.Role;
import at.fh.swenga.model.StandardKalorienVerbrauch;
import at.fh.swenga.model.User;
import at.fh.swenga.repositories.ActivityRepository;
import at.fh.swenga.repositories.StandardKalorienVerbrauchRepository;
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
	
	@Autowired 
	private StandardKalorienVerbrauchRepository skvRepo;
	
	@Autowired
	private ActivityRepository actRepo;
	

	@RequestMapping(value = { "/" })
	public String index(Model model) { 

		System.out.println("index method");
		String nickName = "";
		System.out.println("test");
		//Get nickname
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		nickName = authentication.getName();
		User user = userRepo.findByName(nickName);
		float bmi = -1;
		//System.out.println("user:"+ user.getVorname());
		//System.out.println("geschlecht|"+user.getGeschlecht()+"|");
		
		if(user.getGewicht() < 1 && user.getGroesse() < 1){
			// set weight and groeße for user 
			return "settings";
		} else {
			// calculate BMI
			// Körpergewicht in Kilogramm geteilt durch Körpergröße in Metern zum Quadrat
	        
			bmi = user.getGewicht() / (user.getGroesse()^2);
			System.out.println("bmi"+bmi);
		}
		// if user has set no weight - send it to the settings page
		if(bmi > 0) {
			model.addAttribute("bmi",bmi);
		}
		if(user != null) {
			if(user.getZielgewicht() < 1 || user.getGeburtstag() == null || user.getGeschlecht() == ' ') {
				
				System.out.println("Zielgwicht muas gsetzt sein, oida!");
				
				return "settings";
			} else {
				model.addAttribute("currentUser", user);
				// was er essen darf
				int caloriesPerDay = calulcateCaloriesPerDay(user);
				int caloriesEatenToday = calculateCaloriesEatenToday(user);
				int calosBurntToday = calculateCaloriesBurntToday(user);
				
				System.out.println("calosPerDay: " + caloriesPerDay);
				if(caloriesPerDay < 0) {
					System.out.println("fail in Berrechnung");
				}else {
					
					model.addAttribute("caloriesPerDay", caloriesPerDay);
				}
				if(caloriesEatenToday < 0) {
					System.out.println("fail in Berrechnung calos eaten today");
				} else {
					model.addAttribute("caloriesEatenToday", caloriesEatenToday);
				}
				if(calosBurntToday < 0) {
					System.out.println("fail in Berrechnung calos eaten today");
				} else {
					model.addAttribute("caloriesBurntToday", calosBurntToday);
				}

				return "index";
			}
		} else {
			return "error";
		}
		//System.out.println("user: " + nickName);
		//return "index"; 
	}
private int calculateCaloriesBurntToday(User user) {
		int calosBurntToday  = -1;

		
		System.out.println("BurntToday:");

		List<Activity> userActivities = actRepo.findByUser(user);
		if(userActivities.isEmpty()) {
			System.out.println("no activities found!");
			calosBurntToday = 0;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date today = new Date();
			calosBurntToday = 0;
			
			for(Activity act : userActivities) {
				System.out.println("act:" + act.getDatum() + " now:" + today);
				//DateUtils..isSameDay(this.toCalendar(today),toCalendar(act.getDatum());
				if(sdf.format(act.getDatum()).equals(sdf.format(today))) {
					if(act.getItem().getKalorien() < 0)
						calosBurntToday += (act.getItem().getKalorien() * -1);
				}
			}		
		}
		
		return calosBurntToday;
	}


private int calculateCaloriesEatenToday(User user) {
		int calosEatenPerDay = -1;
		
		System.out.println("EatenTOday:");

		List<Activity> userActivities = actRepo.findByUser(user);
		if(userActivities.isEmpty()) {
			System.out.println("no activities found!");
			calosEatenPerDay = 0;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date today = new Date();

			
			for(Activity act : userActivities) {
				System.out.println("act:" + act.getDatum() + " now:" + today);
				//DateUtils..isSameDay(this.toCalendar(today),toCalendar(act.getDatum());
				if(sdf.format(act.getDatum()).equals(sdf.format(today))) {
					if(act.getItem().getKalorien() > 0)
						calosEatenPerDay += act.getItem().getKalorien();
				}
			}		
		}
		
		return calosEatenPerDay;
	}

private  int  calulcateCaloriesPerDay(User user) {
	System.out.println("");
	System.out.println("caloriesPerDay");
	int caloriesPerDay = -1;
	//int zielgewicht = user.getZielgewicht();
	
	int age = calculateAge(user.getGeburtstag());
	
	System.out.println("age: "+age);
	if(age < 0) {
		System.out.println("fehler in Age berrechnung");
	}else {
		List<StandardKalorienVerbrauch> skvList = skvRepo.findByGeschlecht(user.getGeschlecht());
		if(skvList.isEmpty()) {
			System.out.println("insert data in SKV!!!");
		} else {
			for(StandardKalorienVerbrauch skv : skvList) {
				int unten = skv.getVonAlter();
				int oben = skv.getBisAlter();
				
				if(age < oben && age > unten) {
					caloriesPerDay = skv.getKalorien();
					break;
				}
			}
		}
	}
	return caloriesPerDay;		
	}



	private int calculateAge(Date geburtstag) {
	int age = -1;
	if(geburtstag != null) {
		age = Period.between(geburtstag.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).getYears();
	}
	return age;
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
	
	
	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";
	}
}
