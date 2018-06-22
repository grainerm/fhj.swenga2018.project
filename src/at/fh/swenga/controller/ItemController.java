package at.fh.swenga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.model.Art;
import at.fh.swenga.model.Item;
import at.fh.swenga.repositories.ArtRepository;
import at.fh.swenga.repositories.ItemRepository;

@Controller
public class ItemController 
{
	@Autowired
	ArtRepository artRepo;
	
	@Autowired
	ItemRepository itemRepo;

	@Transactional
	@RequestMapping(value= { "/addItem" })
	public String delete(Model model, @RequestParam(value="bezeichnung") String bezeichnung, @RequestParam(value="kalorien") int kalorien, @RequestParam(value="type") String type) 
	{ 
		
		if(itemRepo.findByBezeichnung(bezeichnung).isEmpty())
		{
			Item item = new Item(bezeichnung, kalorien, false);
			item.setArt(artRepo.findByBezeichnung(type));
			itemRepo.save(item);
		}
		
		return "forward:/items";
	}
	
	@RequestMapping(value= { "/items" }, method=RequestMethod.GET)
	public String items(Model model) 
	{ 
		for(Art art : artRepo.findAll())
		{
			System.out.println(art.getBezeichnung());
		}
		model.addAttribute("itemTypes", artRepo.findAll());

		return "items";
	}

}
