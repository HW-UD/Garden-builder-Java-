package controller;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
import model.SceneName;



public class RatingController {
	private Stage stage;
	
	/** Inject the stage from {@link Main} */
	public RatingController(Stage stage) {
		this.stage = stage;
	}

	/** Display the first scene */
	public void handleOnPressButton1(MouseEvent event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewSeason));
	}
}
