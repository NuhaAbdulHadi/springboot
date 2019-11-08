package io.java.stringframeCarController.Car_Controller.car;

@SuppressWarnings("serial")
public class CarAlreadyInUseException extends Exception {

	public CarAlreadyInUseException() {

		super();

	}

	public CarAlreadyInUseException(String s) {

		super();

	}

	@Override
	public String getMessage() {

		return super.getMessage() + "The car already reserved!";
	}

}
