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

import com.example.demo.entity.Stock;
import com.example.demo.service.StockService;


import java.util.List;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/stock")
public class StockController 
{
	@Autowired
	StockService service;
	@PostMapping("/addStock")
	public ResponseEntity<Stock> addStock(@Valid @RequestBody Stock e) {

		return new ResponseEntity<Stock>(service.addStock(e), HttpStatus.CREATED);
	}
	@GetMapping("/list")
	public List<Stock> getAllStock() {
		return service.getAllStock();
	}

	@GetMapping("find/{StockId}")
	public ResponseEntity<Stock> getStockById(@PathVariable("Stockid") int Stockid) {
		return new ResponseEntity<Stock>(service.getStockById(Stockid), HttpStatus.OK);
	}
	@PutMapping("updateStock")
	public ResponseEntity<Stock> updateStock(@Valid  @RequestBody Stock e) {
		return new ResponseEntity<Stock>(service.updateStock(e),HttpStatus.OK);
	}

	@DeleteMapping("delete/{Stockid}")
	public ResponseEntity<Boolean> deleteStock(@PathVariable("Stockid") int Stockid) {
		service.deleteStock(Stockid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}