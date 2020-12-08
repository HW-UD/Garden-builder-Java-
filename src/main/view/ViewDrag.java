package view;
import java.awt.MouseInfo;
import java.awt.Point;
import controller.DragController;
import controller.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Stage;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;


public class ViewDrag extends ViewBase {

	@Override
	public Scene getScene() {
		BorderPane root = new BorderPane();
		GraphicsContext gc;
	    Canvas canvas = new Canvas(WIDTH, HEIGHT);
		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		
    	TilePane tilepane = new TilePane();
        middle = new Pane();
        tilepane.setStyle("-fx-background-color : #7CFC00;");
        //flowpane.setStyle("-fx-background-color : #8B4513;");
        
        Button circleButton = new Button("Circle");
        circleButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		Image background = new Image(getClass().getResourceAsStream("../img/default/tudicircle.png"));
                gc.drawImage(background, 0, 0, WIDTH, HEIGHT);
        	}	
        });
        
        Button squareButton = new Button("Square");
        squareButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		Image background = new Image(getClass().getResourceAsStream("../img/default/tudi.jpg"));
                gc.drawImage(background, 0, 0, WIDTH, HEIGHT);
        	}	
        });
        
//        Image background = new Image("file:src/main/img/default/tudi.jpg");
//        Polygon p2 = new Polygon();
//        
//        p2.setLayoutX(100);
//        p2.setLayoutY(120);
//        p2.getPoints().add(50.0);
//        p2.getPoints().add(0.0);
//        p2.getPoints().add(100.0);
//        p2.getPoints().add(100.0);
//        p2.getPoints().add(0.0);
//        p2.getPoints().add(100.0);
//        
//        p2.setFill(new ImagePattern(background, 0, 0, 500, 1000, false));
//        
//        flowpane.getChildren().add(p2);

       	
        tilepane.setPrefWidth(imgwidth+30);
        tilepane.setPrefHeight(imgheight+600);
        tilepane.setPrefColumns(1);
        
        
        
        ChoiceBox<String> light = new ChoiceBox<String>();
        light.getItems().addAll("light glare","light medium","light weak");
        tilepane.getChildren().addAll(light);
        ChoiceBox<String> water = new ChoiceBox<String>();
        water.getItems().addAll("water large","water medium","water little");
        tilepane.getChildren().add(water);
        
	
    	

	        String WorkPath = System.getProperty("user.dir");
    		
    		loadFile(WorkPath+"/src/main/img/spring");
        	for (GardenImage i: plants_img) {
        		GardenImgView iv1 = new GardenImgView();
        		iv1.setID(i.getID());
            	iv1.setImage(i);
            	tilepane.getChildren().add(iv1);
            	iv1.setPreserveRatio(true);
            	iv1.setFitHeight(imgheight);
            	iv1.setFitWidth(imgwidth);
            	DragController.drag (iv1);
        	}
   
        

        
        ScrollPane scrollPane = new ScrollPane(tilepane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.setLeft(scrollPane);

    	root.setCenter(middle);
  

    	DragController.drop (middle) ;
    	DragController.DragOver (middle) ;
    	
		
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);
		

		Button saveButton = new Button("Save");  
		  saveButton.setOnAction(e -> new SaveViewbox().display("title", "message"));
		  
		Button clear = new Button("Clear");
			EventHandler<ActionEvent> Clearevent = new EventHandler<ActionEvent>() {
				   public void handle(ActionEvent e) {
				    middle.getChildren().clear();
				   }
				  };

				  clear.setOnAction(Clearevent);
		  
		  
		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(clear,squareButton,circleButton,saveButton,backButton, nextButton);
		root.setBottom(bbar);
		
		
		middle.addEventHandler(MouseEvent.MOUSE_PRESSED, 
                new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                gc.beginPath();
                gc.moveTo(event.getX(), event.getY());
                gc.stroke();
            }
        });

        middle.addEventHandler(MouseEvent.MOUSE_DRAGGED, 
                new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                gc.lineTo(event.getX(), event.getY());
                gc.stroke();
            }
        });

        middle.addEventHandler(MouseEvent.MOUSE_RELEASED, 
                new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {

            }
        });
       
//        private void initDraw (GraphicsContext gc){
//            double canvasWidth = gc.getCanvas().getWidth();
//            double canvasHeight = gc.getCanvas().getHeight();
//
//            gc.setFill(Color.LIGHTGRAY);
//            gc.setStroke(Color.BLACK);
//            gc.setLineWidth(5);
//
//            gc.fill();
//            gc.strokeRect(
//                    0,              //x of the upper left corner
//                    0,              //y of the upper left corner
//                    canvasWidth,    //width of the rectangle
//                    canvasHeight);  //height of the rectangle
//
//            gc.setFill(Color.RED);
//            gc.setStroke(Color.BLUE);
//            gc.setLineWidth(1);
//
//        }

		
		
		
		return new Scene(root, WIDTH, HEIGHT);
	}
	
	public FlowPane getFlower() {
		return null;
	}
	
	
	/** Must inject a stage */
	public ViewDrag(Stage stage) {
		super(stage, e -> new DragController(stage).handleMousePress(e), e -> new DragController(stage).handleMousePress2(e));
	}

}
