package at.fh.swenga.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.password.PasswordEncoder;

import at.fh.swenga.model.Art;
import at.fh.swenga.model.Drink;
import at.fh.swenga.model.Food;
import at.fh.swenga.model.Item;
import at.fh.swenga.model.Role;
import at.fh.swenga.model.Sport;
import at.fh.swenga.model.StandardKalorienVerbrauch;
import at.fh.swenga.model.User;
import at.fh.swenga.repositories.ArtRepository;
import at.fh.swenga.repositories.DrinkRepository;
import at.fh.swenga.repositories.FoodRepository;
import at.fh.swenga.repositories.ItemRepository;
import at.fh.swenga.repositories.ProfileImageRepository;
import at.fh.swenga.repositories.RoleRepository;
import at.fh.swenga.repositories.SportRepository;
import at.fh.swenga.repositories.StandardKalorienVerbrauchRepository;
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
	
	@Autowired
	StandardKalorienVerbrauchRepository standardKalorienVerbrauchRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@RequestMapping(value = "/fillDatabase", method = RequestMethod.GET)
	@Transactional
	public String fillItemList(Model model) {
		
		//Roles
		
		Role radmin =roleRepository.findByBezeichnung("ROLE_ADMIN");
		if(radmin==null)
		{
			radmin = new Role("ROLE_ADMIN");
			roleRepository.save(radmin);
		}
		
		Role ruser =roleRepository.findByBezeichnung("ROLE_USER");
		if(ruser==null)
		{
			ruser = new Role("ROLE_USER");
			roleRepository.save(ruser);
		}
		
		Role rguest =roleRepository.findByBezeichnung("ROLE_GUEST");
		if(rguest==null)
		{
			rguest = new Role("ROLE_GUEST");
			roleRepository.save(rguest);
		}
				
		
		//User
		
		Date now = new Date();
		User admin = userRepository.findByName("admin");
		if(admin == null)
		{
			admin = new User("admin", "", "", passwordEncoder.encode("password"), true, now);
			admin.setRole(roleRepository.findByBezeichnung("ROLE_ADMIN"));
			userRepository.save(admin);
		}
		User guest = userRepository.findByName("guest");
		if(guest == null)
		{
			guest = new User("guest", "", "", passwordEncoder.encode("password"), true, now);
			guest.setRole(roleRepository.findByBezeichnung("ROLE_GUEST"));
			userRepository.save(guest);}
		
		User user = userRepository.findByName("user");
		if(user == null)
		{
			user = new User("user", "User", "A", passwordEncoder.encode("password"), true, now);
			user.setRole(roleRepository.findByBezeichnung("ROLE_USER"));
			userRepository.save(user);}
			
			
		
		//SKV
		StandardKalorienVerbrauch skv1 = standardKalorienVerbrauchRepository.findBySkvID(1);
		if (skv1==null) skv1 = new StandardKalorienVerbrauch('m', 2500, 0, 19);
		standardKalorienVerbrauchRepository.save(skv1);
		
		StandardKalorienVerbrauch skv2 = standardKalorienVerbrauchRepository.findBySkvID(2);
		if (skv2==null) skv2 = new StandardKalorienVerbrauch('m', 2500, 20, 25);
		standardKalorienVerbrauchRepository.save(skv2);
		
		StandardKalorienVerbrauch skv3 = standardKalorienVerbrauchRepository.findBySkvID(3);
		if (skv3==null) skv3 = new StandardKalorienVerbrauch('m', 2400, 26, 51);
		standardKalorienVerbrauchRepository.save(skv3);
		
		StandardKalorienVerbrauch skv4 = standardKalorienVerbrauchRepository.findBySkvID(4);
		if (skv4==null) skv4 = new StandardKalorienVerbrauch('m', 2200, 52, 65);
		standardKalorienVerbrauchRepository.save(skv4);
		
		StandardKalorienVerbrauch skv5 = standardKalorienVerbrauchRepository.findBySkvID(5);
		if (skv5==null) skv5 = new StandardKalorienVerbrauch('m', 2000, 66, 120);
		standardKalorienVerbrauchRepository.save(skv5);
		
		StandardKalorienVerbrauch skv6 = standardKalorienVerbrauchRepository.findBySkvID(6);
		if (skv6==null) skv6 = new StandardKalorienVerbrauch('f', 2000, 0, 19);
		standardKalorienVerbrauchRepository.save(skv6);
		
		StandardKalorienVerbrauch skv7 = standardKalorienVerbrauchRepository.findBySkvID(7);
		if (skv7==null) skv7 = new StandardKalorienVerbrauch('f', 1900, 20, 25);
		standardKalorienVerbrauchRepository.save(skv7);
		
		StandardKalorienVerbrauch skv8 = standardKalorienVerbrauchRepository.findBySkvID(8);
		if (skv8==null) skv8 = new StandardKalorienVerbrauch('f', 1900, 26, 51);
		standardKalorienVerbrauchRepository.save(skv8);
		
		StandardKalorienVerbrauch skv9 = standardKalorienVerbrauchRepository.findBySkvID(9);
		if (skv9==null) skv9 = new StandardKalorienVerbrauch('f', 1800, 52, 65);
		standardKalorienVerbrauchRepository.save(skv9);
		
		StandardKalorienVerbrauch skv10 = standardKalorienVerbrauchRepository.findBySkvID(10);
		if (skv10==null) skv10 = new StandardKalorienVerbrauch('f', 1600, 66, 120);
		standardKalorienVerbrauchRepository.save(skv10);
		
		
		
		
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
		
		
		Item f1 = itemRepository.findFirstByBezeichnung("Apple");
		if (f1==null) f1 = new Item ("Apple", 52, true);
		f1.setArt(food);
				
		//itemRepository.save(f1);
		
		Item f2 = itemRepository.findFirstByBezeichnung("Beef");
		if (f2==null) f2 = new Item ("Beef", 250, true);
		f2.setArt(food);
		
		//itemRepository.save(f2);
		
		Item f3 = itemRepository.findFirstByBezeichnung("Pork");
		if (f3==null) f3 = new Item ("Pork", 242, true);
		f3.setArt(food);
		
		//itemRepository.save(f3);
		
		Item f4 = itemRepository.findFirstByBezeichnung("Lamb");
		if (f4==null) f4 = new Item ("Lamb", 294, true);
		f4.setArt(food);
		
		//itemRepository.save(f4);
		
		Item f5 = itemRepository.findFirstByBezeichnung("Chicken");
		if (f5==null) f5 = new Item ("Chicken", 239, true);
		f5.setArt(food);
		
		//itemRepository.save(f5);
		
		Item f6 = itemRepository.findFirstByBezeichnung("Pasta");
		if (f6==null) f6 =  new Item ("Pasta", 131, true);
		f6.setArt(food);
		
		//itemRepository.save(f6);
		
		Item f7 = itemRepository.findFirstByBezeichnung("Rice");
		if (f7==null) f7 =  new Item ("Rice", 130, true);
		f7.setArt(food);
		
		//itemRepository.save(f7);
		
		Item f8 = itemRepository.findFirstByBezeichnung("Potatoes");
		if (f8==null) f8 = new Item ("Potatoes", 77, true);
		f8.setArt(food);
		
		//itemRepository.save(f8);
		
		Item f9 = itemRepository.findFirstByBezeichnung("White Bread");
		if (f9==null) f9 =  new Item ("White Bread", 265, true);
		f9.setArt(food);
		
		//itemRepository.save(f9);
		
		Item f10 = itemRepository.findFirstByBezeichnung("Dark Bread");
		if (f10==null) f10 =  new Item ("Dark Bread", 259, true);
		f10.setArt(food);
		
		//itemRepository.save(f10);
		
		Item f11 = itemRepository.findFirstByBezeichnung("Egg");
		if (f11==null) f11 =  new Item ("Egg", 155, true);
		f11.setArt(food);
		
		//itemRepository.save(f11);
		
		Item f12 = itemRepository.findFirstByBezeichnung("Ham");
		if (f12==null) f12 = new Item ("Ham", 110, true);
		f12.setArt(food);
		
		//itemRepository.save(f12);
		
		Item f13 = itemRepository.findFirstByBezeichnung("French Fries");
		if (f13==null) f13 =  new Item ("French Fries", 312, true);
		f13.setArt(food);
		
		//itemRepository.save(f13);
		
		Item f14 = itemRepository.findFirstByBezeichnung("Double Hamburger");
		if (f14==null) f14 =  new Item ("Double Hamburger", 295, true);
		f14.setArt(food);
		
		//itemRepository.save(f14);
		
		Item f15 = itemRepository.findFirstByBezeichnung("Pizza Margherita");
		if (f15==null) f15 = new Item ("Pizza Margherita", 204, true);
		f15.setArt(food);
		
		//itemRepository.save(f15);
		
		Item f16 = itemRepository.findFirstByBezeichnung("Tomato");
		if (f16==null) f16 =  new Item ("Tomato", 18, true);
		f16.setArt(food);
		
		//itemRepository.save(f16);
		
		Item f17 = itemRepository.findFirstByBezeichnung("Cheese");
		if (f17==null) f17 =  new Item ("Cheese", 402, true);
		f17.setArt(food);
		
		//itemRepository.save(f17);
		
		Item f18 = itemRepository.findFirstByBezeichnung("Fish");
		if (f18==null) f18 =  new Item ("Fish", 206, true);
		f18.setArt(food);
		
		//itemRepository.save(f18);
		
		Item f19 = itemRepository.findFirstByBezeichnung("Salad");
		if (f19==null) f19 =  new Item ("Salad", 152, true);
		f19.setArt(food);
		
		//itemRepository.save(f19);
		
		Item f20 = itemRepository.findFirstByBezeichnung("Pear");
		if (f20==null) f20 =  new Item ("Pear", 57, true);
		f20.setArt(food);
		
		//itemRepository.save(f20);
		
		
		
		//--------------------------------------------------
		
		Item d1 = itemRepository.findFirstByBezeichnung("Coca Cola");
		if (d1==null) d1 = new Item ("Coca Cola", 37, true);
		d1.setArt(drink);
		
		//itemRepository.save(d1);
		
		Item d2 = itemRepository.findFirstByBezeichnung("Pepsi Cola");
		if (d2==null) d2 = new Item ("Pepsi Cola", 41, true);
		d2.setArt(drink);
		
		//itemRepository.save(d2);
		
		Item d3 = itemRepository.findFirstByBezeichnung("Ice Tea");
		if (d3==null) d3 = new Item ("Ice Tea", 35, true);
		d3.setArt(drink);
		
		//itemRepository.save(d3);
		
		Item d4 = itemRepository.findFirstByBezeichnung("Sprite");
		if (d4==null) d4 = new Item ("Sprite", 39, true);
		d4.setArt(drink);
		
		//itemRepository.save(d4);
		
		Item d5 = itemRepository.findFirstByBezeichnung("Almdudler");
		if (d5==null) d5 = new Item ("Almdudler", 33, true);
		d5.setArt(drink);
		
		//itemRepository.save(d5);
		
		Item d6 = itemRepository.findFirstByBezeichnung("Orange Juice");
		if (d6==null) d6 = new Item ("Orange Juice", 29, true);
		d6.setArt(drink);
		
		//itemRepository.save(d6);
		
		Item d7 = itemRepository.findFirstByBezeichnung("Apple Juice");
		if (d7==null) d7 = new Item ("Apple Juice", 46, true);
		d7.setArt(drink);
		
		//itemRepository.save(d7);
		
		Item d8 = itemRepository.findFirstByBezeichnung("Red Wine");
		if (d8==null) d8 = new Item ("Red Wine", 85, true);
		d8.setArt(drink);
		
		//itemRepository.save(d8);
		
		Item d9 = itemRepository.findFirstByBezeichnung("White Wine");
		if (d9==null) d9 = new Item ("White Wine", 82, true);
		d9.setArt(drink);
		
		//itemRepository.save(d9);
		
		Item d10 = itemRepository.findFirstByBezeichnung("Beer");
		if (d10==null) d10 = new Item ("Beer", 43, true);
		d10.setArt(drink);
		
		//itemRepository.save(d10);
		
		Item d11 = itemRepository.findFirstByBezeichnung("Cranberry Juice");
		if (d11==null) d11 = new Item ("Cranberry Juice", 46, true);
		d11.setArt(drink);
		
		//itemRepository.save(d11);
		
		Item d12 = itemRepository.findFirstByBezeichnung("Tomato Juice");
		if (d12==null) d12 = new Item ("Tomato Juice", 17, true);
		d12.setArt(drink);
		
		//itemRepository.save(d12);
		
		Item d13 = itemRepository.findFirstByBezeichnung("Carrots Juice");
		if (d13==null) d13 = new Item ("Carrots Juice", 39, true);
		d13.setArt(drink);
		
		//itemRepository.save(d13);
		
		Item d14 = itemRepository.findFirstByBezeichnung("Gin");
		if (d14==null) d14 = new Item ("Gin", 263, true);
		d14.setArt(drink);
		
		//itemRepository.save(d14);
		
		Item d15 = itemRepository.findFirstByBezeichnung("Hot Chocolate");
		if (d15==null) d15 = new Item ("Hot Chocolate", 77, true);
		d15.setArt(drink);
		
		//itemRepository.save(d15);
		
		Item d16 = itemRepository.findFirstByBezeichnung("Emotion");
		if (d16==null) d16 = new Item ("Emotion", 15, true);
		d16.setArt(drink);
		
		//itemRepository.save(d16);
		
		Item d17 = itemRepository.findFirstByBezeichnung("Martini Bianco");
		if (d17==null) d17 = new Item ("Martini Bianco", 145, true);
		d17.setArt(drink);
		
		//itemRepository.save(d17);
		
		Item d18 = itemRepository.findFirstByBezeichnung("Radler");
		if (d18==null) d18 = new Item ("Radler", 42, true);
		d18.setArt(drink);
		
		//itemRepository.save(d18);
		
				
		//------------------------------------------------
		
		Item s1 = itemRepository.findFirstByBezeichnung("Running");
		if (s1==null) s1 = new Item ("Running", 300, true);
		s1.setArt(sport);
		
		//itemRepository.save(s1);
		
		Item s2 = itemRepository.findFirstByBezeichnung("Volleyball");
		if (s2==null) s2 = new Item ("Volleyball", 156, true);
		s2.setArt(sport);
		
		//itemRepository.save(s2);
		
		Item s3 = itemRepository.findFirstByBezeichnung("Tennis");
		if (s3==null) s3 = new Item ("Tennis", 288, true);
		s3.setArt(sport);
		
		//itemRepository.save(s3);
		
		Item s4 = itemRepository.findFirstByBezeichnung("Swimming");
		if (s4==null) s4 = new Item ("Swimming", 367, true);
		s4.setArt(sport);
		
		//itemRepository.save(s4);
		
		Item s5 = itemRepository.findFirstByBezeichnung("Walking");
		if (s5==null) s5 = new Item ("Walking", 80, true);
		s5.setArt(sport);
		
		//itemRepository.save(s5);
		
		Item s6 = itemRepository.findFirstByBezeichnung("Bycicle Riding");
		if (s6==null) s6 = new Item ("Bycicle Riding", 315, true);
		s6.setArt(sport);
		
		//itemRepository.save(s6);
		
		Item s7 = itemRepository.findFirstByBezeichnung("Soccer");
		if (s7==null) s7 = new Item ("Soccer", 273, true);
		s7.setArt(sport);
		
		//itemRepository.save(s7);
		
		Item s8 = itemRepository.findFirstByBezeichnung("Icehockey");
		if (s8==null) s8 = new Item ("Icehockey", 325, true);
		s8.setArt(sport);
		
		//itemRepository.save(s8);
		
		Item s9 = itemRepository.findFirstByBezeichnung("Climbing");
		if (s9==null) s9 = new Item ("Climbing", 400, true);
		s9.setArt(sport);
		
		//itemRepository.save(s9);
		
		Item s10 = itemRepository.findFirstByBezeichnung("Basketball");
		if (s10==null) s10 = new Item ("Basketball", 300, true);
		s10.setArt(sport);
		
		//itemRepository.save(s10);
		
		
		//Food
		
		
		Food apple = foodRepository.findFirstByItemBezeichnung("Apple");
		if (apple==null) apple = new Food (100);
		apple.setItem(f1);
		
		foodRepository.save(apple);
		
		Food beef = foodRepository.findFirstByItemBezeichnung("Beef");
		if (beef==null) beef = new Food (100);
		beef.setItem(f2);
		
		foodRepository.save(beef);
		
		Food pork = foodRepository.findFirstByItemBezeichnung("Pork");
		if (pork==null) pork = new Food (100);
		pork.setItem(f3);
		
		foodRepository.save(pork);
		
		Food lamb = foodRepository.findFirstByItemBezeichnung("Lamb");
		if (lamb==null) lamb = new Food (100);
		lamb.setItem(f4);
		
		foodRepository.save(lamb);
		
		Food chicken = foodRepository.findFirstByItemBezeichnung("Chicken");
		if (chicken==null) chicken = new Food (100);
		chicken.setItem(f5);
		
		foodRepository.save(chicken);
		
		Food pasta = foodRepository.findFirstByItemBezeichnung("Pasta");
		if (pasta==null) pasta = new Food (100);
		pasta.setItem(f6);
		
		foodRepository.save(pasta);
		
		Food rice = foodRepository.findFirstByItemBezeichnung("Rice");
		if (rice==null) rice = new Food (100);
		rice.setItem(f7);
		
		foodRepository.save(rice);
		
		Food potatoes = foodRepository.findFirstByItemBezeichnung("Potatoes");
		if (potatoes==null) potatoes = new Food (100);
		potatoes.setItem(f8);
		
		foodRepository.save(potatoes);
		
		Food whiteBread = foodRepository.findFirstByItemBezeichnung("White Bread");
		if (whiteBread==null) whiteBread = new Food (100);
		whiteBread.setItem(f9);
		
		foodRepository.save(whiteBread);
		
		Food darkBread = foodRepository.findFirstByItemBezeichnung("Dark Bread");
		if (darkBread==null) darkBread = new Food (100);
		darkBread.setItem(f10);
		
		foodRepository.save(darkBread);
		
		Food egg = foodRepository.findFirstByItemBezeichnung("Egg");
		if (egg==null) egg = new Food (100);
		egg.setItem(f11);
		
		foodRepository.save(egg);
		
		Food ham = foodRepository.findFirstByItemBezeichnung("Ham");
		if (ham==null) ham = new Food (100);
		ham.setItem(f12);
		
		foodRepository.save(ham);
		
		Food fries = foodRepository.findFirstByItemBezeichnung("French Fries");
		if (fries==null) fries = new Food (100);
		fries.setItem(f13);
		
		foodRepository.save(fries);
		
		Food hamburger = foodRepository.findFirstByItemBezeichnung("Double Hamburger");
		if (hamburger==null) hamburger = new Food (100);
		hamburger.setItem(f14);
		
		foodRepository.save(hamburger);
		
		Food pizza = foodRepository.findFirstByItemBezeichnung("Pizza Margherita");
		if (pizza==null) pizza = new Food (100);
		pizza.setItem(f15);
		
		foodRepository.save(pizza);
		
		Food tomato = foodRepository.findFirstByItemBezeichnung("Tomato");
		if (tomato==null) tomato = new Food (100);
		tomato.setItem(f16);
	
		foodRepository.save(tomato);
		
		Food cheese = foodRepository.findFirstByItemBezeichnung("Cheese");
		if (cheese==null) cheese = new Food (100);
		cheese.setItem(f17);
		
		foodRepository.save(cheese);
		
		Food fish = foodRepository.findFirstByItemBezeichnung("Fish");
		if (fish==null) fish = new Food (100);
		fish.setItem(f18);
		
		foodRepository.save(fish);
		
		Food salad = foodRepository.findFirstByItemBezeichnung("Salad");
		if (salad==null) salad = new Food (100);
		salad.setItem(f19);
		
		foodRepository.save(salad);
		
		Food pear = foodRepository.findFirstByItemBezeichnung("pear");
		if (pear==null) pear = new Food (100);
		pear.setItem(f20);
		
		foodRepository.save(pear);
		
		
		//Drink
		
		Drink cocaCola = drinkRepository.findByItemBezeichnung("Coca Cola");
		if (cocaCola==null) cocaCola = new Drink (100);
		cocaCola.setItem(d1);
		
		drinkRepository.save(cocaCola);
		
		Drink pepsiCola = drinkRepository.findByItemBezeichnung("Pepsi Cola");
		if (pepsiCola==null) pepsiCola = new Drink (100);
		pepsiCola.setItem(d2);
		
		drinkRepository.save(pepsiCola);
		
		Drink iceTea = drinkRepository.findByItemBezeichnung("Ice Tea");
		if (iceTea==null) iceTea = new Drink (100);
		iceTea.setItem(d3);
		
		drinkRepository.save(iceTea);
		
		Drink sprite = drinkRepository.findByItemBezeichnung("Sprite");
		if (sprite==null) sprite = new Drink (100);
		sprite.setItem(d4);
		
		drinkRepository.save(sprite);
		
		Drink almdudler = drinkRepository.findByItemBezeichnung("Almdudler");
		if (almdudler==null) almdudler = new Drink (100);
		almdudler.setItem(d5);
		
		drinkRepository.save(almdudler);
		
		Drink orangeJ = drinkRepository.findByItemBezeichnung("Orange Juice");
		if (orangeJ==null) orangeJ = new Drink (100);
		orangeJ.setItem(d6);
		
		drinkRepository.save(orangeJ);
		
		Drink appleJ = drinkRepository.findByItemBezeichnung("Apple Juice");
		if (appleJ==null) appleJ = new Drink (100);
		appleJ.setItem(d7);
		
		drinkRepository.save(appleJ);
		
		Drink redWine = drinkRepository.findByItemBezeichnung("Red Wine");
		if (redWine==null) redWine = new Drink (100);
		redWine.setItem(d8);
		
		drinkRepository.save(redWine);
		
		Drink whiteWine = drinkRepository.findByItemBezeichnung("White Wine");
		if (whiteWine==null) whiteWine = new Drink (100);
		whiteWine.setItem(d9);
		
		drinkRepository.save(whiteWine);
		
		Drink beer = drinkRepository.findByItemBezeichnung("Beer");
		if (beer==null) beer = new Drink (100);
		beer.setItem(d10);
		
		drinkRepository.save(beer);
		
		Drink cranberryJ = drinkRepository.findByItemBezeichnung("Cranberry Juice");
		if (cranberryJ==null) cranberryJ = new Drink (100);
		cranberryJ.setItem(d11);
		
		drinkRepository.save(cranberryJ);
		
		Drink tomatoJ = drinkRepository.findByItemBezeichnung("Tomato Juice");
		if (tomatoJ==null) tomatoJ = new Drink (100);
		tomatoJ.setItem(d12);
		
		drinkRepository.save(tomatoJ);
		
		Drink carrotsJ = drinkRepository.findByItemBezeichnung("Carrots Juice");
		if (carrotsJ==null) carrotsJ = new Drink (100);
		carrotsJ.setItem(d13);
		
		drinkRepository.save(carrotsJ);
		
		Drink gin = drinkRepository.findByItemBezeichnung("Gin");
		if (gin==null) gin = new Drink (100);
		gin.setItem(d14);
		
		drinkRepository.save(gin);
		
		Drink kakao = drinkRepository.findByItemBezeichnung("Hot Chocolate");
		if (kakao==null) kakao = new Drink (100);
		kakao.setItem(d15);
		
		drinkRepository.save(kakao);
		
		Drink emotion = drinkRepository.findByItemBezeichnung("Emotion");
		if (emotion==null) emotion = new Drink (100);
		emotion.setItem(d16);
		
		drinkRepository.save(emotion);
		
		Drink martini = drinkRepository.findByItemBezeichnung("Martini Bianco");
		if (martini==null) martini = new Drink (100);
		martini.setItem(d17);
		
		drinkRepository.save(martini);
		
		Drink radler = drinkRepository.findByItemBezeichnung("Radler");
		if (radler==null) radler = new Drink (100);
		radler.setItem(d18);
		
		drinkRepository.save(radler);
		
				
		//Sport
		
		Sport running = sportRepository.findByItemBezeichnung("Running");
		if (running==null) running = new Sport (30);
		running.setItem(s1);
		
		sportRepository.save(running);
		
		Sport volley = sportRepository.findByItemBezeichnung("Volleyball");
		if (volley==null) volley = new Sport (30);
		volley.setItem(s2);
		
		sportRepository.save(volley);
		
		Sport tennis = sportRepository.findByItemBezeichnung("Tennis");
		if (tennis==null) tennis = new Sport (30);
		tennis.setItem(s3);
		
		sportRepository.save(tennis);
		
		Sport swimming = sportRepository.findByItemBezeichnung("Swimming");
		if (swimming==null) swimming = new Sport (30);
		swimming.setItem(s4);
		
		sportRepository.save(swimming);
		
		Sport walking = sportRepository.findByItemBezeichnung("Walking");
		if (walking==null) walking = new Sport (30);
		walking.setItem(s5);
		
		sportRepository.save(walking);
		
		Sport bike = sportRepository.findByItemBezeichnung("Bycicle Riding");
		if (bike==null) bike = new Sport (30);
		bike.setItem(s6);
		
		sportRepository.save(bike);
		
		Sport soccer = sportRepository.findByItemBezeichnung("Soccer");
		if (soccer==null) soccer = new Sport (30);
		soccer.setItem(s7);
		
		sportRepository.save(soccer);
		
		Sport iceHockey = sportRepository.findByItemBezeichnung("Icehockey");
		if (iceHockey==null) iceHockey = new Sport (30);
		iceHockey.setItem(s8);
		
		sportRepository.save(iceHockey);
		
		Sport climbing = sportRepository.findByItemBezeichnung("Climbing");
		if (climbing==null) climbing = new Sport (30);
		climbing.setItem(s9);
		
		sportRepository.save(climbing);
		
		Sport basket = sportRepository.findByItemBezeichnung("Basketball");
		if (basket==null) basket = new Sport (30);
		basket.setItem(s10);
		
		sportRepository.save(basket);
		
		return "login";
		
	
		
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
		*/
}


	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";
	}
	
}
