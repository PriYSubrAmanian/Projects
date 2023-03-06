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

import com.example.demo.entity.Invoice;
import com.example.demo.service.InvoiceService;


import java.util.List;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/invoice")
public class InvoiceController 
{
	@Autowired
	InvoiceService service;
	@PostMapping("/addInvoice")
	public ResponseEntity<Invoice> addInvoice(@Valid @RequestBody Invoice e) {

		return new ResponseEntity<Invoice>(service.addInvoice(e), HttpStatus.CREATED);
	}
	@GetMapping("/list")
	public List<Invoice> getAllInvoice() {
		return service.getAllInvoice();
	}

	@GetMapping("find/{InvoiceId}")
	public ResponseEntity<Invoice> getProductById(@PathVariable("Invoiceid") int Invoiceid) {
		return new ResponseEntity<Invoice>(service.getInvoiceById(Invoiceid), HttpStatus.OK);
	}
	@PutMapping("updateInvoice")
	public ResponseEntity<Invoice> updateInvoice(@Valid  @RequestBody Invoice e) {
		return new ResponseEntity<Invoice>(service.updateInvoice(e),HttpStatus.OK);
	}

	@DeleteMapping("delete/{Invoiceid}")
	public ResponseEntity<Boolean> deleteInvoice(@PathVariable("Invoiceid") int Invoiceid) {
		service.deleteInvoice(Invoiceid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}