package com.restAPI.rsm_pack_and_drop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restAPI.rsm_pack_and_drop.model.Customer;
import com.restAPI.rsm_pack_and_drop.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo custRepo;

	@Override
	public List<Customer> getCustomersDetails() {
		return custRepo.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return custRepo.save(customer);
	}

	@Override
	public Customer getCustomer(Integer cid) {
		return custRepo.findById(cid).orElseThrow(()-> new RuntimeException("Customer not found with ID: " + cid));
	}

	@Override
	public String deleteCustomer(Integer cid) {
		if (!custRepo.existsById(cid)) {
            throw new RuntimeException("Customer not found with ID: " + cid);
        }
		custRepo.deleteById(cid);
		return "Customer with " + cid + " removed Successfully";
	}

	@Override
	public Customer updateCustomer(Customer customer, Integer cid) {
		 Customer custFromDb = getCustomer(cid);
	     custFromDb.setCName(customer.getCName());
	     custFromDb.setEmail(customer.getEmail());
	     custFromDb.setPhoneNumber(customer.getPhoneNumber());
	     custFromDb.setAddress(customer.getAddress());
	     return custRepo.save(custFromDb);
	}

}
