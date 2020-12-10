package controller;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.SceneName;


/** The controller for RatingController
 * 
 * @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu
 * @version final */
public class RatingController {
	private Stage stage;
	
	/** Inject the stage from {@link Main} */
	public RatingController(Stage stage) {
		this.stage = stage;
	}

	/** Display the first scene */
	public void handleOnPressButton1(MouseEvent event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewDrag));
		Main.getViewRating().getV().getChildren().clear();
	}
}