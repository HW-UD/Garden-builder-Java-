package model;

public enum LeafE {
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
	
	public String getName() {return name;} 
}

