package view;

import controller.SeasonController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewSeason extends ViewBase {
	
	//	public ViewDrag(Stage stage, EventHandler<? super MouseEvent> handlerP, EventHandler<? super MouseEvent> handlerN) {
	//	super(stage, handlerP, handlerN);
	//	// TODO Auto-generated constructor stub
	//}
	
	

	public Scene getScene() {
		BorderPane root = new BorderPane();
	    GraphicsContext gc;

        Canvas canvas = new Canvas(WIDTH, HEIGHT);

        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();


        middle = new Pane();
        middle.setStyle("-fx-background-color: #8B4513;");
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

		
		Button SpringButton = new Button("Spring");
		Button SummerButton = new Button("Summer");
		Button FallButton = new Button("Fall");
		Button WinterButton = new Button("Winter");

//		ButtonBar surrbar = new ButtonBar();
//		surrbar.getButtons().addAll(SpringButton, SummerButton,FallButton,WinterButton);
//		root.setBottom(surrbar);
//		root.getChildren().addAll(SpringButton, SummerButton,FallButton,WinterButton);
		bbar.getButtons().addAll(SpringButton, SummerButton,FallButton,WinterButton,backButton, nextButton);
		root.setBottom(bbar);
		
		SpringButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		inputImg("../img/spring/");
        	}	
        });
		
		SummerButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		inputImg("../img/summer/");
        	}	
        });
		
		FallButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		inputImg("../img/fall/");
        	}	
        });
		
		WinterButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		inputImg("../img/winter/");
        	}	
        });
		
		
		


		Scene returnv = new Scene(root, WIDTH, HEIGHT);
		
		return returnv;
	}
	
	
	
	/** Must inject a stage */
	public ViewSeason(Stage stage) {
		super(stage, e -> new SeasonController(stage).handleMousePress(e), e -> new SeasonController(stage).handleMousePress2(e));
	}
	
}
