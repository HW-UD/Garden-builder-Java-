package model;

/** The model for Tree
 * 
 *  @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu 
 *  @version Final
 **/

public class Tree extends Plants {

	public Tree() {
		type="Trees";

	}

/** 
*  @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu 
*  @return plants' name, location, and attribute
* **/		
	public String toString(){
		return "species : \"" + species + "\" located on X: " + plantX + " Y: " + plantY+water+" soil: "+Leaf + "+++"+size;
	}
	
}
