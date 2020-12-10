package controller;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.SceneName;

/** The controller for ViewRating
 * 
 * @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu
 * @version final */
public class RatingController {
	private Stage stage;
	
	/**
	 * Inject the stage from {@link Main}
	 * 
	 * @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu
	 * @version final
	 */
	public RatingController(Stage stage) {
		this.stage = stage;
	}

	/** Display ViewDrag scene when the "back" button is clicked 
	 * @param event
	 * 
	 * @author Benny Li,  Huawei Wang, Ruiheng Xie, Yuzu Wu
	 * @version final*/
	public void handleOnPressButton1(MouseEvent event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewDrag));
	}
}
