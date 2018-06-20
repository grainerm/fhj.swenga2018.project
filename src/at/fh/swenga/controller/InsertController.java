package at.fh.swenga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.swenga.model.Art;
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
public class InsertController {
	
	@Autowired(required = true)
	ItemRepository itemRepository;
	
	@Autowired(required = true)
	FoodRepository foodRepository;
	
	@Autowired(required = true)
	DrinkRepository drinkRepository;
	
	@Autowired(required = true)
	SportRepository sportRepository;
	
	@Autowired(required = true)
	ArtRepository artRepository;
	
	
	@RequestMapping("/fillItemList")
	@Transactional
	public String fillData(Model model) {
		
		//Art
		
		Art food = artRepository.findByBezeichnung("Food");
		if (food==null) food = new Art("Food");
		
		Art drink = artRepository.findByBezeichnung("Drink");
		if (drink==null) drink = new Art("Drink");
		
		Art sport = artRepository.findByBezeichnung("Sport");
		if (sport==null) sport = new Art("Sport");
		
		
		//Item
		
		
		Item f1 = new Item ("Apple", 52, true);
		f1.setArt(food);
		
		itemRepository.save(f1);
		
		Item f2 = new Item ("Beef", 250, true);
		f2.setArt(food);
		
		itemRepository.save(f2);
		
		Item f3 = new Item ("Pork", 242, true);
		f3.setArt(food);
		
		itemRepository.save(f3);
		
		Item f4 = new Item ("Lamb", 294, true);
		f4.setArt(food);
		
		itemRepository.save(f4);
		
		Item f5 = new Item ("Chicken", 239, true);
		f5.setArt(food);
		
		itemRepository.save(f5);
		
		Item f6 = new Item ("Pasta", 131, true);
		f6.setArt(food);
		
		itemRepository.save(f6);
		
		Item f7 = new Item ("Rice", 130, true);
		f7.setArt(food);
		
		itemRepository.save(f7);
		
		Item f8 = new Item ("Potatoes", 77, true);
		f8.setArt(food);
		
		itemRepository.save(f8);
		
		Item f9 = new Item ("White Bread", 265, true);
		f9.setArt(food);
		
		itemRepository.save(f9);
		
		Item f10 = new Item ("Dark Bread", 259, true);
		f10.setArt(food);
		
		itemRepository.save(f10);
		
		Item f11 = new Item ("Egg", 155, true);
		f11.setArt(food);
		
		itemRepository.save(f11);
		
		Item f12 = new Item ("Ham", 110, true);
		f12.setArt(food);
		
		itemRepository.save(f12);
		
		Item f13 = new Item ("French Fries", 312, true);
		f13.setArt(food);
		
		itemRepository.save(f13);
		
		Item f14 = new Item ("Double Hamburger", 295, true);
		f14.setArt(food);
		
		itemRepository.save(f14);
		
		Item f15 = new Item ("Pizza Margherita", 204, true);
		f15.setArt(food);
		
		itemRepository.save(f15);
		
		Item f16 = new Item ("Tomato", 18, true);
		f16.setArt(food);
		
		itemRepository.save(f16);
		
		Item f17 = new Item ("Cheese", 402, true);
		f17.setArt(food);
		
		itemRepository.save(f17);
		
		Item f18 = new Item ("Fish", 206, true);
		f18.setArt(food);
		
		itemRepository.save(f18);
		
		Item f19 = new Item ("Salad", 152, true);
		f19.setArt(food);
		
		itemRepository.save(f19);
		
		Item f20 = new Item ("Pear", 57, true);
		f20.setArt(food);
		
		itemRepository.save(f20);
		
		
		
		//--------------------------------------------------
		
		Item d1 = new Item ("Coca Cola", 37, true);
		d1.setArt(drink);
		
		itemRepository.save(d1);
		
		Item d2 = new Item ("Pepsi Cola", 41, true);
		d2.setArt(drink);
		
		itemRepository.save(d2);
		
		Item d3 = new Item ("Ice Tea", 35, true);
		d3.setArt(drink);
		
		itemRepository.save(d3);
		
		Item d4 = new Item ("Sprite", 39, true);
		d4.setArt(drink);
		
		itemRepository.save(d4);
		
		Item d5 = new Item ("Almdudler", 33, true);
		d5.setArt(drink);
		
		itemRepository.save(d5);
		
		Item d6 = new Item ("Orange Juice", 29, true);
		d6.setArt(drink);
		
		itemRepository.save(d6);
		
		Item d7 = new Item ("Apple Juice", 46, true);
		d7.setArt(drink);
		
		itemRepository.save(d7);
		
		Item d8 = new Item ("Red Wine", 85, true);
		d8.setArt(drink);
		
		itemRepository.save(d8);
		
		Item d9 = new Item ("White Wine", 82, true);
		d9.setArt(drink);
		
		itemRepository.save(d9);
		
		Item d10 = new Item ("Beer", 43, true);
		d10.setArt(drink);
		
		itemRepository.save(d10);
		
		Item d11 = new Item ("Cranberry Juice", 46, true);
		d11.setArt(drink);
		
		itemRepository.save(d11);
		
		Item d12 = new Item ("Tomato Juice", 17, true);
		d12.setArt(drink);
		
		itemRepository.save(d12);
		
		Item d13 = new Item ("Carrots Juice", 39, true);
		d13.setArt(drink);
		
		itemRepository.save(d13);
		
		Item d14 = new Item ("Gin", 263, true);
		d14.setArt(drink);
		
		itemRepository.save(d14);
		
		Item d15 = new Item ("Hot Chocolate", 77, true);
		d15.setArt(drink);
		
		itemRepository.save(d15);
		
		Item d16 = new Item ("Emotion", 15, true);
		d16.setArt(drink);
		
		itemRepository.save(d16);
		
		Item d17 = new Item ("Martini Bianco", 145, true);
		d17.setArt(drink);
		
		itemRepository.save(d17);
		
		Item d18 = new Item ("Radler", 42, true);
		d18.setArt(drink);
		
		itemRepository.save(d18);
		
				
		//------------------------------------------------
		
		Item s1 = new Item ("Running", 300, true);
		s1.setArt(sport);
		
		itemRepository.save(s1);
		
		Item s2 = new Item ("Volleyball", 156, true);
		s2.setArt(sport);
		
		itemRepository.save(s2);
		
		Item s3 = new Item ("Tennis", 288, true);
		s3.setArt(sport);
		
		itemRepository.save(s3);
		
		Item s4 = new Item ("Swimming", 367, true);
		s4.setArt(sport);
		
		itemRepository.save(s4);
		
		Item s5 = new Item ("Walking", 80, true);
		s5.setArt(sport);
		
		itemRepository.save(s5);
		
		Item s6 = new Item ("Bycicle Riding", 315, true);
		s6.setArt(sport);
		
		itemRepository.save(s6);
		
		Item s7 = new Item ("Soccer", 273, true);
		s7.setArt(sport);
		
		itemRepository.save(s7);
		
		Item s8 = new Item ("Icehockey", 325, true);
		s8.setArt(sport);
		
		itemRepository.save(s8);
		
		Item s9 = new Item ("Climbing", 400, true);
		s9.setArt(sport);
		
		itemRepository.save(s9);
		
		Item s10 = new Item ("Basketball", 300, true);
		s10.setArt(sport);
		
		itemRepository.save(s10);
		
		//Food
		
		Food apple = foodRepository.findByItem("Apple");
		if (apple==null) apple = new Food(f1, 100);
		
		Food beef = foodRepository.findByItem("Beef");
		if (beef==null) beef = new Food(f2, 100);
		
		Food pork = foodRepository.findByItem("Pork");
		if (pork==null) pork = new Food(f3, 100);
		
		Food lamb = foodRepository.findByItem("Lamb");
		if (lamb==null) lamb = new Food(f4, 100);
		
		Food chicken = foodRepository.findByItem("Chicken");
		if (chicken==null) chicken = new Food(f5, 100);
		
		Food pasta = foodRepository.findByItem("Pasta");
		if (pasta==null) pasta = new Food(f6, 100);
		
		Food rice = foodRepository.findByItem("Rice");
		if (rice==null) rice = new Food(f7, 100);
		
		Food potatoes = foodRepository.findByItem("Pork");
		if (potatoes==null) potatoes = new Food(f8, 100);
		
		Food whiteBread = foodRepository.findByItem("White Bread");
		if (whiteBread==null) whiteBread = new Food(f9, 100);
		
		Food darkBread = foodRepository.findByItem("Dark Bread");
		if (darkBread==null) darkBread = new Food(f10, 100);
		
		Food egg = foodRepository.findByItem("Egg");
		if (egg==null) egg = new Food(f11, 100);
		
		Food ham = foodRepository.findByItem("Ham");
		if (ham==null) ham = new Food(f12, 100);
		
		Food fries = foodRepository.findByItem("French Fries");
		if (fries==null) fries = new Food(f13, 100);
		
		Food hamburger = foodRepository.findByItem("Double Hamburger");
		if (hamburger==null) hamburger = new Food(f14, 100);
		
		Food pizza = foodRepository.findByItem("Pizza Margherita");
		if (pizza==null) pizza = new Food(f15, 100);
		
		Food tomato = foodRepository.findByItem("Tomato");
		if (tomato==null) tomato = new Food(f16, 100);
		
		Food cheese = foodRepository.findByItem("Cheese");
		if (cheese==null) cheese = new Food(f17, 100);
		
		Food fish = foodRepository.findByItem("Fish");
		if (fish==null) fish = new Food(f18, 100);
		
		Food salad = foodRepository.findByItem("Salad");
		if (salad==null) salad = new Food(f19, 100);
		
		Food pear = foodRepository.findByItem("Pear");
		if (pear==null) pear = new Food(f20, 100);
		
		
		//Drink
		
		Drink cocaCola = drinkRepository.findByItem("Coca Cola");
		if (cocaCola==null) cocaCola = new Drink(d1, 100);
		
		Drink pepsiCola = drinkRepository.findByItem("Pepsi Cola");
		if (pepsiCola==null) pepsiCola = new Drink(d2, 100);
		
		Drink iceTea = drinkRepository.findByItem("Ice Tea");
		if (iceTea==null) iceTea = new Drink(d3, 100);
		
		Drink sprite = drinkRepository.findByItem("Sprite");
		if (sprite==null) sprite = new Drink(d4, 100);
		
		Drink almdudler = drinkRepository.findByItem("Almdudler");
		if (almdudler==null) almdudler = new Drink(d5, 100);
		
		Drink orangeJ = drinkRepository.findByItem("Orange Juice");
		if (orangeJ==null) orangeJ = new Drink(d6, 100);
		
		Drink appleJ = drinkRepository.findByItem("Apple Juice");
		if (appleJ==null) appleJ = new Drink(d7, 100);
		
		Drink redWine = drinkRepository.findByItem("Red Wine");
		if (redWine==null) redWine = new Drink(d8, 100);
		
		Drink whiteWine = drinkRepository.findByItem("White Wine");
		if (whiteWine==null) whiteWine = new Drink(d9, 100);
		
		Drink beer = drinkRepository.findByItem("Beer");
		if (beer==null) beer = new Drink(d10, 100);
		
		Drink cranberryJ = drinkRepository.findByItem("Cranberry Juice");
		if (cranberryJ==null) cranberryJ = new Drink(d11, 100);
		
		Drink tomatoJ = drinkRepository.findByItem("Tomato Juice");
		if (tomatoJ==null) tomatoJ = new Drink(d12, 100);
		
		Drink carrotsJ = drinkRepository.findByItem("Carrots Juice");
		if (carrotsJ==null) carrotsJ = new Drink(d13, 100);
		
		Drink gin = drinkRepository.findByItem("Gin");
		if (gin==null) gin = new Drink(d14, 100);
		
		Drink kakao = drinkRepository.findByItem("Hot Chocolate");
		if (kakao==null) kakao = new Drink(d15, 100);
		
		Drink emotion = drinkRepository.findByItem("Emotion");
		if (emotion==null) emotion = new Drink(d16, 100);
		
		Drink martini = drinkRepository.findByItem("Martini Bianco");
		if (martini==null) martini = new Drink(d17, 100);
		
		Drink radler = drinkRepository.findByItem("Radler");
		if (radler==null) radler = new Drink(d18, 100);
		
				
		//Sport
		
		Sport running = sportRepository.findByItem("Running");
		if (running==null) running = new Sport(s1, 30);
		
		Sport volley = sportRepository.findByItem("Volleyball");
		if (volley==null) volley = new Sport(s2, 30);
		
		Sport tennis = sportRepository.findByItem("Tennis");
		if (tennis==null) tennis = new Sport(s3, 30);
		
		Sport swimming = sportRepository.findByItem("Swimming");
		if (swimming==null) swimming = new Sport(s4, 30);
		
		Sport walking = sportRepository.findByItem("Walking");
		if (walking==null) walking = new Sport(s5, 30);
		
		Sport bike = sportRepository.findByItem("Bycicle Riding");
		if (bike==null) bike = new Sport(s6, 30);
		
		Sport soccer = sportRepository.findByItem("Soccer");
		if (soccer==null) soccer = new Sport(s7, 30);
		
		Sport icehockey = sportRepository.findByItem("Icehockey");
		if (icehockey==null) icehockey = new Sport(s8, 30);
		
		Sport climbing = sportRepository.findByItem("Climbing");
		if (climbing==null) climbing = new Sport(s9, 30);
		
		Sport basket = sportRepository.findByItem("Basketball");
		if (basket==null) basket = new Sport(s10, 30);
		
		return "forward:list";
	
	}
	
}
