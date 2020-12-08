package model;

public class Tree extends Plants {
	String type="Trees";


	
	public String toString(){
		return "species : \"" + species + "\" located on X: " + plantX + " Y: " + plantY+water+" soil: "+soil;
	}
	
}
