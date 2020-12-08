package model;

public enum waterE {
	High("High"),
	Medium("Medium"),
	Low("Low");
	
	
	private String name = null;
	private waterE(String s){name = s;}
	
	public String getName() {return name;} 
}
