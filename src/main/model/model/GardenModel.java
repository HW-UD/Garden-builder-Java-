package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class GardenModel {
	 static Garden garden;
	 static ArrayList<Plants> plantBank;
	 static List<List<String>> flowerdata = new LinkedList<List<String>>();
	 static List<List<String>> Treedata = new LinkedList<List<String>>();

	 
	public GardenModel() {
		  garden = new Garden();
		  plantBank = new ArrayList();	
		  }
	
	 public static void loadFlower() {
		for(List<String> p : flowerdata) {
			Flowers tmp= new Flowers();
			int i=0;
			for (String str:p){
				switch(i%3){
					case 0:
						tmp.setSpecies(str);
						break;
					case 1:
						tmp.setColor(colorE.valueOf(str));
						break;
					case 2:
						tmp.setWater(waterE.valueOf(str));
						break;
				}
				i++;
			}
			plantBank.add(tmp);
		}
	 }
	 
	 public static void loadTree() {
		for(List<String> p : Treedata) {
			Tree tmp= new Tree();
			int i=0;
			for (String str:p){
				switch(i%3){
					case 0:
						tmp.setSpecies(str);
						break;
					case 1:
						System.out.println(str);
						tmp.setLeaf(LeafE.valueOf(str));
						break;
					case 2:
						tmp.setWater(waterE.valueOf(str));
						break;
				}
				i++;
			}
			plantBank.add(tmp);
		}
	 }
	 
	 public static void UpdatePlant(String path,List<List<String>> pdata) {
	   try {
		   File myObj = new File(path);
		   Scanner scanner = new Scanner(myObj);
	
		   while (scanner.hasNextLine()) {
			   String data = scanner.nextLine();
			   String[] line = data.split(",");
			   List<String> linedata = Arrays.asList(line);
			   pdata.add(linedata);
			   }
		   // String filename = scanner.next();
		   scanner.close();
		   
		   
		   } catch (FileNotFoundException e) {
			   System.out.println("An error occurred.");
			   e.printStackTrace();
		   }
	   }
	 
	
	public static ArrayList<Plants> getPlantBank() {
		return plantBank;
	}


	public static void setPlantBank(ArrayList<Plants> plantBank) {
		GardenModel.plantBank = plantBank;
	}


	public Garden getGarden() {
		return garden;
	}

	public static void setGarden(Garden garden) {
		GardenModel.garden = garden;
	}

	public static List<List<String>> getFlowerdata() {
		return flowerdata;
	}

	public static void setFlowerdata(List<List<String>> flowerdata) {
		GardenModel.flowerdata = flowerdata;
	}

	public static List<List<String>> getTreedata() {
		return Treedata;
	}

	public static void setTreedata(List<List<String>> treedata) {
		Treedata = treedata;
	}
	
	

//	public String toString(){
//		return "species : \"" + species + "\" located on X: " + plantX + " Y: " + plantY;
//	}
	

	

}
