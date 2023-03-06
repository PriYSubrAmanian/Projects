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

import com.example.demo.entity.Pricing;
import com.example.demo.service.PricingService;



import java.util.List;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/Pricing")
public class PricingController 
{
	@Autowired
	PricingService service;
	@PostMapping("/addPricing")
	public ResponseEntity<Pricing> addPricing(@Valid @RequestBody Pricing e) {

		return new ResponseEntity<Pricing>(service.addPricing(e), HttpStatus.CREATED);
	}
	@GetMapping("/list")
	public List<Pricing> getAllPricing() {
		return service.getAllPricing();
	}

	@GetMapping("find/{PricingId}")
	public ResponseEntity<Pricing> getProductById(@PathVariable("Pricingid") int Pricingid) {
		return new ResponseEntity<Pricing>(service.getPricingById(Pricingid), HttpStatus.OK);
	}
	@PutMapping("updatePricing")
	public ResponseEntity<Pricing> updatePricing(@Valid  @RequestBody Pricing e) {
		return new ResponseEntity<Pricing>(service.updatePricing(e),HttpStatus.OK);
	}

	@DeleteMapping("delete/{Pricingid}")
	public ResponseEntity<Boolean> deletePricing(@PathVariable("Pricingid") int Pricingid) {
		service.deletePricing(Pricingid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}