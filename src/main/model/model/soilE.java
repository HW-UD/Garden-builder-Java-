package model;

public enum soilE {
	Dry("Dry"),
	Moist("Moist"),
	Wet("Wet");
	
	private String name = null;
	private soilE(String s){name = s;}
	
	public String getName() {return name;} 
}

