package view;

import java.io.InputStream;

import javafx.scene.image.Image;

/** Customerised the gardenimage
 * 
 * @author Huawei Wang
 * @version Final
 *
 */

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
