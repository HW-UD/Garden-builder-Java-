package controller;

import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
import model.SceneName;



public class PworkController {
	private Stage stage;
	
	/** Must inject a stage */
	public PworkController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		this.stage = stage;
	}
	
	/** Display ViewFences scene when the "back" button is clicked */

	public void handleMousePress1(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewWelcome));
	}
	
	public void handleMousePress2(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewDrag));
		System.out.println(Main.getModel().getGarden().getGarden_Plants());
		Main.getDrag().getMiddle().getChildren().clear();
//		Main.getDrag().loadImg("../img/spring/");//FIXME 
	}
}