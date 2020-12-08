package model;

public class Flowers extends Plants {
	colorE color;
	String type="flowers";

	
	public colorE getColor() {
		return color;
	}

	public void setColor(colorE color) {
		this.color = color;
	}
	
	public String toString(){
		return "species : \"" + species + "\" located on X: " + plantX + " Y: " + plantY+water+color;
	}
}
