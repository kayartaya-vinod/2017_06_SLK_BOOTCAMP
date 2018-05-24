package slk.entity;

public class CameraFactory {

	// factory method for manufacturing an instance of a Camera type
	// a.k.a virtual constructor
	public static Camera newInstance(int discriminator) {

		switch (discriminator) {
		case 1:
			return new SmartPhone();
		case 2:
			return new DigitalCamera();
		}
		throw new RuntimeException("Invalid discriminator supplied!");
	}

}
