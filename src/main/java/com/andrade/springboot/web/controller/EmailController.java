package com.andrade.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.andrade.email.repository.EmailRepository;
import com.andrade.springboot.web.model.Email;

@Controller
public class EmailController {

	@Autowired
	EmailRepository emailRepository;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		return "welcome";
	}

	@RequestMapping("/")
	public String searchEmails(ModelMap model, @RequestParam(value="text") String text) {
		if(text != ""){
			final String uri = "http://localhost:9200/andrade/emails/_search?q=sender:" + text+ "&pretty=true";

			RestTemplate restTemplate = new RestTemplate();

			String result = restTemplate.getForObject(uri, String.class);
			model.put("emails", result);

		}
		return "welcome";
	}

	@GetMapping(value = "/all")
	public List<Email> searchAll(ModelMap model) {
		List<Email> emailList = new ArrayList<>();
		Iterable<Email> emails = emailRepository.findAll();
		emails.forEach(emailList::add);
		model.put("emails", emails);

		return emailList;
	}

}
