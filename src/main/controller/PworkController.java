package controller;

import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Plants;
//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
import model.SceneName;


/** The controller for ViewPwork
 * 
 * @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu
 * @version final */
public class PworkController {
	private Stage stage;
	
	/**
	 * Inject the stage from {@link Main}
	 * 
	 * @author Benny Li, Huawei Wang, Ruiheng Xie, Yuzu Wu
	 * @version final
	 */
	public PworkController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		this.stage = stage;
	}
	
	/** Display ViewPlants scene when the "next" button is clicked 
	 * @param event
	 * 
	 * @author Benny Li,  Huawei Wang, Ruiheng Xie, Yuzu Wu
	 * @version final*/

	public void handleMousePress1(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewWelcome));
	}
	
	/** Display ViewDrag scene when the "next" button is clicked 
	 * @param event
	 * 
	 * @author Benny Li,  Huawei Wang, Ruiheng Xie, Yuzu Wu
	 * @version final*/
	public void handleMousePress2(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewDrag));
		System.out.println(Main.getModel().getGarden().getGarden_Plants());
		Main.getDrag().getMiddle().getChildren().clear();
		for (Plants i: Main.getModel().getGarden().getGarden_Plants()) {
			Main.getDrag().paneimgLoading( i,  Main.getDrag().getMiddle(),1) ;}     
	}


}