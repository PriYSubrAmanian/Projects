package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;



import java.util.List;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/product")
public class ProductController 
{
	@Autowired
	ProductService service;
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product e) {

		return new ResponseEntity<Product>(service.addProduct(e), HttpStatus.CREATED);
	}
	@GetMapping("/list")
	public List<Product> getAllProduct() {
		return service.getAllProduct();
	}

	@GetMapping("find/{productid}")
	public ResponseEntity<Product> getProductById(@PathVariable("productid") int productid) {
		return new ResponseEntity<Product>(service.getProductById(productid), HttpStatus.OK);
	}
	@PutMapping("updateProduct")
	public ResponseEntity<Product> updateProduct(@Valid  @RequestBody Product e) {
		return new ResponseEntity<Product>(service.updateProduct(e),HttpStatus.OK);
	}

	@DeleteMapping("delete/{productid}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("productid") int productid) {
		service.deleteProduct(productid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}