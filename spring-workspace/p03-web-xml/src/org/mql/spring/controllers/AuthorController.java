package org.mql.spring.controllers;

import java.util.List;

import org.mql.spring.business.BiblioService;
import org.mql.spring.models.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *  equivalent au class d'action dans JEE natif
 * */

@Controller
public class AuthorController {
	
	private BiblioService service;
	
	public AuthorController(BiblioService service) {
		this.service = service;
	}
	
	@GetMapping("authors-list")
	public String AuthorsList(Model model)
	{
		List<Author> authors = service.getAllAuthors();
		model.addAttribute("authors", authors);
		return "/views/authors-list.jsp";
	}
}
