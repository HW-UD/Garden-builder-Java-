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

//TODO may put button other place.
		
		bbar.getButtons().addAll(SpringButton, SummerButton,FallButton,WinterButton,backButton, nextButton);
		root.setBottom(bbar);
		
		SpringButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		middle.getChildren().clear();
        		loadImg("../img/spring/");
        	}	
        });
		
		SummerButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		middle.getChildren().clear();
        		loadImg("../img/summer/");
        	}	
        });
		
		FallButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		middle.getChildren().clear();

        		loadImg("../img/fall/");
        	}	
        });
		
		WinterButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		middle.getChildren().clear();
        		loadImg("../img/winter/");
        	}	
        });
		
		
		 
		
		return new Scene(root, WIDTH, HEIGHT);
	}
	
	
	
	/** Must inject a stage */
	public ViewSeason(Stage stage) {
		super(stage, e -> new SeasonController(stage).handleMousePress(e), e -> new SeasonController(stage).handleMousePress2(e));
	}
	
}
