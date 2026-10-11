package com.restAPI.rsm_pack_and_drop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restAPI.rsm_pack_and_drop.model.Delivery;
import com.restAPI.rsm_pack_and_drop.service.DeliveryService;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @GetMapping("/getDeliveryDetails")
    public List<Delivery> getDeliveryDetails() {
        return deliveryService.getDeliveryDetails();
    }

    @GetMapping("/getDeliveryInfo/{did}")
    public Delivery getDeliveryInfo(@PathVariable Integer did) {
        return deliveryService.getDeliveryInfo(did);
    }

    @PostMapping("/createDeliveryInfo")
    public Delivery createDeliveryInfo(@RequestBody Delivery delivery) {
        return deliveryService.createDeliveryInfo(delivery);
    }

    @DeleteMapping("/deleteDeliveryInfo/{did}")
    public String deleteDeliveryInfo(@PathVariable Integer did) {
        return deliveryService.deleteDeliveryInfo(did);
    }

    @PutMapping("/updateDeliveryInfo/{did}")
    public Delivery updateDeliveryInfo(
            @RequestBody Delivery delivery,
            @PathVariable Integer did) {

        return deliveryService.updateDeliveryInfo(delivery, did);
    }
}
