package model;

/** The model for colorE
 * 
 *  @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu 
 *  @version Final
 **/

public enum colorE {
	All("All"),
	White("White"),
	Purple("Purple"),
	Blue("Blue"),
	Orange("Orange"),
	Yellow("Yellow"),
	Pink("Pink");
	

	private String name = null;
	private colorE(String s){name = s;}
	
	/** Get the attribute name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
		} 

}
