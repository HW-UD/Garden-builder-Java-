package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import controller.DragController;
import javafx.scene.layout.VBox;
import view.GardenImage;
import view.GardenImgView;


public class GardenModel {
	 static Garden garden;
	 static HashSet<Plants> plantBank;
	 static List<List<String>> flowerdata;
	 static List<List<String>> Treedata;
	 
	 static ArrayList<String> season;
	 
	public GardenModel() {
		  garden = new Garden();
		  plantBank = new HashSet();	
		  flowerdata = new LinkedList<List<String>>();
		  Treedata = new LinkedList<List<String>>();
		  season = new ArrayList<String>() { 
	            { 	add("spring"); 
	                add("winter"); 
	                add("fall"); 
	                add("summer"); 
	            } 
	        }; 
		  }
	private void loadSeasonImg(Plants tmp) {
		
		for (String i :season) {
			String Path="../img/"+tmp.getType()+"/"+i+"/";
			String spath = Path + tmp.getSpecies() +".png";
			if (i.equals("winter") && tmp.getType().equals("flowers")) {
				spath = Path + "RudbeckiaFulgida" +".png";
				
			}
			System.out.println(spath);
			GardenImage img =  new GardenImage(getClass().getResourceAsStream(spath));
			img.setID(tmp.getSpecies());
			if (i.equals("spring")) {
		        tmp.setImgSpring(img);
			}else if (i.equals("winter")) {
				tmp.setImgWinter(img);
			}else if (i.equals("summer")) {
				tmp.setImgSummer(img);
			}else {
				tmp.setImgFall(img);
			}
		}
	}
	
	 public void loadFlower() {
		for(List<String> p : flowerdata) {
			Plants tmp= new Flowers();
			int i=0;
			for (String str:p){
				switch(i%4){
					case 0:
						tmp.setSpecies(str);
						break;
					case 1:
						tmp.setSize(Double.parseDouble(str));
						break;	
					case 2:
						tmp.setColor(colorE.valueOf(str));
						break;
					case 3:
						tmp.setWater(waterE.valueOf(str));
						break;
				}
				
				loadSeasonImg(tmp);
				i++;
			}
			plantBank.add(tmp);
		}
	 }
	 
	 public void loadTree() {
		for(List<String> p : Treedata) {
			Tree tmp= new Tree();
			int i=0;
			for (String str:p){
				switch(i%4){
					case 0:
						tmp.setSpecies(str);
						break;
					case 1:
						tmp.setSize(Double.parseDouble(str));
						break;	
					case 2:
						System.out.println(str);
						tmp.setLeaf(LeafE.valueOf(str));
						break;
					case 3:
						tmp.setWater(waterE.valueOf(str));
						break;
				}
				loadSeasonImg(tmp);
				i++;
			}
			plantBank.add(tmp);
		}
	 }
	 
	 public void UpdatePlant(String path,List<List<String>> pdata) {
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
	 
	
	public static HashSet<Plants> getPlantBank() {
		return plantBank;
	}


	public static void setPlantBank(HashSet<Plants> plantBank) {
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
