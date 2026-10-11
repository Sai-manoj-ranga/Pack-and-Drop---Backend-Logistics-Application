package com.restAPI.rsm_pack_and_drop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restAPI.rsm_pack_and_drop.model.Order;
import com.restAPI.rsm_pack_and_drop.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {
	  @Autowired
	  OrderRepo orderRepo;

	@Override
	public List<Order> getOrderDetails() {
        return orderRepo.findAll();

	}

	@Override
	public Order getOrder(Integer order_id) {
		return orderRepo.findById(order_id)
                .orElseThrow(() -> new RuntimeException(
                        "Order not found with ID: " + order_id));
	}

	@Override
	public Order createOrders(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public String deleteOrder(Integer order_id) {
		 if (!orderRepo.existsById(order_id)) {
	            throw new RuntimeException(
	                    "Order not found with ID: " + order_id);
	        }

	        orderRepo.deleteById(order_id);

	        return "Order of id number " + order_id
	                + " deleted successfully";
	}

	@Override
	public Order updateOrder(Order order, Integer order_id) {
        Order OFDb = getOrder(order_id);

        OFDb.setOrderNumber(order.getOrderNumber());
        OFDb.setProductName(order.getProductName());
        OFDb.setQuantity(order.getQuantity());
        OFDb.setWeight(order.getWeight());
        OFDb.setPickupAddress(order.getPickupAddress());
        OFDb.setDeliveryAddress(order.getDeliveryAddress());
        OFDb.setOrderDate(order.getOrderDate());
        OFDb.setStatus(order.getStatus());
        return orderRepo.save(OFDb);
	}

}
