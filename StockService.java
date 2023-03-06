package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.entity.Stock;

public interface StockService {
	public Stock addStock(Stock z);
	public List<Stock> getAllStock();
	
	public Stock getStockById(int id);
	
	public Stock updateStock(Stock x);
	public String deleteStock(int stockId);

}
