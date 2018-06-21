package at.fh.swenga.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import at.fh.swenga.model.Art;
import at.fh.swenga.model.Drink;
import at.fh.swenga.model.Food;
import at.fh.swenga.model.Item;
import at.fh.swenga.model.ProfileImage;
import at.fh.swenga.model.Sport;
import at.fh.swenga.model.User;
import at.fh.swenga.repositories.ArtRepository;
import at.fh.swenga.repositories.DrinkRepository;
import at.fh.swenga.repositories.FoodRepository;
import at.fh.swenga.repositories.ItemRepository;
import at.fh.swenga.repositories.ProfileImageRepository;
import at.fh.swenga.repositories.SportRepository;
import at.fh.swenga.repositories.UserRepository;


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
	
	@Autowired
	ProfileImageRepository profileImageRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@RequestMapping(value = "/fillItemList", method = RequestMethod.GET)
	@Transactional
	public String fillItemList(Model model) {
		//Art
		
		Art food = artRepository.findByBezeichnung("Food");
		if (food==null) food = new Art(1, "Food");
		artRepository.save(food);
		
		Art drink = artRepository.findByBezeichnung("Drink");
		if (drink==null) drink = new Art(2, "Drink");
		artRepository.save(drink);
		
		Art sport = artRepository.findByBezeichnung("Sport");
		if (sport==null) sport = new Art(3, "Sport");
		artRepository.save(sport);
		
		
		//Item
				
		Item f1 = new Item ("Apile", 52, true);
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
		
		Item d7 = new Item ("Apile Juice", 46, true);
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
		
		System.out.println("ID?: " + f1.getItemID());
		
		Food apile = new Food (100);
		apile.setItem(f1);
		
		foodRepository.save(apile);
		
		Food beef = new Food (100);
		beef.setItem(f2);
		
		foodRepository.save(beef);
		
		Food pork = new Food (100);
		pork.setItem(f3);
		
		foodRepository.save(pork);
		
		Food lamb = new Food (100);
		lamb.setItem(f4);
		
		foodRepository.save(lamb);
		
		Food chicken = new Food (100);
		chicken.setItem(f5);
		
		foodRepository.save(chicken);
		
		Food pasta = new Food (100);
		pasta.setItem(f6);
		
		foodRepository.save(pasta);
		
		Food rice = new Food (100);
		rice.setItem(f7);
		
		foodRepository.save(rice);
		
		Food potatoes = new Food (100);
		potatoes.setItem(f8);
		
		foodRepository.save(potatoes);
		
		Food whiteBread = new Food (100);
		whiteBread.setItem(f9);
		
		foodRepository.save(whiteBread);
		
		Food darkBread = new Food (100);
		darkBread.setItem(f10);
		
		foodRepository.save(darkBread);
		
		Food egg = new Food (100);
		egg.setItem(f11);
		
		foodRepository.save(egg);
		
		Food ham = new Food (100);
		ham.setItem(f12);
		
		foodRepository.save(ham);
		
		Food fries = new Food (100);
		fries.setItem(f13);
		
		foodRepository.save(fries);
		
		Food hamburger = new Food (100);
		hamburger.setItem(f14);
		
		foodRepository.save(hamburger);
		
		Food pizza = new Food (100);
		pizza.setItem(f15);
		
		foodRepository.save(pizza);
		
		Food tomato = new Food (100);
		tomato.setItem(f16);
	
		foodRepository.save(tomato);
		
		Food cheese = new Food (100);
		cheese.setItem(f17);
		
		foodRepository.save(cheese);
		
		Food fish = new Food (100);
		fish.setItem(f18);
		
		foodRepository.save(fish);
		
		Food salad = new Food (100);
		salad.setItem(f19);
		
		foodRepository.save(salad);
		
		Food pear = new Food (100);
		pear.setItem(f20);
		
		foodRepository.save(pear);
		
		
		//Drink
		
		Drink cocaCola = new Drink (100);
		cocaCola.setItem(d1);
		
		drinkRepository.save(cocaCola);
		
		Drink pepsiCola = new Drink (100);
		pepsiCola.setItem(d2);
		
		drinkRepository.save(pepsiCola);
		
		Drink iceTea = new Drink (100);
		iceTea.setItem(d3);
		
		drinkRepository.save(iceTea);
		
		Drink sprite = new Drink (100);
		sprite.setItem(d4);
		
		drinkRepository.save(sprite);
		
		Drink almdudler = new Drink (100);
		almdudler.setItem(d5);
		
		drinkRepository.save(almdudler);
		
		Drink orangeJ = new Drink (100);
		orangeJ.setItem(d6);
		
		drinkRepository.save(orangeJ);
		
		Drink apileJ = new Drink (100);
		apileJ.setItem(d7);
		
		drinkRepository.save(apileJ);
		
		Drink redWine = new Drink (100);
		redWine.setItem(d8);
		
		drinkRepository.save(redWine);
		
		Drink whiteWine = new Drink (100);
		whiteWine.setItem(d9);
		
		drinkRepository.save(whiteWine);
		
		Drink beer = new Drink (100);
		beer.setItem(d10);
		
		drinkRepository.save(beer);
		
		Drink cranberryJ = new Drink (100);
		cranberryJ.setItem(d11);
		
		drinkRepository.save(cranberryJ);
		
		Drink tomatoJ = new Drink (100);
		tomatoJ.setItem(d12);
		
		drinkRepository.save(tomatoJ);
		
		Drink carrotsJ = new Drink (100);
		carrotsJ.setItem(d13);
		
		drinkRepository.save(carrotsJ);
		
		Drink gin = new Drink (100);
		gin.setItem(d14);
		
		drinkRepository.save(gin);
		
		Drink kakao = new Drink (100);
		kakao.setItem(d15);
		
		drinkRepository.save(kakao);
		
		Drink emotion = new Drink (100);
		emotion.setItem(d16);
		
		drinkRepository.save(emotion);
		
		Drink martini = new Drink (100);
		martini.setItem(d17);
		
		drinkRepository.save(martini);
		
		Drink radler = new Drink (100);
		radler.setItem(d18);
		
		drinkRepository.save(radler);
		
				
		//Sport
		
		Sport running = new Sport (30);
		running.setItem(s1);
		
		sportRepository.save(running);
		
		Sport volley = new Sport (30);
		volley.setItem(s2);
		
		sportRepository.save(volley);
		
		Sport tennis = new Sport (30);
		tennis.setItem(s3);
		
		sportRepository.save(tennis);
		
		Sport swimming = new Sport (30);
		swimming.setItem(s4);
		
		sportRepository.save(swimming);
		
		Sport walking = new Sport (30);
		walking.setItem(s5);
		
		sportRepository.save(walking);
		
		Sport bike = new Sport (30);
		bike.setItem(s6);
		
		sportRepository.save(bike);
		
		Sport soccer = new Sport (30);
		soccer.setItem(s7);
		
		sportRepository.save(soccer);
		
		Sport icehockey = new Sport (30);
		icehockey.setItem(s8);
		
		sportRepository.save(icehockey);
		
		Sport climbing = new Sport (30);
		climbing.setItem(s9);
		
		sportRepository.save(climbing);
		
		Sport basket = new Sport (30);
		basket.setItem(s10);
		
		sportRepository.save(basket);
		
		return "login";
	
	}
	
	/*
	@RequestMapping(value = "/uploadProfileImage", method = RequestMethod.GET)
	@Transactional
	public String uploadProfileImage(Model model, @RequestParam("name") String name) {
		User user = userRepository.findByName(name);
		if (user != null) {
			model.addAttribute("user", user);
			return "uploadProfileImage";
		} else {
			model.addAttribute("errorMessage",
			"Please login in again and retry to upload your profile Picture. Error while reading User Data!");
			return "login";
		}
	}
	
	
	@RequestMapping(value = "/uploadProfileImage", method = RequestMethod.POST)
	public String uploadProfileImage(Model model, Authentication authentication,
			@RequestParam("name") String name, @RequestParam("imageFile") MultipartFile imageFile) {

		try {

			Optional<User> userOp = userRepository.findFirstByName(name);

			if (!userOp.isPresent()) {
				model.addAttribute("errorMessage", "Error while reading Data!");
				return "settings";
			}

			User user = userOp.get();

			// Load lazy ProfilePicutre and check if there is one already!
			ProfileImage currPic = profileImageRepository.findByCurrentUserName(user.getName());
			// Already a Profile Picture available -> delete it
			if (currPic != null) {
				profileImageRepository.delete(currPic);
				// Don't forget to remove the relationship too
				user.setProfileImage(null);
				userRepository.save(user);
			}
			// Create a new document and set all available infos

			ProfileImage pi = new ProfileImage();
			pi.setName(user.getName() + "-Profile-Image");
			pi.setType(imageFile.getContentType());
			pi.setImg(imageFile.getBytes());

			pi.setCurrentUser(user);
			user.setProfileImage(pi);
			profileImageRepository.save(pi);
			userRepository.save(user);
			model.addAttribute("message", "Profile Image successfully added.");

		} catch (Exception e) {

			model.addAttribute("errorMessage", "Error:" + e.getMessage());
		}

		return "settings";
}
*/

	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";
	}
	
}
