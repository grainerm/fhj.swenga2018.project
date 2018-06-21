package at.fh.swenga.controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import at.fh.swenga.model.GuestbookModel;
import at.fh.swenga.repositories.GuestbookRepository;

@Controller
public class GuestbookController {
	
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping(value = "/guestbook", method = RequestMethod.GET)
	public String guestbook(Model model) {
		List<GuestbookModel> entries = guestbookRepository.findAll();
		model.addAttribute("entries", entries);
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
