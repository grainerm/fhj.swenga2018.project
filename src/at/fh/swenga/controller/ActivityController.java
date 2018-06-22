package at.fh.swenga.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.model.Activity;
import at.fh.swenga.model.Drink;
import at.fh.swenga.model.Food;
import at.fh.swenga.model.GuestbookModel;
import at.fh.swenga.model.Item;
import at.fh.swenga.model.Sport;
import at.fh.swenga.model.User;
import at.fh.swenga.repositories.ActivityRepository;
import at.fh.swenga.repositories.DrinkRepository;
import at.fh.swenga.repositories.FoodRepository;
import at.fh.swenga.repositories.ItemRepository;
import at.fh.swenga.repositories.SportRepository;
import at.fh.swenga.repositories.UserRepository;

@Controller
public class ActivityController {



	@Autowired
	private FoodRepository foodRepo;

	@Autowired
	private DrinkRepository drinkRepo;

	@Autowired
	private SportRepository sportRepo;

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ActivityRepository activityRepo;
	
	private Authentication authentication;

	private List<Activity> addedActivities= new ArrayList<Activity>();

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public String activities(Model model) {


		authentication = SecurityContextHolder.getContext().getAuthentication();
		String nickname = authentication.getName();
		
		List<Food> foods = foodRepo.findAll();
		List<Drink> drinks = drinkRepo.findAll();
		List<Sport> sports = sportRepo.findAll();
		
		List<Activity> userActivities = new ArrayList<Activity>();
		userActivities.addAll(activityRepo.findByUserName(nickname));
		
		model.addAttribute("foods",  foods);
		model.addAttribute("drinks",  drinks);
		model.addAttribute("sports",  sports);
		model.addAttribute("addedActivities",  userActivities);
		return "activities";
	}


	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value = { "/add" })
	public String find(Model model, @RequestParam(value="bezeichnung") String bezeichnung, 
			@RequestParam(value="menge") int menge) 
	{
		List<Food> foods = foodRepo.findAll();
		List<Drink> drinks = drinkRepo.findAll();
		List<Sport> sports = sportRepo.findAll();

		authentication = SecurityContextHolder.getContext().getAuthentication();
		String nickname = authentication.getName();
		
		Item item = itemRepo.findByBezeichnung(bezeichnung).get(0);

		Activity activity = new Activity(new Date(), item, userRepo.findByName(nickname), menge);
		activity.setKalorienGesamt(menge * item.getKalorien());
		activityRepo.save(activity);
		addedActivities.add(activity);

		model.addAttribute("foods",  foods);
		model.addAttribute("drinks",  drinks);
		model.addAttribute("sports",  sports);
		model.addAttribute("sum",  activity.getKalorienGesamt());
		model.addAttribute("addedActivities",  addedActivities);

		return activities(model);
	}

	
}


