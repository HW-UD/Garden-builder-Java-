package controller;

import javafx.event.Event;
import javafx.stage.Stage;
import model.SceneName;

public class ExampleController {
	private Stage stage;
	
	/** Must inject a stage */
	public ExampleController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		this.stage = stage;
	}
	/** Display ViewFences scene when the "back" button is clicked */
	public void handleMousePress(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewWelcome));
	}
	
}
