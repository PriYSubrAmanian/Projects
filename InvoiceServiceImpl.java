package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Repository.InvoiceRepository;
import com.example.demo.entity.Category;
import com.example.demo.entity.Invoice;
import com.example.demo.service.InvoiceService;
@Service
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
    InvoiceRepository dao;
	
@Override
public Invoice addInvoice(Invoice a) {
	// TODO Auto-generated method stub
	System.out.println("Invoice added Succesfully "+a);

	a.setQuantity(a.getQuantity());
	a.setTotal(a.getTotal());
	return dao.save(a);
	
}

public List<Invoice> getAllInvoice() {
	// TODO Auto-generated method stub
	return dao.findAll();
}

public Invoice updateInvoice(Invoice a) {
	// TODO Auto-generated method stub
	Invoice existingInvoice=dao.findById(a.getInvoiceId()).orElse(null);
	
	
	//existingInvoice.setProductName(a.getProductName());
	existingInvoice.setQuantity(a.getQuantity());
	existingInvoice.setTotal(a.getTotal());
	
	
	return dao.save(existingInvoice);
	
}

public String deleteInvoice(int id) {
	// TODO Auto-generated method stub
	Invoice existsID=dao.findById(id).orElse(null);
	if(existsID!=null)
	{
	dao.deleteById(id);
	return "Invoice deleted!!";
	}
	else
	{
	return "Invoice does not exist!!";
	}
}

@Override
public Invoice getInvoiceById(int id) {
	// TODO Auto-generated method stub
	return this.dao.findById(id).orElse(null);
}





}
