package model;

/** The model for waterE
 * 
 *  @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu 
 *  @version Final
 **/

public enum waterE {
	All("All"),
	High("High"),
	Medium("Medium"),
	Low("Low");
	
	
	private String name = null;
	private waterE(String s){name = s;}
	
	/** Get the attribute name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;} 
}
