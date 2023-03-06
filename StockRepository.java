package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Stock;
@Repository
@RepositoryRestResource(path="stock")
@CrossOrigin(origins = "http://localhost:4200")
public interface StockRepository extends JpaRepository<Stock,Integer> {

}
