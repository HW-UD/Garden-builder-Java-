package model;

public enum colorE {
	White("White"),
	Purple("Purple"),
	Blue("Blue"),
	Orange("Orange"),
	Yellow("Yellow"),
	Pink("Pink");
	

	private String name = null;
	private colorE(String s){name = s;}
	
	public String getName() {return name;} 

}
