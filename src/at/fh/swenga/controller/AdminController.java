package at.fh.swenga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.model.Drink;
import at.fh.swenga.model.Food;
import at.fh.swenga.model.Item;
import at.fh.swenga.model.Sport;
import at.fh.swenga.model.User;
import at.fh.swenga.repositories.DrinkRepository;
import at.fh.swenga.repositories.FoodRepository;
import at.fh.swenga.repositories.ItemRepository;
import at.fh.swenga.repositories.SportRepository;
import at.fh.swenga.repositories.UserRepository;

@Controller
public class AdminController 
{
	@Autowired
	UserRepository userRepo;

	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	FoodRepository foodRepo;
	
	@Autowired
	DrinkRepository drinkRepo;
	
	@Autowired
	SportRepository sportRepo;

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = { "/adminSettings" })
	public String adminSettings(Model model) 
	{ 
		model.addAttribute("users", userRepo.findAll());
		model.addAttribute("items", itemRepo.findByValidiertFalse());
		return "adminSettings"; 
	}

	@Secured("ROLE_ADMIN")
	@Transactional
	@RequestMapping(value="/deleteSelectedUser", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam(value="name") String name) 
	{ 
		if(name.equals("admin"))
			model.addAttribute("error", "Admin can't be deleted");
		else
		{
			userRepo.deleteByName(name);
			model.addAttribute("deleted", "User deleted");
		}
		return "forward:/adminSettings";
	}

	@Secured("ROLE_ADMIN")
	@Transactional
	@RequestMapping(value="/activateUser", method = RequestMethod.POST)
	public String activate(Model model, @RequestParam(value="name") String name) 
	{ 
		User user = userRepo.findByName(name);
		user.setAktiv(true);
		return "forward:/adminSettings";
	}

	@Secured("ROLE_ADMIN")
	@Transactional
	@RequestMapping(value="/lockUser", method = RequestMethod.POST)
	public String lock(Model model, @RequestParam(value="name") String name) 
	{ 
		User user = userRepo.findByName(name);
		user.setAktiv(false);
		return "forward:/adminSettings";
	}

	@Secured("ROLE_ADMIN")
	@Transactional
	@RequestMapping(value="/validate", method = RequestMethod.POST)
	public String validate(Model model, @RequestParam(value="bezeichnung") String bezeichnung) 
	{ 
		if(!itemRepo.findByBezeichnung(bezeichnung).isEmpty())
		{
			Item item = itemRepo.findByBezeichnung(bezeichnung).get(0);
			if(item.getArt().getBezeichnung().equals("Food"))
			{
				Food newFood = new Food(item, 100);
				foodRepo.save(newFood);
			}
			else if(item.getArt().getBezeichnung().equals("Drink"))
			{
				Drink newDrink = new Drink(item, 100);
				drinkRepo.save(newDrink);
			}
			else
			{
				Sport newSport = new Sport(30, item);
				sportRepo.save(newSport);
			}
			item.setValidiert(true);
		}
		return "forward:/adminSettings";
	}

	@Secured("ROLE_ADMIN")
	@Transactional
	@RequestMapping(value="/deleteItem", method = RequestMethod.GET)
	public String deleteItem(Model model, @RequestParam(value="bezeichnung") String bezeichnung) 
	{ 
		
		
		itemRepo.deleteByName(bezeichnung);
		return "forward:/adminSettings";
	}
	/*@Transactional
	@RequestMapping(value="/editUser", method = RequestMethod.POST)
	public String editUser(Model model, @RequestParam(required=false, value="name") String name, @RequestParam(value="activate", required=false) String activate,
			@RequestParam(value="delete", required=false) String delete) 
	{ 
		if(delete != null)
		{
			userRepo.deleteByName(name);
			return "forward:/adminSettings";
		}
		else if(activate != null)
		{
			User user = userRepo.findByName(name);
			if(user.isAktiv() == true)
				user.setAktiv(false);
			else
				user.setAktiv(true);


			return "forward:/adminSettings";
		}

		return "forward:/adminSettings";
	}*/
}
