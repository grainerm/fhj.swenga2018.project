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
import at.fh.swenga.repositories.ArtRepository;
import at.fh.swenga.repositories.DrinkRepository;
import at.fh.swenga.repositories.FoodRepository;
import at.fh.swenga.repositories.ItemRepository;
import at.fh.swenga.repositories.SportRepository;

@Controller
public class ItemController 
{
	@Autowired
	ArtRepository artRepo;
	
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	FoodRepository foodRepo;
	
	@Autowired
	DrinkRepository drinkRepo;
	
	@Autowired
	SportRepository sportRepo;

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@Transactional
	@RequestMapping(value= { "/addItem" })
	public String addItem(Model model, @RequestParam(value="bezeichnung") String bezeichnung, @RequestParam(value="kalorien") int kalorien, @RequestParam(value="type") String type) 
	{ 
		
		if(itemRepo.findByBezeichnung(bezeichnung).isEmpty())
		{
			Item item = new Item(bezeichnung, kalorien, false);
			item.setArt(artRepo.findByBezeichnung(type));
			itemRepo.save(item);
			
			model.addAttribute("success", "Item successfully added");
		}
		else
			model.addAttribute("error", "Item already existing");
		
		model.addAttribute("itemTypes", artRepo.findAll());
		return "items";
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value= { "/items" }, method=RequestMethod.GET)
	public String items(Model model) 
	{ 
		model.addAttribute("itemTypes", artRepo.findAll());

		return "items";
	}

}
