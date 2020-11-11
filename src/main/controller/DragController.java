package controller;

import javafx.event.Event;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.SceneName;


import java.awt.MouseInfo;
import java.awt.Point;

import controller.DragController;
import javafx.event.EventHandler;

import javafx.scene.SnapshotParameters;

import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;


public class DragController {
	
	private Stage stage;
	
	/** Must inject a stage */
	public DragController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		this.stage = stage;
	}
	
	/** Display ViewFences scene when the "back" button is clicked */
	public void handleMousePress(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewFences));
	}
	
	public void handleMousePress2(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewSurround));
	}
	
	
	public void drag(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewSurround));
	}
	
	public static void drag (ImageView iv1) {
		
		iv1.setOnDragDetected(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event){
				Dragboard iv2 = iv1.startDragAndDrop(TransferMode.COPY);
				ClipboardContent content = new ClipboardContent();
				content.putImage(iv1.getImage());
				iv2.setContent(content);
				WritableImage wi = new WritableImage(100,100);
				iv1.snapshot(new SnapshotParameters(), wi);
				iv2.setDragView(wi);   		
			}
		});
	}
	
	public static void drop (FlowPane flowpane) {
		
		flowpane.setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				ImageView iv1copy = new ImageView(event.getDragboard().getImage());
				iv1copy.setPreserveRatio(true);
				iv1copy.setFitHeight(100);
				iv1copy.setFitWidth(100);
				
	
				flowpane.getChildren().add(iv1copy);
				
//				Point p = MouseInfo.getPointerInfo().getLocation();
	//
//				iv1copy.setTranslateX(p.getX()- 550);
//				iv1copy.setTranslateY(p.getY());//
				
				iv1copy.setTranslateX(event.getX());
				iv1copy.setTranslateY(event.getY());
			}
		});
	}

	public static void DragOver (FlowPane flowpane) {
	
	flowpane.setOnDragOver(new EventHandler<DragEvent>() {
		@Override
		public void handle(DragEvent event) {
			event.acceptTransferModes(TransferMode.COPY);
		}
	});
		
	}
}
