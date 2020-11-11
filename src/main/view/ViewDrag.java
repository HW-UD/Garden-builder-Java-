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


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;






public class ViewDrag extends ViewBase {

//	public ViewDrag(Stage stage, EventHandler<? super MouseEvent> handlerP, EventHandler<? super MouseEvent> handlerN) {
//		super(stage, handlerP, handlerN);
//		// TODO Auto-generated constructor stub
//	}
	private final int imgwidth = 100;
	private final int imgheight = 100;
	static HashSet <Image> plants_img = new HashSet();

	
	private void getFile(String path){        
        File file = new File(path);   // get file list where the path has           
        File[] array = file.listFiles();  // get the folder list   
        System.out.println (array.toString());
        
        for(int i=0;i<array.length;i++){   
            if(array[i].isFile()){   
                // only take file name   
            	if (array[i].getName().endsWith(".jpg")) {
            		System.out.println("^^^^^" + array[i].getName());   
            		
                    String temp= "../img/spring/" + array[i].getName();
                    System.out.println("000000" + temp);
                    
                    Image img =  new Image(getClass().getResourceAsStream(temp));
                    plants_img.add(img);
            	}
                
                
            }else if(array[i].isDirectory()){   
                getFile(array[i].getPath());   
            }   
        }   
    }   

	@Override
	public Scene getScene() {
//		DragController contr= new DragController(stage);
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
  
    	getFile("/Users/wanghuawei/eclipse-workspace/project-team-14/src/main/img/spring");
    	for (Image i: plants_img) {
    		ImageView iv1 = new ImageView();
        	iv1.setImage(i);
        	tilepane.getChildren().add(iv1);
        	iv1.setPreserveRatio(true);
        	iv1.setFitHeight(imgheight);
        	iv1.setFitWidth(imgwidth);
        	DragController.drag (iv1);
    	}
    	DragController.drop ( flowpane) ;
    	DragController.DragOver ( flowpane) ;
    	
		
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);
		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);

		
		
		
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


////Image im1 = new Image(getClass().getResourceAsStream("../img/commonMilkweed.png"));
//String temp= "/Users/wanghuawei/eclipse-workspace/project-team-14/src/main/img"+ "/" + "AmericanBasswood.png";
////String temp= "../img/AmericanBasswood.png";
//Image img =  new Image(getClass().getResourceAsStream(temp));
//ImageView iv1 = new ImageView();/////////要改
//iv1.setImage(img);
//tilepane.getChildren().add(iv1);
//iv1.setPreserveRatio(true);
//iv1.setFitHeight(imgheight);
//iv1.setFitWidth(imgwidth);