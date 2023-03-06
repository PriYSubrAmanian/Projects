package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Product;

public interface ProductService {
	public Product addProduct(Product x);
	public List<Product> getAllProduct();
	
	public Product getProductById(int id);
	
	public Product updateProduct(Product x);
	public String deleteProduct(int productId);

}
