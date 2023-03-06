package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Category;
@Repository
@RepositoryRestResource(path="category")
@CrossOrigin(origins = "http://localhost:4200")
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
