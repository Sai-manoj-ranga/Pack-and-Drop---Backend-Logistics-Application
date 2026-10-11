package com.restAPI.rsm_pack_and_drop.service;

import java.util.List;

import com.restAPI.rsm_pack_and_drop.model.Driver;

public interface DriverService {
    List<Driver> getAllDrivers();
    Driver getDriver(Integer id);
    Driver newDriver(Driver driver);
    String deleteDriver(Integer id);
    Driver updateDriverDetails(Driver driver, Integer id);
}
