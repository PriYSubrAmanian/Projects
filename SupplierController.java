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

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;



import java.util.List;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/Supplier")
public class SupplierController 
{
	@Autowired
	SupplierService service;
	@PostMapping("/addSupplier")
	public ResponseEntity<Supplier> addSupplier(@Valid @RequestBody Supplier e) {

		return new ResponseEntity<Supplier>(service.addSupplier(e), HttpStatus.CREATED);
	}
	@GetMapping("/list")
	public List<Supplier> getAllSupplier() {
		return service.getAllSupplier();
	}

	@GetMapping("find/{SupplierId}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable("Supplierid") int Supplierid) {
		return new ResponseEntity<Supplier>(service.getSupplierById(Supplierid), HttpStatus.OK);
	}
	@PutMapping("updateSupplier")
	public ResponseEntity<Supplier> updateSupplier(@Valid  @RequestBody Supplier e) {
		return new ResponseEntity<Supplier>(service.updateSupplier(e),HttpStatus.OK);
	}

	@DeleteMapping("delete/{Supplierid}")
	public ResponseEntity<Boolean> deleteSupplier(@PathVariable("Supplierid") int Supplierid) {
		service.deleteSupplier(Supplierid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}