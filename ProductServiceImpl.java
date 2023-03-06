package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
    ProductRepository dao;
	@Override
	public Product addProduct(Product y) {
		// TODO Auto-generated method stub
		System.out.println("Product added Succesfully "+y);
		y.setCreatedDateTime(y.getCreatedDateTime());
		y.setCreatedUser(y.getCreatedUser());
		y.setLastModifiedDateTime(y.getLastModifiedDateTime());
		y.setLastModifiedUser(y.getLastModifiedUser());
		y.setProductbuyingPrice(y.getProductbuyingPrice());
		y.setProductName(y.getProductName());
		y.setProductsellingPrice(y.getProductsellingPrice());
		return dao.save(y);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public Product updateProduct(Product y) {
		// TODO Auto-generated method stub
Product existingProduct=dao.findById(y.getProductId()).orElse(null);
		
		
		existingProduct.setCreatedDateTime(y.getCreatedDateTime());
		existingProduct.setCreatedUser(y.getCreatedUser());
		existingProduct.setLastModifiedDateTime(y.getLastModifiedDateTime());
		existingProduct.setLastModifiedUser(y.getLastModifiedUser());
		existingProduct.setProductbuyingPrice(y.getProductbuyingPrice());
		existingProduct.setProductName(y.getProductName());
		existingProduct.setProductsellingPrice(y.getProductsellingPrice());
		return dao.save(existingProduct);
	}

	@Override
	public String deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Product existsID=dao.findById(productId).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(productId);
		return "Product deleted!!";
		}
		else
		{
		return "Product does not exist!!";
		}
	}

	

}
