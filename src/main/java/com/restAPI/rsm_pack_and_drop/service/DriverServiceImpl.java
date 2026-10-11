package com.restAPI.rsm_pack_and_drop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restAPI.rsm_pack_and_drop.model.Driver;
import com.restAPI.rsm_pack_and_drop.repo.DriverRepo;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepo driverRepo;

	@Override
	public List<Driver> getAllDrivers() {
		return driverRepo.findAll();
	}

	@Override
	public Driver getDriver(Integer id) {
		return driverRepo.findById(id).orElseThrow(() -> new RuntimeException("Driver not found with ID: " + id));
	}

	@Override
	public Driver newDriver(Driver driver) {
		return driverRepo.save(driver);
	}

	@Override
	public String deleteDriver(Integer id) {
		if (!driverRepo.existsById(id)) {
			throw new RuntimeException("Driver not found with ID: " + id);
		}

		driverRepo.deleteById(id);
		return "Driver with id=" + id + " removed/deleted successfully";
	}

	@Override
	public Driver updateDriverDetails(Driver driver, Integer id) {
		Driver dDb = getDriver(id);
		dDb.setDname(driver.getDname());
		dDb.setPhone(driver.getPhone());
		dDb.setLicenseNumber(driver.getLicenseNumber());
		dDb.setVehicleNumber(driver.getVehicleNumber());
		dDb.setAvailabilityStatus(driver.getAvailabilityStatus());

		return driverRepo.save(dDb);
	}

}
