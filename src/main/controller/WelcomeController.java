package controller;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
import model.SceneName;

public class WelcomeController {
	private Stage stage;
	
	/** Inject the stage from {@link Main} */
	public WelcomeController(Stage stage) {
		this.stage = stage;
	}

	/** Display the first scene */
	public void handleOnPressButton1(MouseEvent event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewCharacteristics));
	}
	
	/** Display the second scene */
	public void handleOnPressButton2(MouseEvent event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewExample));
	}
	
	/** Display the third scene */
	public void handleOnPressButton3(MouseEvent event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewPwork));
	}
	
}
