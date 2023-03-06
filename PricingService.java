package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Pricing;

public interface PricingService {
	public Pricing addPricing(Pricing x);
	public List<Pricing> getAllPricing();
	
	public Pricing getPricingById(int id);
	
	public Pricing updatePricing(Pricing x);
	public String deletePricing(int PricingId);

}
