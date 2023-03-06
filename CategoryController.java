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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;


import java.util.List;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/category")

public class CategoryController 
{
	@Autowired
	CategoryService service;
	@PostMapping("/addcategory")
	public ResponseEntity<Category> addCategory(@Valid @RequestBody Category e) {

		return new ResponseEntity<Category>(service.addCategory(e), HttpStatus.CREATED);
	}
	@GetMapping("/list")
	public List<Category> getAllCategory() {
		return service.getAllCategory();
	}

	@GetMapping("find/{category_id}")
	public ResponseEntity<Category> getProductById(@PathVariable("category_id") int category_id) {
		return new ResponseEntity<Category>(service.getCategoryById(category_id), HttpStatus.OK);
	}
	@PutMapping("update")
	public ResponseEntity<Category> updateCategory(@Valid  @RequestBody Category e) {
		return new ResponseEntity<Category>(service.updateCategory(e),HttpStatus.OK);
	}

	@DeleteMapping("delete/{category_id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("category_id") int category_id) {
		service.deleteCategory(category_id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}