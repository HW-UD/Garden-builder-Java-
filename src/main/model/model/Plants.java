package model;

import java.io.Serializable;

public class Plants implements Serializable{
	 waterE water;
	 double plantX;
	 double plantY; 
	 String species;
	 
	public waterE getWater() {
		return water;
	}

	public void setWater(waterE water) {
		this.water = water;
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

	public String toString(){
		return "species : \"" + species + "\" located on X: " + plantX + " Y: " + plantY;
	}

}
