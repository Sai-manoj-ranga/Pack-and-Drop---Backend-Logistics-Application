package com.restAPI.rsm_pack_and_drop.service;

import java.util.List;

import com.restAPI.rsm_pack_and_drop.model.Delivery;

public interface DeliveryService {
    List<Delivery> getDeliveryDetails();

    Delivery getDeliveryInfo(Integer did);

    Delivery createDeliveryInfo(Delivery delivery);

    String deleteDeliveryInfo(Integer did);

    Delivery updateDeliveryInfo(Delivery delivery, Integer did);
}
