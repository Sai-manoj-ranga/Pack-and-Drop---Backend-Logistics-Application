package com.restAPI.rsm_pack_and_drop.service;

import java.util.List;

import com.restAPI.rsm_pack_and_drop.model.Order;

public interface OrderService {
    List<Order> getOrderDetails();

    Order getOrder(Integer order_id);

    Order createOrders(Order order);

    String deleteOrder(Integer order_id);

    Order updateOrder(Order order, Integer order_id);

}
