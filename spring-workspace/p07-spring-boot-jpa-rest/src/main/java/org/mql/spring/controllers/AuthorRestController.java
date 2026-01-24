package org.mql.spring.controllers;

import java.util.List;

import org.mql.spring.business.BiblioService;
import org.mql.spring.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {
	@Autowired
	private BiblioService service;
	
	public AuthorRestController() {
		// TODO Auto-generated constructor stub
	}
	
	//End-points
	@GetMapping
	public List<Author> authors(){
		return service.getAllAuthors();
		
	}
	
	
	//ResponseEntity en cas on a entre un id null il va affiche une page vierge donc c'est pour cela on utilise ca c'est comme java.utili.Optionnal
	
	@GetMapping("{id}") //s'appele une variable de chemin 
	public  ResponseEntity<Author> author(@PathVariable int id) {
		Author a=service.getAuthorById(id);
		if (a!=null) {
			/*
			 * Reponse:
			 *  + status =200
			 *  + body =a 
			 */
			return ResponseEntity.ok().body(a);
		}
			/*
			 * Reponse:
			 *  + status =404  
			 */
		return ResponseEntity.notFound().build();
		
	}
	//@RequestParam il vient dans la chaine de request apres "?"
//	@GetMapping(params = {"kw"})  // par exemple en base de donne est nomme kw 
//	public List<Author> authorsByKeyword(@RequestParam("kw") String keyword){
//		return service.getAuthorsByKeyword(keyword);
//	}
	@GetMapping(params = {"keyword"})
	public List<Author> authorsByKeyword(@RequestParam String keyword){
		return service.getAuthorsByKeyword(keyword);
	}
	
	
}
