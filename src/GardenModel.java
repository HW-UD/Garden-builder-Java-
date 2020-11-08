import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GardenModel {
	Garden garden = new Garden();
	static List<List<String>> plantdata = new LinkedList<List<String>>();
	
	ArrayList <String> allPlants = new  ArrayList();//plan1
	ArrayList <Plants> allPlants2 = new  ArrayList();//plan2
	//[a,b,c,d,e,]
	
	public void inputPlants(){
		int i=1;
		Plants a = new Plants();
		for (List a: plantdata) {
			
			a.名字 = plantdata的 第一行；
		    a.characteristic= plantdata的第二行；
		    allPlants.add(a);
		}
		
	}
	
	public void printspecies() {//species attribute. from a file
	for (String a:allPlants ) {
		System.out.println(
				a.indexOf+ a
				);
	}
	
	
	
	
    	System.out.println("Please select from: \n"+ 
    			"		 a (\"Allegheny Serviceberry (Amelanchier laevis)\" ),\n" + 
    			"		 b (\"Alternate Leaf Dogwood (cornus alternifolia)\"),\n" + 
    			"		 c (\"American Basswood (Tilia americana)\"),\n" + 
    			"		 d (\"American Plum (Prunus americana\"),\n" + 
    			"		 e (\"Canadian Service-Berry (Amelanchier canadensis)\"),\n" + 
    			"		 f (\"Chestnut Oak (Quercus montana)\"),\n" + 
    			"		 g (\"Downy Service-Berry (Amelanchier arborea)\"),\n" + 
    			"		 h (\"Eastern Hop-Hornbeam (Ostrya virginiana)\"),\n" + 
    			"		 i (\"Easter Red-Cedar (Juniperus virginiana)\"),\n" + 
    			"		 j (\"Eastern Wahoo(Euonymus atropurpureus)\"");
	}
	
	
	
	public GardenModel() {
		UpdatePlant();
	}
	

	public void UpdatePlant() {
	  try {
	  File myObj = new File("10_plants.txt");
	  Scanner scanner = new Scanner(myObj);

	  while (scanner.hasNextLine()) {
		  String data = scanner.nextLine();
		  String[] line = data.split(",");
			  List<String> linedata = Arrays.asList(line);
			  plantdata.add(linedata);
			  }
	  
		  scanner.close();
		  } catch (FileNotFoundException e) {
			  System.out.println("An error occurred.");
			  e.printStackTrace();
		  }
	  }
	
	public void loadData() {
		for (List l: plantdata) {
			System.out.println(l);
		}
	}
	
	public void printMenus() {
		System.out.println("Please select from: \n"+
				"1. Load plant data \n" + 
    			"2. Get garden large dimensions\n" + 
    			"3. Add plant to garden\n" + 
    			"4. Delete plant from garden\n" + 
    			"5. Move existing plant in garden\n" + 
    			"6. Print plants + locations\n" + 
    			"7. Exit" );
	}
	
	public void selectManue(){
		printMenus();
		int choise;
		do {
			choise = garden.scanint();
		}while (choise<=0 || choise >7);
		
		switch (choise){
		case 1:
			
			loadData();
			break;
		case 2:
			System.out.println("curretent size: x: "+garden.getGardenX()+" y: "+garden.getGardenY());
			garden.setGardenX();
			garden.setGardenY();
			break;
		case 3:
			garden.addPlant();
			break;
		case 4:
			garden.removePlant();
			break;
		case 5:
			garden.changePlant();
			break;
		case 6:
			System.out.println(garden.Garden_plants);
			break;
		}
	
		if (choise != 7) {
			selectManue();
		} 
	}
}
