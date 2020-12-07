package controller;

import javafx.event.Event;
import javafx.stage.Stage;
import model.SceneName;

public class FencesController {
private Stage stage;
	
	public FencesController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		this.stage = stage;
	}
	public void handleMousePress(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewWelcome));
	}
			
	public void handleMousePress2(Event event) {
		stage.setScene(Main.getScenes().get(SceneName. ViewDrag));
	}

}
