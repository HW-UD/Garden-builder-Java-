import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Garden {
	private int gardenX;//gadenHight
	private int gardenY;
	
	Collection <Plants> Garden_Plants;
	
	
	public Garden() {
		this.gardenX= 15;
		this.gardenY=15;
		Garden_Plants = new HashSet<>();//to conduction
		
	}

	public int getGardenX() {
		return gardenX;
	}

	public void setGardenX(int gardenX) {
		this.gardenX = gardenX;
	}

	public void setGardenX() {
		this.gardenX=
		   System.out.println("Please input garden Length(X)");// in View point.class; box claa
		   try {
			   this.gardenX = scanint();
		   }catch(InputMismatchException e){
			    System.out.println("Input Mismatch Try again.");
			    setGardenX();
		   }
	}

	public int getGardenY() {
		return gardenY;
	}

	public void setGardenY( ) {
		   System.out.println("Please input garden Width(Y)");
		   try {
			   this.gardenY = scanint();
		   }catch(InputMismatchException e){
			    System.out.println("Input Mismatch Try again.");
			    setGardenY();
		   }
	}
	
	
	
	public int scanint() {//view
		   Scanner myObj = new Scanner(System.in); 
		   int num = myObj.nextInt(); 
//		   myObj.close();
		   return num; 
		 }
	
	public static String scan() {

	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		String act = myObj.nextLine();  // Read user input
//		myObj.close();
	    return act;
	}
	
	public int scanIn(String a) {
		
		while (next!=scanint) {
	    	System.out.println(a);
			try {int num=scanint();
				return num;
			}catch(InputMismatchException e){
				System.out.println("Input Mismatch Try again.");
			}
		}
		
	}
	
	public void printBreed() {//species attribute. from a file
		
		
		
    	System.out.println("Please select from: \n"+ 
    			"		 1 (\"Allegheny Serviceberry (Amelanchier laevis)\" ),\n" + 
    			"		 2 (\"Alternate Leaf Dogwood (cornus alternifolia)\"),\n" + 
    			"		 3 (\"American Basswood (Tilia americana)\"),\n" + 
    			"		 4 (\"American Plum (Prunus americana\"),\n" + 
    			"		 5 (\"Canadian Service-Berry (Amelanchier canadensis)\"),\n" + 
    			"		 f (\"Chestnut Oak (Quercus montana)\"),\n" + 
    			"		 g (\"Downy Service-Berry (Amelanchier arborea)\"),\n" + 
    			"		 h (\"Eastern Hop-Hornbeam (Ostrya virginiana)\"),\n" + 
    			"		 i (\"Easter Red-Cedar (Juniperus virginiana)\"),\n" + 
    			"		 j (\"Eastern Wahoo(Euonymus atropurpureus)\"");
	}
	
	public String choiseToName() {// view 
		
    	System.out.println("Please input breed");
    	printBreed();
    	while (true) {
    		String breed=scan();
    		System.out.println(breed);
    		
    		""
    		//change to number 
    		if (breed.equals("a")||breed.equals("b")||breed.equals("c")||breed.equals("d")||breed.equals("e")||breed.equals("f")||breed.equals("g")|| breed.equals("h")||breed.equals("")||breed.equals("j") ) {
	    			plantE readyStatus = plantE.valueOf(breed);
	    			return readyStatus.getName();
    			}else {
    				System.out.println("Input Mismatch Try again.");
    			}
    		}
	}
	
	
	
	public void addPlant(){// check seperate
		Plants newp= new Plants();
		newp.breed=choiseToName();
    	
		
		
	    newp.x = scanIn("Please input Xloc");	// view	
	    newp.y = scanIn("Please input Yloc"); 
    	
    	if (newp.x > gardenX || newp.y > gardenY) {
    		System.out.println("out of range, try again.");
    	}else {
	    	Garden_Plants.add(newp);
    		}
    	
			
	}
	
	
	
	
	
	
	
	
	
	public void removePlant(breed, x,y) {


    	Plants element= new Plants;
    	ele.name=breed;
    	ele.x=x
    eley=y;
    	
    	
    	
    	Garden_Plants.remove(elemtens);
    	

	}
	
	
	
	
	
	
	
	
	
	public void changePlant() {// scaner ,chaeck location, 
		System.out.println("Please select from: " + Garden_Plants); 
    	String breed=choiseToName();

    	
    	int oldx= scanIn("Please input Xloc");
    	int oldy= scanIn("Please input Yloc");
    	int newx= scanIn("Please input new Xloc");
    	int newy= scanIn("Please input new Yloc");
    	
    	if (newx > gardenX || newy > gardenY) {
    		System.out.println("out of range, try again.");
    	}else {
	    	Iterator<Plants> it = Garden_Plants.iterator();
	    	while (it.hasNext()) {
	    		Plants element = it.next();
	    		if (element.breed.equals(breed) && element.x==oldx && element.y==oldy) {	// remove even elements
	    			element.x=newx;
	    			element.y=newy;}
	    	}		    	
	   }	
    	
	}
}


