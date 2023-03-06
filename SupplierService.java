package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Stock;
import com.example.demo.entity.Supplier;

public interface SupplierService {
	public Supplier addSupplier(Supplier t);
	public List<Supplier> getAllSupplier();
	
	public Supplier getSupplierById(int id);
	
	public Supplier updateSupplier(Supplier x);
	public String deleteSupplier(int SupplierId);


}
