package com.maria.desafioFrete.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maria.desafioFrete.entities.Order;

@Service
public class ShippingService {

	@Autowired
	private OrderService orderService;

	public double shipment(Order order) {
		double value = orderService.total(order);
		if (value < 100) {
			return 20;
		}
		if (value >= 100 && value < 200) {
			return 12;
		} else {
			return 0;
		}
	}

}
