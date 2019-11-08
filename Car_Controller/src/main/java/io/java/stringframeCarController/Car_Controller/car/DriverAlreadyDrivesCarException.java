package io.java.stringframeCarController.Car_Controller.car;

@SuppressWarnings("serial")
public class DriverAlreadyDrivesCarException extends Exception {

	public DriverAlreadyDrivesCarException() {

		super();

	}

	public DriverAlreadyDrivesCarException(String s) {

		super();

	}

	@Override
	public String getMessage() {

		return super.getMessage() + "This Driver Already Drives Car";
	}

}
