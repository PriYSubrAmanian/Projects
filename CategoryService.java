package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Category;

public interface CategoryService {
	public Category addCategory(Category e);
	public List<Category> getAllCategory();
	
	public Category getCategoryById(int id);
	
	public Category updateCategory(Category e);
	public String deleteCategory(int id);


}
