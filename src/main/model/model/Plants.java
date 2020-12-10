package model;

import java.io.Serializable;

import view.GardenImage;

/** The model for Plants
 * 
 *  @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu 
 *  @version Final
 **/

public class Plants implements Serializable{
	 String species;//plant name
	 double plantX;//plant x
	 double plantY;//plant y
	 double size;//plant height
	 waterE water;//water need of plant
	 LeafE Leaf;//different shape of leaf of plant
	 colorE color;//plant color
	 String type;//plant type
	 GardenImage imgSpring;//spring image of plants
	 GardenImage imgFall;//fall image of plants
	 GardenImage imgSummer;//summer image of plants
	 GardenImage imgWinter;//winter image of plants
	 
	/** Test if two names are equal
	 * @return plants' name
	 *
	 */
	  @Override
	  public boolean equals(Object o) {
	    // if two cats have the same name they should be equal
	    if (o instanceof Plants){
	    	Plants plts=(Plants) o;
	    	return (plts.getSpecies().equals(this.getSpecies()) 
	    			&& this.getPlantx()==plts.getPlantx() 
	    			&&this.getPlanty()==plts.getPlanty());
	    }else return false;  
	  }

	  @Override
	  public int hashCode() {
	      // if two cats have the same hashcode they should be equal
	        return this.species.hashCode();
	  }
	 
	 public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public GardenImage getImgSpring() {
		return imgSpring;
	}

	public void setImgSpring(GardenImage imgSpring) {
		this.imgSpring = imgSpring;
	}

	public GardenImage getImgFall() {
		return imgFall;
	}

	public void setImgFall(GardenImage imgFall) {
		this.imgFall = imgFall;
	}

	public GardenImage getImgSummer() {
		return imgSummer;
	}

	public void setImgSummer(GardenImage imgSummer) {
		this.imgSummer = imgSummer;
	}

	public GardenImage getImgWinter() {
		return imgWinter;
	}

	public void setImgWinter(GardenImage imgWinter) {
		this.imgWinter = imgWinter;
	}

	public colorE getColor() {
		return color;
	 }

	 public void setColor(colorE color) {
		this.color = color;
	 }
		
   	 public LeafE getLeaf() {
		return Leaf;
	}

	 public void setLeaf(LeafE Leaf) {
		 this.Leaf = Leaf;
	 }
		
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
