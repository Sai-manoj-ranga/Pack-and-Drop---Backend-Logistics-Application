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

import com.restAPI.rsm_pack_and_drop.model.Driver;
import com.restAPI.rsm_pack_and_drop.service.DriverService;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/driversList")
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/driver/{id}")
    public Driver getDriver(@PathVariable Integer id) {
        return driverService.getDriver(id);
    }

    @PostMapping("/newDriverEntry")
    public Driver newDriver(@RequestBody Driver driver) {
        return driverService.newDriver(driver);
    }

    @DeleteMapping("/driverleft/{id}")
    public String deleteDriver(@PathVariable Integer id) {
        return driverService.deleteDriver(id);
    }

    @PutMapping("/updateDriver/{id}")
    public Driver updateDriverDetails(
            @RequestBody Driver driver,
            @PathVariable Integer id) {

        return driverService.updateDriverDetails(driver, id);
    }

}
