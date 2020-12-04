package model;
public class Plants{
	 String name;
	 String light;
	 String water;
	 String bloomcolor;
	 String food;
	 String bloomtime;
	 String soilReqs;
	 double plantX;
	 double plantY; 
	 String species;
	 
	 public String getLight() {
		return light;
	}


	public void setLight(String light) {
		light = "glare";
		light = "medium";
		light = "weak";
		this.light = light;
	}


	public String getWater() {
		return water;
	}


	public void setWater(String water) {
		water = "large";
		water = "medium";
		water = "little";
		this.water = water;
	}


	public String getBloomcolor() {
		return bloomcolor;
	}


	public void setBloomcolor(String bloomcolor) {
		this.bloomcolor = bloomcolor;
	}


	public String getFood() {
		return food;
	}


	public void setFood(String food) {
		this.food = food;
	}


	public String getBloomtime() {
		return bloomtime;
	}


	public void setBloomtime(String bloomtime) {
		this.bloomtime = bloomtime;
	}


	public String getSoilReqs() {
		return soilReqs;
	}


	public void setSoilReqs(String soilReqs) {
		this.soilReqs = soilReqs;
	}


	public double getPlantx() {
		return plantX;
	}


	public void setPlantx(int plantx) {
		this.plantX = plantx;
	}


	public double getPlanty() {
		return plantY;
	}


	public void setPlanty(int planty) {
		this.plantY = planty;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public String getCharacteristic() {
		return characteristic;
	}


	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	
	String characteristic;
	
	public String toString(){
			return "species : \"" + species + "\" located on X: " + plantX + " Y: " + plantY;
		}
	
	
	//Hashcode
	//equalsmethod
}
