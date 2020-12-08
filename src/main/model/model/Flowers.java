package model;

public class Flowers extends Plants {
	String type="flowers";


	
	public String toString(){
		return "species : \"" + species + "\" located on X: " + plantX + " Y: " + plantY+water+color;
	}
}
