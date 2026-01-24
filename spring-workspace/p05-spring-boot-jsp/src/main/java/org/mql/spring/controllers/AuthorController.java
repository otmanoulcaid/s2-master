package org.mql.spring.controllers;

import java.util.List;

import org.mql.spring.business.BiblioService;
import org.mql.spring.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *  la class d'action
 * */

@Controller
//@RestController lorsque on veut 
public class AuthorController {
	
	@Autowired
	private String title;
	private BiblioService service;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public AuthorController(BiblioService service) {
		this.service = service;
	}

//	@RequestMapping
	@GetMapping("/authors-list") // on doit avoir le tomcat embed jamper comme dependency de notre projet
	public String AuthorsList(Model model)
	{
		List<Author> authors = service.getAllAuthors();
		model.addAttribute("authors", authors);
		model.addAttribute("title", title);
		return "authors-list";
	}

	//Endpoint
	@GetMapping("/biblio/authors")
	@ResponseBody
	public List<Author> authors()
	{
		//jaclson qui va convertir l'objet java vers JSON
		return service.getAllAuthors();
	}

	@GetMapping("all-beans")
	@ResponseBody
	public Object[] getAllBeans()
	{
		//jaclson qui va convertir l'objet java vers JSON

		String[] beans = applicationContext.getBeanDefinitionNames();
		System.out.println(beans.length);
		return beans;
	}
}
