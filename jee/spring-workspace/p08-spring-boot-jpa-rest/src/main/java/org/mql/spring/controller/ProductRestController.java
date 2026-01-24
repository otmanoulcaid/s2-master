package org.mql.spring.controller;

import java.util.List;
import java.util.Optional;

import org.mql.spring.business.StockService;
import org.mql.spring.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(
		"*"
)
public class ProductRestController {
	@Autowired
	private StockService service;

	@GetMapping
	public List<Product> products()
	{
		return service.getAllProducts();
	}
	
	@GetMapping("{id}") 
	public ResponseEntity<Product> getById(@PathVariable int id)
	{
		System.out.println(id);
		Optional<Product> result = service.getProductById(id);
		System.out.println(result);
		if (result.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(result.get());
	}
	
	@PostMapping
	public ResponseEntity<Product> add(/*@ModelAttribute le cas de form*/ @RequestBody Product p)
	{
		service.addProduct(p);
		ResponseEntity<Product> response =  ResponseEntity.status(HttpStatus.CREATED).build();
		return response;
	}
	
	@GetMapping("delete/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable int id)
	{
		if (service.deleteProduct(id))
			return ResponseEntity.noContent().build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("update/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product p)
	{
		Optional<Product> existed = service.getProductById(id);
		if (existed.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		service.addProduct(p);
		return ResponseEntity.noContent().build();
	}
}
