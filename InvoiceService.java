package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.entity.Invoice;

public interface InvoiceService {
	public Invoice addInvoice(Invoice a);
	public List<Invoice> getAllInvoice();
	
	public Invoice getInvoiceById(int id);
	
	public Invoice updateInvoice(Invoice a);
	public String deleteInvoice(int id);
	



}
