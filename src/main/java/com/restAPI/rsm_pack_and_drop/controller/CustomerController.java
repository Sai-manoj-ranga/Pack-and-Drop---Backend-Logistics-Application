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

import com.restAPI.rsm_pack_and_drop.model.Customer;
import com.restAPI.rsm_pack_and_drop.service.CustomerService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustList")
    public List<Customer> getCustomersDetails() {
        return customerService.getCustomersDetails();
    }

    @PostMapping("/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/getCustomer/{cid}")
    public Customer getCustomer(@PathVariable Integer cid) {
        return customerService.getCustomer(cid);
    }

    @DeleteMapping("/deleteCustomer/{cid}")
    public String deleteCustomer(@PathVariable Integer cid) {
        return customerService.deleteCustomer(cid);
    }

    @PutMapping("/updateCustomer/{cid}")
    public Customer updateCustomer( @RequestBody Customer customer, @PathVariable Integer cid) {

        return customerService.updateCustomer(customer, cid);
    }
	

}
