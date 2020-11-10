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
	public static ArrayList<Plants> plantdata = new ArrayList<Plants>();
	
	public static void UpdatePlant() {
		try {
		File myObj = new File("10_plants.txt");
		Scanner scanner = new Scanner(myObj);

		while (scanner.hasNextLine()) {
		String data = scanner.nextLine();
		String[] line = data.split(",");
		Plants newplant = new Plants(line[0]);
		plantdata.add(newplant);
		}
		// String filename = scanner.next();
		scanner.close();
		} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
		}
		}

	 public static void printspecies() {//species attribute. from a file
			for(Plants p : plantdata) {
					   System.out.println(p.toString());
					  }
	}
	
	public GardenModel() {
		UpdatePlant();
	}
	
	
	public void loadData() {
		for (Plants l: plantdata) {
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
