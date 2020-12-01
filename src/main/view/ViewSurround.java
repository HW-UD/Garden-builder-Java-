package view;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.sun.glass.ui.Screen;

import controller.Main;

//import java.awt.Label;

import controller.SurroundController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
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
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Plants;
import model.SceneName;


public class ViewSurround extends ViewBase {
//	Image background;
//	public ViewDrag(Stage stage, EventHandler<? super MouseEvent> handlerP, EventHandler<? super MouseEvent> handlerN) {
//	super(stage, handlerP, handlerN);
//	// TODO Auto-generated constructor stub
//}

	
	
	@Override
	public Scene getScene() {
		BorderPane root = new BorderPane();
	    GraphicsContext gc;

        Canvas canvas = new Canvas(WIDTH, HEIGHT);

        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();


        middle = new Pane();
        //middle.setStyle("-fx-background-color: #8B4513;");
        middle.setPrefSize(400,400);
        root.setCenter(middle);//FIXME I want it set on the center of the scence, but it is not.
        
//        System.out.println("debug");
//        int in=100;

        
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);

		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));

		
		Button RiverButton = new Button("River");
		Button ForestButton = new Button("Forest");
		Button LawnButton = new Button("Lawn");
		Button shrubButton = new Button("shrub");

		
		
//		ButtonBar surrbar = new ButtonBar();
//		surrbar.getButtons().addAll(RiverButton, ForestButton,LawnButton,shrubButton);
//		root.setBottom(surrbar);
//		root.getChildren().addAll(RiverButton, ForestButton,LawnButton,shrubButton);
		bbar.getButtons().addAll(RiverButton, ForestButton,LawnButton,shrubButton,backButton, nextButton);
		root.setBottom(bbar);
		
		RiverButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		Image backgroundimg = new Image(getClass().getResourceAsStream("../img/default/water.jpg"));
                gc.drawImage(backgroundimg, 0, 0, WIDTH, HEIGHT);
        	}	
        });
		
		ForestButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		Image backgroundimg = new Image(getClass().getResourceAsStream("../img/default/forest.jpg"));
                gc.drawImage(backgroundimg, 0, 0, WIDTH, HEIGHT);
        	}	
        });
		
		LawnButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		Image backgroundimg = new Image(getClass().getResourceAsStream("../img/default/grass.jpg"));
                gc.drawImage(backgroundimg, 0, 0, WIDTH, HEIGHT);
        	}	
        });
		
		shrubButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		Image backgroundimg = new Image(getClass().getResourceAsStream("../img/default/shrub.jpg"));
                gc.drawImage(backgroundimg, 0, 0, WIDTH, HEIGHT);
        	}	
        });
		
		
		


		Scene returnv = new Scene(root, WIDTH, HEIGHT);
		
		return returnv;
	}
	
	
	/** Must inject a stage */
	public ViewSurround(Stage stage) {
		
		super(stage, e -> new SurroundController(stage).handleMousePress(e), e -> new SurroundController(stage).handleMousePress2(e));

	}
	
	
}
