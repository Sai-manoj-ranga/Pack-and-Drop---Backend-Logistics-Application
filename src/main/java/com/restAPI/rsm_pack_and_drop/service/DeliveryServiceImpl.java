package com.restAPI.rsm_pack_and_drop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restAPI.rsm_pack_and_drop.model.Delivery;
import com.restAPI.rsm_pack_and_drop.repo.DeliveryRepo;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryRepo deliveryRepo;

	@Override
	public List<Delivery> getDeliveryDetails() {
		return deliveryRepo.findAll();
	}

	@Override
	public Delivery getDeliveryInfo(Integer did) {
		return deliveryRepo.findById(did).orElseThrow(() -> new RuntimeException("Delivery not found with ID: " + did));
	}

	@Override
	public Delivery createDeliveryInfo(Delivery delivery) {
		return deliveryRepo.save(delivery);
	}

	@Override
	public String deleteDeliveryInfo(Integer did) {
		if (!deliveryRepo.existsById(did)) {
			throw new RuntimeException("Delivery not found with ID: " + did);
		}
		deliveryRepo.deleteById(did);
		return "Delivery Info " + did + " deleted/paused due to no response from the Customer";
	}

	@Override
	public Delivery updateDeliveryInfo(Delivery delivery, Integer did) {
		Delivery dfDb = getDeliveryInfo(did);
		dfDb.setDeliveryId(delivery.getDeliveryId());
		dfDb.setOrderDetails(delivery.getOrderDetails());
		dfDb.setDriver(delivery.getDriver());
		dfDb.setPickupTime(delivery.getPickupTime());
		dfDb.setDeliveryTime(delivery.getDeliveryTime());
		dfDb.setStatus(delivery.getStatus());
		return deliveryRepo.save(dfDb);
	}

}
