package io.java.stringframeCarController.Car_Controller.car;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {
	@Autowired
	private DriverRepository driverRepository;

	public List<Driver> getAllDrivers() {
		List<Driver> drivers = new ArrayList<>();
		driverRepository.findAll().forEach(drivers::add);
		return drivers;
	}

	public Object getDriver(int driverId) {
		return driverRepository.findById(driverId);
	}

	public void addDriver(Driver driver) {
		driverRepository.save(driver);
	}

	public void selectCar(Driver driver) {
		driverRepository.save(driver);
	}

	public void UpdateDriver(Driver driver) {
		driverRepository.save(driver);
	}

	public void DeleteDriver(int driverId) {
		driverRepository.deleteById(driverId);
	}
}
