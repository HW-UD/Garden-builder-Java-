package view;
import controller.DragController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class ViewDrag extends ViewBase {

//	public ViewDrag(Stage stage, EventHandler<? super MouseEvent> handlerP, EventHandler<? super MouseEvent> handlerN) {
//		super(stage, handlerP, handlerN);
//		// TODO Auto-generated constructor stub
//	}
	private ImageView iv1;
	private final int imgwidth = 100;
	private final int imgheight = 100;
	
	public Scene getScene() {
		BorderPane borderpane = new BorderPane();
		
//    	TilePane tilepane = new TilePane();
//        FlowPane flowpane = new FlowPane();
//        tilepane.setStyle("-fx-background-color : #7CFC00;");
//        flowpane.setStyle("-fx-background-color : #8B4513;");
//    	HBox hbox = new HBox();
//    	VBox vbox = new VBox();
//    	borderpane.setTop(hbox);
//    	borderpane.setRight(vbox);
//    	borderpane.setCenter(flowpane);
//    	borderpane.setLeft(tilepane);
//    	
// 
//    	Image im1 = new Image(getClass().getResourceAsStream("commonMilkweed.png"));
//    	iv1.setImage(im1);
//    	tilepane.getChildren().add(iv1);
//    	iv1.setPreserveRatio(true);
//    	iv1.setFitHeight(imgheight);
//    	iv1.setFitWidth(imgwidth);
		
	   BorderPane root = new BorderPane();
		
		root.setPadding(new Insets(10));
		Label label = new Label("drag");
		label.setFont(new Font(32));
		root.setCenter(label);
		
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);
//		Button closeButton = new Button("Close");
//		closeButton.setOnMousePressed(e -> stage.close());
		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		borderpane.setBottom(bbar);

		return new Scene(borderpane, WIDTH, HEIGHT);
	}
	
	
	
	/** Must inject a stage */
	public ViewDrag(Stage stage) {
		super(stage, e -> new DragController(stage).handleMousePress(e), e -> new DragController(stage).handleMousePress2(e));
	}

}
