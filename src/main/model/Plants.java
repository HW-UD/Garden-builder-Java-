package model;
public class Plants{
	 String light;
	 String water;
	 String bloomcolor;
	 String food;
	 String bloomtime;
	 String soilReqs;
	 int plantX;
	 int plantY; 
	 String species;
	 public String getLight() {
		return light;
	}


	public void setLight(String light) {
		this.light = light;
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


	public int getPlantx() {
		return plantX;
	}


	public void setPlantx(int plantx) {
		this.plantX = plantx;
	}


	public int getPlanty() {
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
