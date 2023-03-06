package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CategoryRepository;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
    CategoryRepository dao;
	public Category addCategory(Category e) {
		System.out.println("Category added Succesfully "+e);
		e.setCategoryName(e.getCategoryName());
		e.setCreatedDateTime(e.getCreatedDateTime());
		e.setCreatedUser(e.getCreatedUser());
		e.setLastModifiedUser(e.getLastModifiedUser());
		return dao.save(e);
	}
@Override
public List<Category> getAllCategory() {
	// TODO Auto-generated method stub
	return dao.findAll();
}

@Override
public Category updateCategory(Category e) {
	Category existingCategory=dao.findById(e.getCategoryId()).orElse(null);
	
	
		existingCategory.setCategoryName(e.getCategoryName());
		existingCategory.setCreatedDateTime(e.getCreatedDateTime());
		existingCategory.setCreatedUser(e.getCreatedUser());
		existingCategory.setLastModifiedUser(e.getLastModifiedUser());
		
		return dao.save(existingCategory);
		
	

}

public String deleteCategory(int id) {
	Category existsID=dao.findById(id).orElse(null);
	if(existsID!=null)
	{
	dao.deleteById(id);
	return "Category deleted!!";
	}
	else
	{
	return "Category does not exist!!";
	}

}
@Override
public Category getCategoryById(int id) {
	// TODO Auto-generated method stub
	return this.dao.findById(id).orElse(null);
}
}


