package controller;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.SceneName;
import view.ViewWelcome;

/** The controller for ViewWelcome
 * 
 * @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu
 * @version final */
public class WelcomeController {
	private Stage stage;
	
	/** Inject the stage from {@link Main} 
     * 
    * @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu
    * @version final */
	public WelcomeController(Stage stage) {
		this.stage = stage;
	}

	/** Display ViewPlants scene when the "next" button is clicked 
	 * @param event
	 * 
	 * @author Benny Li,  Huawei Wang, Ruiheng Xie, Yuzu Wu
	 * @version final*/
	public void handleOnPressButton1(MouseEvent event) {	
		Main.model.getGarden().setGardenLength(Double.parseDouble(ViewWelcome.getWidthtf().getText()));
		Main.model.getGarden().setGardenHeight(Double.parseDouble(ViewWelcome.getLengthtf().getText()));
		stage.setScene(Main.getScenes().get(SceneName.Viewplants));
	}
	
	/** Display ViewPwork scene when the "Previous Work" button is clicked 
	 * @param event
	 * 
	 * @author Benny Li,  Huawei Wang, Ruiheng Xie, Yuzu Wu
	 * @version final*/
	public void handleOnPressButton3(MouseEvent event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewPwork));
	}
	
}
