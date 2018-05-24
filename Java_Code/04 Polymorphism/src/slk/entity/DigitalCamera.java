package slk.entity;

public class DigitalCamera implements Camera {

	@Override
	public void takePhoto() {
		System.out.println("Taking picture using Nikon D5200....");
	}

	@Override
	public void viewPhotos() {
		System.out.println("Viewing pictures in Nikon D5200.");
	}

}
