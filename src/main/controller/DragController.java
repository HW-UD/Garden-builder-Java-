package controller;

import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Plants;
import model.SceneName;
import view.GardenImage;
import view.GardenImgView;
import view.ViewSurround;

import java.awt.MouseInfo;
import java.awt.Point;

import controller.DragController;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;

import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;


public class DragController {
	
	private Stage stage;
//	private static Node n;
	static private String name;
	/** Must inject a stage @param*/
	public DragController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		this.stage = stage;
	}
	
	/** Display ViewFences scene when the "back" button is clicked @param*/
	public void handleMousePress(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewWelcome));
	}
	
	public void handleMousePress2(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.ViewSurround));
		Main.getSurron().getMiddle().getChildren().clear();
//		Main.getSurron().loadImg("../img/spring/");//FIXME 
	}
	
	
	
public static String getName() {
		return name;
	}

	public static void setName(String name) {
		DragController.name = name;
	}

	//	
//	public void drag(Event event) {
//		stage.setScene(Main.getScenes().get(SceneName.ViewSurround));
//	}
//	
	
	
	public static void drag (GardenImgView iv1) {
		
		iv1.setOnDragDetected(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event){
				System.out.println(iv1.getID());
				setName(iv1.getID());
				
				Dragboard iv2 = iv1.startDragAndDrop(TransferMode.COPY);
				ClipboardContent content = new ClipboardContent();
				content.putImage(iv1.getImage());///////
				iv2.setContent(content);
				WritableImage wi = new WritableImage(100,100);
				iv1.snapshot(new SnapshotParameters(), wi);
				iv2.setDragView(wi);   		
			}
		});
	}
	
	public static void drop (Pane pane) {
		
		pane.setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				Image i =  event.getDragboard().getImage();

				GardenImgView iv1copy =  new GardenImgView();
				
				iv1copy.setImage(i);
				iv1copy.setID(name);
				iv1copy.setPreserveRatio(false);
				double H=0;
				for (Plants pl: Main.getModel().getPlantBank()) {
					if (pl.getSpecies().equals(name)){
						H=pl.getSize();
					}
				}
				double WindowH=Main.getDrag().getHEIGHT();
				double GHight=Main.getModel().getGarden().getGardenHeight();
				Double scaled=(WindowH/GHight)*H;
				
				System.out.println(WindowH+"/"+GHight+" = "+scaled);
				
				iv1copy.setFitHeight(scaled);
				iv1copy.setFitWidth(100);
				
				
				
	
				pane.getChildren().add(iv1copy);
				
//				Point p = MouseInfo.getPointerInfo().getLocation();
//
//				iv1copy.setTranslateX(p.getX()- 550);
//				iv1copy.setTranslateY(p.getY());//
				
				iv1copy.setTranslateX(event.getX());
				iv1copy.setTranslateY(event.getY());
			//	delete (pane, iv1copy);
				iv1copy.setOnMouseDragged(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
					//	System.out.println("setonmouseDrag");
						Node n = (Node)event.getSource();

						n = (Node) event.getSource(); 
//						delete (pane, n);
					    n.setTranslateX(n.getTranslateX() + event.getX()); 
					    n.setTranslateY(n.getTranslateY() + event.getY());		
					}
				});
				delete (iv1copy,pane);
				Main.model.getGarden().addPlant(iv1copy.getID(), event.getX(), event.getY());
				System.out.println(Main.model.getGarden().getGarden_Plants());
			}
		});
	}
	
	

	
	/*
	 * public static void delete (Pane pane,Node n) { pane.setOnMouseClicked(new
	 * EventHandler<MouseEvent>(){
	 * 
	 * @Override public void handle(MouseEvent event) { if(event.getButton() ==
	 * MouseButton.PRIMARY && event.getClickCount() == 2 && event.getX() >
	 * n.getTranslateX()&& event.getX() < (n.getTranslateX()+100)) {
	 * 
	 * pane.getChildren().remove(n); } } }); }
	 */
	
	public static void delete (GardenImgView iv1copy,Pane pane) {
		iv1copy.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {				
				if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2 /* && event.getX() > n.getTranslateX()&& event.getX() < (n.getTranslateX()+100)*/) {
				
					pane.getChildren().remove(iv1copy);
				}	
			}
		});
	}
	
	
	
	public static void DragOver (Pane flowpane) {
	
	flowpane.setOnDragOver(new EventHandler<DragEvent>() {
		@Override
		public void handle(DragEvent event) {
			event.acceptTransferModes(TransferMode.COPY);
		}
	});
		
	}
}
