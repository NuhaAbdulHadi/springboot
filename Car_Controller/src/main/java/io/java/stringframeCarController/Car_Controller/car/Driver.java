package io.java.stringframeCarController.Car_Controller.car;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Driver {

	@Id
	private int driverid;
	private String name;
	private ZonedDateTime time;
	// Foreign key for Car
	private int carId = -1;

	public Driver() {

	}

	public Driver(int driverId, String name) {
		super();
		this.driverid = driverId;
		this.name = name;
	}

	public int getId() {
		return this.driverid;
	}

	public void setId(int driverId) {
		this.driverid = driverId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCarId() {
		return this.carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public ZonedDateTime getTime() {
		return this.time;
	}

	public void setTime(ZonedDateTime time) {
		this.time = time;
	}
}
