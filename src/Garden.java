import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Garden {
	private int gardenLength;
	private int gardenHeight;
	
	Collection <Plants> Garden_Plants;
	
	
	public Garden() {
		this.gardenLength= 15;
		this.gardenHeight=15;
		Garden_Plants = new HashSet<>();//to conduction
		
	}

	public int getGardenLength() {
		return gardenLength;
	}

	public void setGardenLength(int gardenLength) {
		this.gardenLength = gardenLength;
	}

	public int getGardenHeight() {
		return gardenHeight;
	}

	public void setGardenHeight(int gardenHeight) {
		this.gardenHeight = gardenHeight;
	}

	public void addPlant(String species, int x, int y){
		Plants newPlant= new Plants();  
		newPlant.plantLength = x;
		newPlant.plantHeight = y;
		newPlant.species = species;
    	if (newPlant.plantLength > gardenLength || newPlant.plantHeight > gardenHeight) {
    		System.out.println("out of range, try again.");
    	}else {
	    	Garden_Plants.add(newPlant);
    		}			
	}

	
	public void removePlant(String species, int x, int y) {
    	Plants newPlant1= new Plants();
    	newPlant1.species = species;
    	newPlant1.plantLength = x;
    	newPlant1.plantHeight = y;
        if (newPlant1.getSpecies().equals(species)) {
            Garden_Plants.remove(newPlant1);
             }
         }

		
	public void changePlant() {// scanner ,check location, 
		System.out.println("Please select from: " + Garden_Plants); 
    	
    	Scanner scanner = new Scanner(System.in);
        long oldx = scanner.nextLong();
        System.out.println("Please enter the Xloc");
        Scanner scannerB = new Scanner(System.in);
        long newx = scannerB.nextLong();
        System.out.println("OldXloc="+oldx+"\t"+"NewXloc="+newx);
        System.out.println("change location...");
        
        Scanner scannerC = new Scanner(System.in);
        long oldy = scannerC.nextLong();
        System.out.println("Please enter the Yloc");
        Scanner scannerD = new Scanner(System.in);
        long newy = scannerD.nextLong();
        System.out.println("OldXYoc="+oldx+"\t"+"NewYloc="+newx);
        System.out.println("change location...");
        scanner.close();
        scannerB.close();
        scannerC.close();
        scannerD.close();
        

    	
    	if (newx > gardenLength || newy > gardenHeight) {
    		System.out.println("out of range, try again.");
    	}else {
	    	Iterator<Plants> it = Garden_Plants.iterator();
	    	while (it.hasNext()) {
	    		Plants element = it.next();
	    		if (/*element.species.equals(species) &&*/ element.plantLength==oldx && element.plantHeight==oldy) {	// remove even elements
	    			element.plantLength = newx;
	    			element.plantHeight = newy;}
	    	}		    	
	   }	
    	
	}

	public void setGardenX() {
		// TODO Auto-generated method stub
		
	}

	public void setGardenY() {
		// TODO Auto-generated method stub
		
	}
}


