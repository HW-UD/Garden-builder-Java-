package controller;


import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GardenModel;
import model.Plants;
import model.SceneName;
import view.ViewDrag;
import view.ViewPwork;
import view.ViewRating;
import view.ViewWelcome;
import view.Viewplants;

//import net.snortum.javafx.multiscene.model.SceneName;
//import net.snortum.javafx.multiscene.view.MainView;
//import net.snortum.javafx.multiscene.view.ViewOne;
//import net.snortum.javafx.multiscene.view.ViewThree;
//import net.snortum.javafx.multiscene.view.ViewTwo;


public class Main extends Application {
	
	/** Holds the various scenes to switch between */
	private static Map<SceneName, Scene> scenes = new HashMap<>();
	static GardenModel model;
    String WorkPath = System.getProperty("user.dir");
	static ViewDrag drag;
	
	@Override
	public void start(Stage stage) {
		model= new GardenModel();
		drag = new ViewDrag(stage);
		 
		model.UpdatePlant(WorkPath+"/src/main/Bank/flowers.txt",model.getFlowerdata());
		model.UpdatePlant(WorkPath+"/src/main/Bank/trees.txt",model.getTreedata());
		model.UpdatePlant(WorkPath+"/src/main/Bank/shurbs.txt",model.getTreedata());
		model.loadFlower();
		model.loadTree() ;
		
		for (Plants p: model.getPlantBank()) {
			System.out.println(p);
		}
		// Create and store all scenes up front
		scenes.put(SceneName.ViewWelcome, new ViewWelcome(stage).getScene());
		scenes.put(SceneName.ViewPwork, new ViewPwork(stage).getScene());
		scenes.put(SceneName.Viewplants, new Viewplants(stage).getScene());
		scenes.put(SceneName.ViewDrag, drag.getScene());
		scenes.put(SceneName.ViewRating, new ViewRating(stage).getScene());

		// Start with the main scene
		stage.setScene(scenes.get(SceneName.ViewWelcome));
		stage.setTitle("G14 Garden Design");
		stage.show();
	}

	/** Returns a Map of the scenes by {@link SceneName} */
	public static Map<SceneName, Scene> getScenes() {
		return scenes;
	}
	
	public static ViewDrag getDrag() {
		return drag;
	}

	public static void setDrag(ViewDrag drag) {
		Main.drag = drag;
	}

	public static GardenModel getModel() {
		return model;
	}

	public static void setModel(GardenModel model) {
		Main.model = model;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
