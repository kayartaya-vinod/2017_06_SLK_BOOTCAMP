package slk.programs;

import slk.entity.Camera;
import slk.entity.CameraFactory;

public class P01_TestPolymorphism {

	public static void main(String[] args) {
		Camera c1;
		
		c1 = CameraFactory.newInstance(2);
		c1.takePhoto();
		c1.viewPhotos();
	}
}
