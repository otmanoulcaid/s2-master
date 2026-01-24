package org.mql.spring.business;

import java.util.List;
import java.util.Optional;

import org.mql.spring.models.Product;
import org.mql.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceJpa implements StockService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public boolean addProduct(Product product) {
		productRepository.save(product);
		return true;
	}
	
	public boolean deleteProduct(int id)
	{
		productRepository.deleteById(id);
		return true;
	}
}
