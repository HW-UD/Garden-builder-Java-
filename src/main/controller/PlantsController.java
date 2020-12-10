package controller;

import javafx.event.Event;
import javafx.stage.Stage;
import model.SceneName;
/** The controller for ViewPLant
 * 
 * @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu
 * @version final */
public class PlantsController {
private Stage stage;
  /** Inject the stage from {@link Main} 
 * 
* @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu
* @version final */

	public PlantsController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		this.stage = stage;
	}
	
	/** Display ViewWelcome scene when the "next" button is clicked 
	 * @param event
	 * 
	 * @author Benny Li,  Huawei Wang, Ruiheng Xie, Yuzu Wu
	 * @version final*/
	public void handleMousePress(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewWelcome));
	}
		
	/** Display ViewDrag scene when the "Previous Work" button is clicked 
	 * @param event
	 * 
	 * @author Benny Li,  Huawei Wang, Ruiheng Xie, Yuzu Wu
	 * @version final*/
	public void handleMousePress2(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewDrag));
	}

}