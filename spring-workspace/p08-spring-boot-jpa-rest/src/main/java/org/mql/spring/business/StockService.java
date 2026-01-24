package org.mql.spring.business;

import java.util.List;
import java.util.Optional;

import org.mql.spring.models.Product;

public interface StockService {
	public List<Product> getAllProducts();
	public Optional<Product> getProductById(int id);
	public boolean addProduct(Product product);
	public boolean deleteProduct(int id);
}
