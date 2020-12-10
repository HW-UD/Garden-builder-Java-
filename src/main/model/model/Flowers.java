package model;

/** The model for Flowers
 * 
 *  @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu 
 *  @version Final
 **/
public class Flowers extends Plants { 

	public Flowers() {
		type="flowers";
	}

/** Get the information of added plants
*  @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu 
*  @return plants' name, location, and attribute
* **/		
	public String toString(){
		return "species : \"" + species + "\" located on X: " + plantX + " Y: " + plantY+water+color+ "+++"+size;
	}
}
