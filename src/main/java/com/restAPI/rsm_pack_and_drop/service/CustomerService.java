package com.restAPI.rsm_pack_and_drop.service;

import java.util.List;

import com.restAPI.rsm_pack_and_drop.model.Customer;

public interface CustomerService  {
    //Get all the Customers
	List<Customer> getCustomersDetails();

	//create a customer data
    Customer createCustomer(Customer customer);

    //Retrieve a single customer by Id
    Customer getCustomer(Integer cid);

    //Delete the customer by Id
    String deleteCustomer(Integer cid);

    //Update the customer by Id
    Customer updateCustomer(Customer customer, Integer cid);
}
