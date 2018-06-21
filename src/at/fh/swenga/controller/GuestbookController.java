package at.fh.swenga.controller;

import java.util.List;

import org.springframework.security.core.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import at.fh.swenga.model.GuestbookModel;
import at.fh.swenga.model.User;
import at.fh.swenga.repositories.GuestbookRepository;
import at.fh.swenga.repositories.UserRepository;

@Controller
public class GuestbookController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping(value = "/guestbook", method = RequestMethod.GET)
	public String guestbook(Model model) {
		String nickName = "";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		nickName = authentication.getName();
		User user = userRepo.findByName(nickName);
		
		List<GuestbookModel> entries = guestbookRepository.findAll();
		model.addAttribute("entries", entries);
		System.out.println("user:"+ user.getVorname());
		model.addAttribute("guestbookUser", user);
		return "guestbook";
	}
	
	@RequestMapping(value = "/guestbook", method = RequestMethod.POST)
    public String addEntry( GuestbookModel guestbookModelForm, BindingResult bindingResult, Model model) 
	{
		
		System.out.println(guestbookModelForm.getHeadline());
        if (bindingResult.hasErrors()) {
            return "guestbook";
        }
        
      guestbookRepository.save(guestbookModelForm);
      
      return guestbook(model);
    }
	
	
}
