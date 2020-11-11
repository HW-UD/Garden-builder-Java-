package view;
import java.awt.MouseInfo;
import java.awt.Point;

import controller.DragController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
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
	private ImageView iv1 = new ImageView();/////////要改
	private final int imgwidth = 100;
	private final int imgheight = 100;
	
	@Override
	public Scene getScene() {
		BorderPane root = new BorderPane();
		
    	TilePane tilepane = new TilePane();
        FlowPane flowpane = new FlowPane();
        tilepane.setStyle("-fx-background-color : #7CFC00;");
        flowpane.setStyle("-fx-background-color : #8B4513;");
    	HBox hbox = new HBox();
    	VBox vbox = new VBox();
    	root.setTop(hbox);
    	root.setRight(vbox);
    	root.setCenter(flowpane);
    	root.setLeft(tilepane);
    	
 
    	Image im1 = new Image(getClass().getResourceAsStream("commonMilkweed.png"));
    	iv1.setImage(im1);
    	tilepane.getChildren().add(iv1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(imgheight);
    	iv1.setFitWidth(imgwidth);
		
		
		
//		root.setPadding(new Insets(10));
//		Label label = new Label("Drag");
//		label.setFont(new Font(32));
//		root.setCenter(label);
		
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);

		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);

		iv1.setOnDragDetected(new EventHandler<MouseEvent>(){
    		@Override
    		public void handle(MouseEvent event){
    			Dragboard iv2 = iv1.startDragAndDrop(TransferMode.COPY);
    			ClipboardContent content = new ClipboardContent();
    			content.putImage(iv1.getImage());
    			iv2.setContent(content);
    			WritableImage wi = new WritableImage(imgwidth,imgheight);
    			iv1.snapshot(new SnapshotParameters(), wi);
    			iv2.setDragView(wi);   		

    		}
    	});
    	
    	flowpane.setOnDragDropped(new EventHandler<DragEvent>() {
    		@Override
    		public void handle(DragEvent event) {
    			ImageView iv1copy = new ImageView(event.getDragboard().getImage());
    			iv1copy.setPreserveRatio(true);
    			iv1copy.setFitHeight(imgheight);
    			iv1copy.setFitWidth(imgwidth);
    			

    			flowpane.getChildren().add(iv1copy);
    			
//    			Point p = MouseInfo.getPointerInfo().getLocation();
//
//    			iv1copy.setTranslateX(p.getX()- 550);
//    			iv1copy.setTranslateY(p.getY());//
    			
    			iv1copy.setTranslateX(event.getX());
    			iv1copy.setTranslateY(event.getY());
    		}
    	});
    	
    	flowpane.setOnDragOver(new EventHandler<DragEvent>() {
    		@Override
    		public void handle(DragEvent event) {
    			event.acceptTransferModes(TransferMode.COPY);
    		}
    	});
		
		
		
		return new Scene(root, WIDTH, HEIGHT);
	}
	
	
	
	/** Must inject a stage */
	public ViewDrag(Stage stage) {
		super(stage, e -> new DragController(stage).handleMousePress(e), e -> new DragController(stage).handleMousePress2(e));
	}

}
