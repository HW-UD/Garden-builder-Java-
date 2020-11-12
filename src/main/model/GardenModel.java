package model;
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
	public static Garden garden = new Garden();
	public static String[] plantdata;
	
	
	
	public static void UpdatePlant() {
		try {
			File myObj = new File("10_plants.txt");
			Scanner scanner = new Scanner(myObj);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				String[] line = data.split(",");
				plantdata =line;
			}
		// String filename = scanner.next();
		scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	 public static void printspecies() {//species attribute. from a file
			for(String p : plantdata) {
					   System.out.println(p.toString());
					  }
	}
	
	public GardenModel() {
		UpdatePlant();
	}
	

	

}
