package org.mql.spring.controllers;

import org.mql.spring.business.BiblioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//pour separer les vues
@Controller
@RequestMapping("/biblio")
public class BiblioController {
	@Autowired
	private BiblioService service;
	
	@Autowired
	private String title;
	
	public BiblioController() {
		// TODO Auto-generated constructor stub
	}
	
	//Methodes d'action:
	@GetMapping("authors-list")
	public String authorsList(Model model) {
		 model.addAttribute("authors", service.getAllAuthors());
		 model.addAttribute("title", title);
		 return "authors-list";
		
		
		
	}
	

}
