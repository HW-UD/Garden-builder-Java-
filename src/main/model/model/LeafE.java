package model;

/** The model for LeafE
 * 
 *  @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu 
 *  @version Final
 **/

public enum LeafE {
	All("All"),
	Oval("Oval"),
	Ovate("Ovate"),
	Linear("Linear"),
	Oblong("Oblong"),
	Heart("Heart"),
	Needle("Needle"),
	Maple("Maple"),
	Scale("Scale"),
	Spear("Spear"),
	Paddle("Paddle");

	
	
	
	private String name = null;
	private LeafE(String s){name = s;}
	
/** Get the attribute name
 * 
 * @return name
 */
	public String getName() {
		return name;} 
}

