package at.fh.swenga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import at.fh.swenga.model.GuestbookModel;
import at.fh.swenga.model.JournalModel;
import at.fh.swenga.repositories.JournalRepository;

@Controller
public class JournalController {

	@Autowired
	private JournalRepository journalRepository;
	
	@RequestMapping(value = "/journal", method = RequestMethod.GET)
	public String journal(Model model) {
		List<JournalModel> entries = journalRepository.findAll();
		model.addAttribute("entries", entries);
		return "journal";
	}
	
	@RequestMapping(value = "/journal", method = RequestMethod.POST)
    public String addEntry( JournalModel journalModelForm, BindingResult bindingResult, Model model) 
	{
		
		System.out.println(journalModelForm.getHeadline());
        if (bindingResult.hasErrors()) {
            return "journal";
        }
        
      journalRepository.save(journalModelForm);
      
      return journal(model);
    }
	
	
}
