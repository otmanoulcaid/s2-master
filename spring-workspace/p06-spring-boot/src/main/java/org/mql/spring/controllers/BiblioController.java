package org.mql.spring.controllers;

import java.util.List;

import org.mql.spring.business.BiblioService;
import org.mql.spring.models.ApplicationProperties;
import org.mql.spring.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/biblio")
public class BiblioController {


	@Autowired
	private String title;

	@Autowired
	ApplicationProperties props;

	private BiblioService service;

	public BiblioController(BiblioService service) {
			this.service = service;
	}

//	@RequestMapping // GetMapping | PostMapping | ....
	@GetMapping("/authors-list") // on doit avoir le tomcat-embed-jasper comme dependency de notre projet pour le les jsp
	public String AuthorsList(Model model)
	{
		List<Author> authors = service.getAllAuthors();
		model.addAttribute("authors", authors);
		model.addAttribute("title", title);
		return "authors-list";
	}

	@GetMapping("/props")
	public String listProps(Model model)
	{
		model.addAttribute("props", props);
		return "application-properties";
	}
}
