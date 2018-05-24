package slk.entity;

public class SmartPhone extends Phone implements Camera, MusicPlyaer {

	@Override
	public void play() {
		System.out.println("Playing music from SmartPhone...");
	}

	@Override
	public void pause() {
		System.out.println("Paused music from SmartPhone...");
	}

	@Override
	public void takePhoto() {
		System.out.println("Taking photo from SmartPhone...Smile :)");
	}

	@Override
	public void viewPhotos() {
		System.out.println("Viewing pictures in SmartPhone...");
	}

}
