package com.maria.desafioFrete;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maria.desafioFrete.entities.Order;
import com.maria.desafioFrete.services.OrderService;
import com.maria.desafioFrete.services.ShippingService;

@SpringBootApplication
public class DesafioFreteApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ShippingService shippingService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioFreteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i < 4; i++) {
			Integer code = sc.nextInt();
			Double basicValue = sc.nextDouble();
			Double discount = sc.nextDouble();

			Order order = new Order(code, basicValue, discount);

			System.out.println("Pedido código " + code);
			System.out.printf("Valor total : R$ %.2f", (orderService.total(order) + shippingService.shipment(order)));
			System.out.println();
			
		}

		sc.close();

	}

}
