package com.restAPI.rsm_pack_and_drop.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restAPI.rsm_pack_and_drop.model.Order;
import com.restAPI.rsm_pack_and_drop.service.OrderService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/getOrderDetails")
	public List<Order>getOrderDetails(){
		return orderService.getOrderDetails();
	}
	@GetMapping("/getOrderDetails/{order_id}")
	public Order getOrder(@PathVariable Integer order_id) {
		return orderService.getOrder(order_id);
	}
	@PostMapping("/createOrders")
	public Order createOrders(@RequestBody Order order) {
		return orderService.createOrders(order);
	}
	@DeleteMapping("/deleteOrder/{order_id}")
	public String deleteOrder(@PathVariable Integer order_id) {
		return orderService.deleteOrder(order_id);
	}
	@PutMapping("/updateOrder/{order_id}")
	public Order updateOrder(@RequestBody Order order,@PathVariable Integer order_id) {
		return orderService.updateOrder(order, order_id);
	}
}
