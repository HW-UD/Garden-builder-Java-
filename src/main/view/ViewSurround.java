package view;

import com.sun.glass.ui.Screen;

//import java.awt.Label;

import controller.SurroundController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ViewSurround extends ViewBase {
//	Image background;
//	public ViewDrag(Stage stage, EventHandler<? super MouseEvent> handlerP, EventHandler<? super MouseEvent> handlerN) {
//	super(stage, handlerP, handlerN);
//	// TODO Auto-generated constructor stub
//}

	@Override
	public Scene getScene() {
		BorderPane root = new BorderPane();
		
//		FlowPane flowpane = new FlowPane();
//		flowpane.setStyle("-fx-background-color : #8B4513;");
//		root.setCenter(flowpane);
//		Image backgroundimg = new Image(getClass().getResourceAsStream("../img/default/water.jpg"));
////		ImageView iv1 = new ImageView();
////		iv1.setImage(backgroundimg);
////		iv1.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
////		iv1.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
//        // create a background image 
//        BackgroundImage backgroundimage = new BackgroundImage(backgroundimg,  
//                                         BackgroundRepeat.NO_REPEAT,  
//                                         BackgroundRepeat.NO_REPEAT,  
//                                         BackgroundPosition.CENTER,  
//                                         BackgroundSize​(800.0,
//                                                    600.0,
//                                                    false,
//                                                    false,
//                                                    true,
//                                                   false)); 
//
//        // create Background 
//        Background background = new Background(backgroundimage); 

        // set background 
//        root.setBackground(background); 
		
		
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);


		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);

		Scene returnv = new Scene(root, WIDTH, HEIGHT);
		
		return returnv;
	}
	
	
	/** Must inject a stage */
	public ViewSurround(Stage stage) {
		
		super(stage, e -> new SurroundController(stage).handleMousePress(e), e -> new SurroundController(stage).handleMousePress2(e));

	}
	
	
}
