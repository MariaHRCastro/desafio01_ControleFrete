package com.maria.desafioFrete.services;

import org.springframework.stereotype.Service;

import com.maria.desafioFrete.entities.Order;

@Service
public class OrderService {

	private Order order;
	
	public double total(Order order) {
		double basic = order.getBasic();
		double discount = order.getDiscount();
		return basic - (basic * discount /100);
	}




	
}
