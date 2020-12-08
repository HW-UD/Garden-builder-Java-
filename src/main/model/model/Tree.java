package model;

public class Tree extends Plants {
	soilE soil;
	String type="Trees";
	public soilE getSoil() {
		return soil;
	}

	public void setSoil(soilE soil) {
		this.soil = soil;
	}
	
	public String toString(){
		return "species : \"" + species + "\" located on X: " + plantX + " Y: " + plantY+water+" soil: "+soil;
	}
	
}
