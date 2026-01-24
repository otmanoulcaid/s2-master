package org.mql.spring.controllers;

import java.util.List;

import org.mql.spring.business.BiblioService;
import org.mql.spring.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/biblio/api/authors")
public class AuthorRestController {
	
	@Autowired
	private BiblioService service;

	@GetMapping
	public List<Author> authors()
	{
		/*
		 * jackson qui va convertir l'objet java vers JSON
		 */
		return service.getAllAuthors();
	}
}
