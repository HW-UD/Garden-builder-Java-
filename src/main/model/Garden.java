package model;
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
		newPlant.plantX = x;
		newPlant.plantY = y;
		newPlant.species = species;
    	if (newPlant.plantX > gardenLength || newPlant.plantY > gardenHeight) {
    		System.out.println("out of range, try again.");
    	}else {
	    	Garden_Plants.add(newPlant);
    		}			
	}

	
	public void removePlant(String species, int x, int y) {
    	Plants newPlant1= new Plants();
    	newPlant1.species = species;
    	newPlant1.plantX = x;
    	newPlant1.plantY = y;
    	Garden_Plants.remove(newPlant1);
             
         }

		
	public void changePlant(String species, int oldx, int oldy, int newx, int newy) {// scanner ,check location, 
		addPlant( species, oldx, oldy);
		removePlant( species, newx, newy);
	}
	
	}




