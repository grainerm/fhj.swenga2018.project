package at.fh.swenga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.swenga.model.Drink;
import at.fh.swenga.model.Food;
import at.fh.swenga.model.Item;
import at.fh.swenga.model.Sport;
import at.fh.swenga.repositories.DrinkRepository;
import at.fh.swenga.repositories.FoodRepository;
import at.fh.swenga.repositories.ItemRepository;
import at.fh.swenga.repositories.SportRepository;


@Controller
public class InsertController {
	
	@Autowired(required = true)
	ItemRepository itemRepository;
	
	@Autowired(required = true)
	FoodRepository foodRepository;
	
	@Autowired(required = true)
	DrinkRepository drinkRepository;
	
	@Autowired(required = true)
	SportRepository sportRepository;
	
	@RequestMapping("/fillItemList")
	@Transactional
	public String fillData(Model model) {
		
		//Item
		
		
		Item f1 = new Item ("Apple", 52, true);
		itemRepository.save(f1);
		
		Item d1 = new Item ("Coca Cola", 37, true);
		itemRepository.save(d1);
		
		Item s1 = new Item ("Running", 300, true);
		itemRepository.save(s1);
		
		//Food
		
		Food apple = foodRepository.findByFoodItem("Apple");
		if (apple==null) apple = new Food(f1, 100);
		
		//Drink
		
		Drink cocaCola = drinkRepository.findByDrinkItem("Coca Cola");
		if (cocaCola==null) cocaCola = new Drink(d1, 100);
		
		//Sport
		
		Sport running = sportRepository.findBySportItem("Running");
		if (running==null) running = new Sport(s1, 30);
		
		return "forward:list";
	
	}
	
}
