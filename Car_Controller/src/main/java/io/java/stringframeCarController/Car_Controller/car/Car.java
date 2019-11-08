package io.java.stringframeCarController.Car_Controller.car;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	private int carId;
	private int seatCount;
	private String licensePlate;
	private String rating;
	private String engineType;
	private String manufacture;
	private boolean convertible;
	private ZonedDateTime time;

	// Foreign key for Driver
	private int driverId = -1;

	// For update status for driving car
	private int fuel = 400;
	private int engineHealth = 100000;
	private int transSysHealth = 100000;

	public Car() {

	}

	public Car(int carId, String licensePlate, String rating, int seatCount, String engineType, boolean convertible,
			String manufacture) {
		super();
		this.carId = carId;
		this.licensePlate = licensePlate;
		this.rating = rating;
		this.seatCount = seatCount;
		this.engineType = engineType;
		this.convertible = convertible;
		this.manufacture = manufacture;
	}

	public ZonedDateTime getTime() {
		return this.time;
	}

	public void setTime(ZonedDateTime time) {
		this.time = time;
	}

	public int getCarId() {
		return this.carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getLicensePlate() {
		return this.licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getSeatCount() {
		return this.seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public String getEngineType() {
		return this.engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public boolean isConvertible() {
		return convertible;
	}

	public void setConvertible(boolean convertible) {
		this.convertible = convertible;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public int getDriverId() {
		return this.driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getFuel() {
		return this.fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public int getEngineHealth() {
		return engineHealth;
	}

	public void setEngineHealth(int engineHealth) {
		this.engineHealth = engineHealth;
	}

	public int getTransSysHealth() {
		return this.transSysHealth;
	}

	public void setTransSysHealth(int transSysHealth) {
		this.transSysHealth = transSysHealth;
	}
}
