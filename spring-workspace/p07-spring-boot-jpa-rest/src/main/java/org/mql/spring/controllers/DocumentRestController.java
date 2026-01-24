package org.mql.spring.controllers;

import java.util.List;

import org.mql.spring.business.BiblioService;
import org.mql.spring.models.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documents")
public class DocumentRestController {
	@Autowired
	private BiblioService service;
	
	public DocumentRestController() {
		// TODO Auto-generated constructor stub
	}
	@GetMapping
	public List<Document> documents(){
		return service.getAllDocuments();
		
	}

	@GetMapping(params = {"min", "max"})
	List<Document> documents(@RequestParam int min, @RequestParam int max)
	{
		return service.getDocumentsByYearInterval(min, max);
	}
	
}
