package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GardenImgView extends ImageView{
	String ID;
	GardenImage gimage;

	public GardenImgView() {
		super();
	}

	
	public GardenImgView(GardenImage image) {
		super();
		 gimage=image;	
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}


	public GardenImage getGardenImage() {
		return gimage;
	}
	
	
	
}
