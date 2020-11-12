package controller;


import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GardenModel;
import model.SceneName;
import view.ViewCharacteristics;
import view.ViewDrag;
import view.ViewExample;
import view.ViewFences;
import view.ViewFlowers;
import view.ViewSeason;
import view.ViewSurround;
import view.ViewTrees;
import view.ViewWelcome;

//import net.snortum.javafx.multiscene.model.SceneName;
//import net.snortum.javafx.multiscene.view.MainView;
//import net.snortum.javafx.multiscene.view.ViewOne;
//import net.snortum.javafx.multiscene.view.ViewThree;
//import net.snortum.javafx.multiscene.view.ViewTwo;


public class Main extends Application {
	
	/** Holds the various scenes to switch between */
	private static Map<SceneName, Scene> scenes = new HashMap<>();
	static GardenModel model;
	
	static ViewSurround surron;
	static ViewSeason season;
	
	@Override
	public void start(Stage stage) {
		 model= new GardenModel();
		 surron = new ViewSurround(stage);
		 season = new ViewSeason(stage);
		// Create and store all scenes up front
		scenes.put(SceneName.ViewWelcome, new ViewWelcome(stage).getScene());
		scenes.put(SceneName.ViewExample, new ViewExample(stage).getScene());
//		scenes.put(SceneName.ViewPwork, new ViewPwork(stage).getScene());
		scenes.put(SceneName.ViewCharacteristics, new ViewCharacteristics(stage).getScene());
		scenes.put(SceneName.ViewTrees, new ViewTrees(stage).getScene());
		scenes.put(SceneName.ViewFlowers, new ViewFlowers(stage).getScene());
		scenes.put(SceneName.ViewFences, new ViewFences(stage).getScene());
		scenes.put(SceneName.ViewDrag, new ViewDrag(stage).getScene());
		scenes.put(SceneName.ViewSurround, surron.getScene());
		scenes.put(SceneName.ViewSeason, season.getScene());
//		scenes.put(SceneName.ViewRating, new ViewRating(stage).getScene());

		// Start with the main scene
		stage.setScene(scenes.get(SceneName.ViewWelcome));
		stage.setTitle("G14 Garden Design");
		stage.show();
	}

	/** Returns a Map of the scenes by {@link SceneName} */
	public static Map<SceneName, Scene> getScenes() {
		return scenes;
	}
	
	
	
	public static ViewSurround getSurron() {
		return surron;
	}

	public static ViewSeason getseason() {
		return season;
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
