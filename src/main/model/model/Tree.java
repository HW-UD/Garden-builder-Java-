package model;

public class Tree extends Plants {

	public Tree() {
		type="Trees";

	}

	
	public String toString(){
		return "species : \"" + species + "\" located on X: " + plantX + " Y: " + plantY+water+" soil: "+Leaf + "+++"+size;
	}
	
}
