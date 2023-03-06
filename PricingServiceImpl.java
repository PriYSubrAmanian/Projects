package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PricingRepository;
import com.example.demo.entity.Category;
import com.example.demo.entity.Invoice;
import com.example.demo.entity.Pricing;
import com.example.demo.service.PricingService;
@Service
public class PricingServiceImpl implements PricingService {
	@Autowired
    PricingRepository dao;
	@Override
	public Pricing addPricing(Pricing x) {
		// TODO Auto-generated method stub
		System.out.println("Pricing added Succesfully "+x);
		x.setCreated_date_time(x.getCreated_date_time());
		x.setCreated_user(x.getCreated_user());
		x.setLast_modified_date_time(x.getLast_modified_date_time());
		x.setLast_modified_user(x.getLast_modified_user());
		return dao.save(x);
	}

	@Override
	public List<Pricing> getAllPricing() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Pricing getPricingById(int id) {
		// TODO Auto-generated method stub
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public Pricing updatePricing(Pricing x) {
		// TODO Auto-generated method stub
		Pricing existingPricing=dao.findById(x.getPricing_id()).orElse(null);
		
		
		existingPricing.setCreated_date_time(x.getCreated_date_time());
		existingPricing.setCreated_user(x.getCreated_user());
		existingPricing.setLast_modified_date_time(x.getLast_modified_date_time());
		existingPricing.setLast_modified_user(x.getLast_modified_user());
		
		return dao.save(existingPricing);
	}

	@Override
	public String deletePricing(int PricingId) {
		// TODO Auto-generated method stub
		Pricing existsID=dao.findById(PricingId).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(PricingId);
		return "Pricing deleted!!";
		}
		else
		{
		return "Pricing does not exist!!";
		}
	}

	


}
