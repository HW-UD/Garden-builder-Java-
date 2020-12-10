package controller;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
//import net.snortum.javafx.multiscene.Main;
//import net.snortum.javafx.multiscene.model.SceneName;
import model.SceneName;
import view.ViewWelcome;

public class WelcomeController {
	private Stage stage;
	
	/** Inject the stage from {@link Main} */
	public WelcomeController(Stage stage) {
		this.stage = stage;
	}

	/** Display the first scene */
	public void handleOnPressButton1(MouseEvent event) {
//		try {
//			
//		}catch(){
//			
//		}
		
		Main.model.getGarden().setGardenLength(Double.parseDouble(ViewWelcome.getWidthtf().getText()));
		Main.model.getGarden().setGardenHeight(Double.parseDouble(ViewWelcome.getLengthtf().getText()));
		
//		Main.getScenes().get(SceneName.ViewDrag).setHight();
//		
//		double imgwidth=100;
//		stage.setWidth(Double.parseDouble(ViewWelcome.getWidthtf().getText())*30+imgwidth + 30);
//		stage.setHeight(Double.parseDouble(ViewWelcome.getLengthtf().getText())*30);
		stage.setScene(Main.getScenes().get(SceneName.Viewplants));
	}
	
//	/** Display the second scene */
//	public void handleOnPressButton2(MouseEvent event) {
//		stage.setScene(Main.getScenes().get(SceneName.ViewExample));
//	}
//	
	/** Display the third scene */
	public void handleOnPressButton3(MouseEvent event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewPwork));
	}
	
}
