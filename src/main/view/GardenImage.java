package view;

import java.io.InputStream;

import javafx.scene.image.Image;

public class GardenImage extends Image {
	String ID;
	public GardenImage(InputStream arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

	
}
