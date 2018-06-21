package at.fh.swenga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

@Controller
public class ActivityController {

	
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private DrinkRepository drinkRepo;
	
	@Autowired
	private SportRepository sportRepo;
	

	@Autowired
	private ActivityRepository activityRepo;
	
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public String activities(Model model) {

	
		List<Food> foods = foodRepo.findAll();
		List<Drink> drinks = drinkRepo.findAll();
		List<Sport> sports = sportRepo.findAll();
		
		
	/*for(Food food : foods)
	{

		System.out.println("activity:"+ food.getItem().getBezeichnung());
	}*/
		model.addAttribute("foods",  foods);
		model.addAttribute("drinks",  drinks);
		model.addAttribute("sports",  sports);

		
		
		
		
		//System.out.println("activity:"+ food.item());
		//model.addAttribute("food:" + food.toString());
		
		return "activities";
	}
	
	@RequestMapping(value = "/activitiesAdd", method = RequestMethod.POST)
    public String addEntry( Food activityModelForm, BindingResult bindingResult, Model model) 
	{
		
		System.out.println(activityModelForm.getItem().getBezeichnung());
        if (bindingResult.hasErrors()) {
            return "activities";
        }
        
      foodRepo.save(activityModelForm);
      
      return activities(model);
    }
	
	
	/*@RequestMapping(value = "/activitiesAll", method = RequestMethod.GET)
	public String activitiesAll(Model model) {

		List<Food> foods = foodRepo.findAll();
		List<Drink> drinks = drinkRepo.findAll();
		List<Sport> sports = sportRepo.findAll();
	for(Food food : foods)
	{

		System.out.println("activity:"+ food.getItem().getBezeichnung());
	}
		model.addAttribute("foods",  foods);
		model.addAttribute("drinks",  drinks);
		model.addAttribute("sports",  sports);

		
		
		//System.out.println("activity:"+ food.item());
		//model.addAttribute("food:" + food.toString());
		
		return "activities";
	}*/
	/*@RequestMapping(value = "/activities", method = RequestMethod.POST)
    public String addEntry(Activity activityModelForm, BindingResult bindingResult, Model model) 
	{
		
		
        if (bindingResult.hasErrors()) {
            return "activities";
        }
        
      //foodRepo.save(activityModelForm);
      
      //return activities(model);
    }*/
	
}


