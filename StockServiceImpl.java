package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.StockRepository;
import com.example.demo.entity.Product;
import com.example.demo.entity.Stock;
import com.example.demo.service.StockService;
@Service
public class StockServiceImpl implements StockService {
	@Autowired
    StockRepository dao;
	@Override
	public Stock addStock(Stock z) {
		// TODO Auto-generated method stub
		System.out.println("Stock added Succesfully "+z);
		z.setCreated_date_time(z.getCreated_date_time());
		z.setCreated_user(z.getCreated_user());
		z.setLast_modified_date_time(z.getLast_modified_date_time());
		z.setLast_modified_user(z.getLast_modified_user());
		z.setDate_stock(z.getDate_stock());
		z.setQuantity(z.getQuantity());
		z.setCategory(z.getCategory());
		return dao.save(z);
	}

	@Override
	public List<Stock> getAllStock() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Stock getStockById(int id) {
		// TODO Auto-generated method stub
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public Stock updateStock(Stock z) {
		// TODO Auto-generated method stub
Stock existingStock=dao.findById(z.getRef_id()).orElse(null);
		
		
		existingStock.setCreated_date_time(z.getCreated_date_time());
		existingStock.setCreated_user(z.getCreated_user());
		existingStock.setLast_modified_date_time(z.getLast_modified_date_time());
		existingStock.setLast_modified_user(z.getLast_modified_user());
		existingStock.setDate_stock(z.getDate_stock());
		existingStock.setQuantity(z.getQuantity());
		existingStock.setCategory(z.getCategory());
		return dao.save(existingStock);
	}

	@Override
	public String deleteStock(int stockId) {
		// TODO Auto-generated method stub
		Stock existsID=dao.findById(stockId).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(stockId);
		return "Stock deleted!!";
		}
		else
		{
		return "Stock does not exist!!";
		}
	}
	}


