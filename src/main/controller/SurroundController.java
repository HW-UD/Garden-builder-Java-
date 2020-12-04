package controller;

import javafx.event.Event;
import javafx.stage.Stage;
import model.SceneName;

//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
//import net.snortum.javafx.multiscene.view.ViewThree;


public class SurroundController {
	
	private Stage stage;
	
	/** Must inject a stage */
	public SurroundController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		this.stage = stage;
	}
	
	/** Display ViewFences scene when the "back" button is clicked */
	public void handleMousePress(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewDrag));
	}
	
	public void handleMousePress2(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewSeason));
		Main.getseason().getMiddle().getChildren().clear();
		Main.getseason().loadImg("../img/spring/");//FIXME 
	}
}
