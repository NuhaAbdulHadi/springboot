package io.java.stringframeCarController.Car_Controller.car;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.ZonedDateTime;

@RestController
public class Controller {

	@Autowired
	private DriverService driverService;
	@Autowired
	private CarService carService;

	@RequestMapping(method = RequestMethod.POST, value = "/status")
	public void updateCarsStatus() {
		Car car = null;
		List<Car> cars_list = carService.getAllCars();
		for (int i = 0; i < cars_list.size(); i++) {
			car = cars_list.get(i);
			if (car.getDriverId() != -1) {
				car.setEngineHealth(car.getEngineHealth() - 100);
				car.setTransSysHealth(car.getTransSysHealth() - 80);
				car.setFuel(car.getFuel() - 10);
				carService.UpdateCar(car);
			}
		}
	}

	@RequestMapping("/drivers")
	public List<Driver> getAllDrivers() {
		return driverService.getAllDrivers();
	}

	@RequestMapping("/drivers/{driverId}")
	public Object getDriver(@PathVariable int driverId) {
		return driverService.getDriver(driverId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/drivers/{driverId}")
	public void addDriver(@RequestBody Driver driver) {
		driver.setTime(ZonedDateTime.now());
		driverService.addDriver(driver);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/drivers/{driverId}/select/cars/{carId}")
	public void selectCar(@RequestBody Driver driver, @PathVariable int driverId, @PathVariable int carId)
			throws CarAlreadyInUseException, DriverAlreadyDrivesCarException {
		Driver d = null;
		Car c = null;
		int i;
		List<Driver> driver_list = driverService.getAllDrivers();
		List<Car> car_list = carService.getAllCars();
		for (i = 0; i < driver_list.size(); i++) {
			if (driver_list.get(i).getId() == driverId)
				d = driver_list.get(i);
		}
		for (i = 0; i < car_list.size(); i++) {
			if (car_list.get(i).getCarId() == carId)
				c = car_list.get(i);
		}
		if (c.getDriverId() != -1)
			throw new CarAlreadyInUseException();

		if (d.getCarId() != -1)
			throw new DriverAlreadyDrivesCarException();

		d.setCarId(carId);
		c.setDriverId(driverId);
		carService.UpdateCar(c);
		driverService.UpdateDriver(d);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/drivers/{driverId}/deselect")
	public void deselectCar(@RequestBody Driver driver, @PathVariable int driverId) {
		Driver d = null;
		Car c = null;
		int i;
		List<Driver> driver_list = driverService.getAllDrivers();
		List<Car> car_list = carService.getAllCars();
		for (i = 0; i < driver_list.size(); i++) {
			if (driver_list.get(i).getId() == driverId)
				d = driver_list.get(i);
		}
		if (d != null && d.getCarId() != -1) {
			for (i = 0; i < car_list.size(); i++) {
				if (car_list.get(i).getCarId() == d.getCarId())
					c = car_list.get(i);
			}
			if (c != null) {
				d.setCarId(-1);
				c.setDriverId(-1);
			}
		}
		carService.UpdateCar(c);
		driverService.UpdateDriver(d);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/drivers/{driverId}")
	public void UpdateDriver(@RequestBody Driver driver, @PathVariable int driverId) {
		driverService.UpdateDriver(driver);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/drivers/{driverId}")
	public void DeleteDriver(@PathVariable int driverId) {
		driverService.DeleteDriver(driverId);
	}

	@RequestMapping("/cars")
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}

	@RequestMapping("/cars/{carId}")
	public Optional<Car> getCar(@PathVariable int carId) {
		return carService.getCar(carId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cars/{carId}")
	public void addCar(@RequestBody Car car) {
		car.setTime(ZonedDateTime.now());
		carService.addCar(car);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/cars/{carId}")
	public void DeleteCar(@PathVariable int carId) {
		carService.DeleteCar(carId);
	}
}
