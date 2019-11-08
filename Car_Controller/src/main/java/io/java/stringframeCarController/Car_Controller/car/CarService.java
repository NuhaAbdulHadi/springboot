package io.java.stringframeCarController.Car_Controller.car;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;

	public List<Car> getAllCars() {
		List<Car> car = new ArrayList<>();
		carRepository.findAll().forEach(car::add);
		return car;
	}

	public Optional<Car> getCar(int carId) {
		return carRepository.findById(carId);
	}

	public void addCar(Car car) {
		carRepository.save(car);

	}

	public void UpdateCar(Car car) {
		carRepository.save(car);
	}

	public void DeleteCar(int carId) {
		carRepository.deleteById(carId);
	}
}
