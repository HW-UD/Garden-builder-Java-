package view;



import java.io.File;
import java.util.HashSet;

import controller.DragController;
import controller.Main;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Plants;

//import net.snortum.javafx.multiscene.Main;

public class ViewBase implements ViewMaker {

	private Stage stage;
	protected EventHandler<? super MouseEvent> handlerP;
	protected EventHandler<? super MouseEvent> handlerN;
	protected final double WIDTH = 1000;
	protected final double HEIGHT = 600;

	protected final int imgwidth = 100;
	protected final int imgheight = 100;
	static HashSet <GardenImage> plants_img = new HashSet();

	Pane middle;
	
	
	
	public double getWIDTH() {
		return WIDTH;
	}


	public double getHEIGHT() {
		return HEIGHT;
	}


	public Pane getMiddle() {
		return middle;
	}


	public void setMiddle(Pane middle) {
		this.middle = middle;
	}
	public void paneimg(Plants i, VBox Plantbox) {

		GardenImgView iv1 = new GardenImgView();
		iv1.setID(i.getImgSpring().getID());
		iv1.setImage(i.getImgSpring());
		Plantbox.getChildren().add(iv1);
		iv1.setPreserveRatio(true);
		iv1.setFitHeight(imgheight);
		iv1.setFitWidth(imgwidth);
		DragController.drag(iv1);
	}
	
	public void paneimgLoading(Plants i, Pane Plantbox,int in) {

		GardenImgView iv1 = new GardenImgView();
		iv1.setID(i.getSpecies());
		
		
		iv1.setPreserveRatio(false);
		double H=0;
		for (Plants pl: Main.getModel().getPlantBank()) {
			if (pl.getSpecies().equals(i.getSpecies())){
				H=pl.getSize();
				switch(in) {
				case 1:
					iv1.setImage(pl.getImgSpring());
					break;
				case 2:
					iv1.setImage(pl.getImgSummer());
					break;
				case 3:
					iv1.setImage(pl.getImgFall());
					break;
				case 4:
					iv1.setImage(pl.getImgWinter());
					break;
				}

			}
		}
		Plantbox.getChildren().add(iv1);
		
		double WindowH=Main.getDrag().getHEIGHT();
		double GHight=Main.getModel().getGarden().getGardenHeight();
		Double scaled=(WindowH/GHight)*H;
		
		System.out.println(WindowH+"/"+GHight+" = "+scaled);
		
		iv1.setFitHeight(scaled);
		iv1.setFitWidth(100);
		
    	iv1.setTranslateX(i.getPlantx());
    	iv1.setTranslateY(i.getPlanty());
		iv1.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
			//	System.out.println("setonmouseDrag");
				Node n = (Node)event.getSource();

				n = (Node) event.getSource(); 
			    n.setTranslateX(n.getTranslateX() + event.getX()); 
			    n.setTranslateY(n.getTranslateY() + event.getY());		
			}
			
		});
		DragController.delete (iv1,Plantbox);
	
	}
	
	public void paneimg(Plants i, Pane Plantbox) {

		GardenImgView iv1 = new GardenImgView();
		iv1.setID(i.getSpecies());
		
		GardenImage img;
		for (Plants pl:Main.getModel().getPlantBank()) {
			if (pl.getSpecies().equals(i.getSpecies())){
				iv1.setImage(pl.getImgSummer());//FIXME

			}
		}

		Plantbox.getChildren().add(iv1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(imgheight);
    	iv1.setFitWidth(imgwidth);
    	iv1.setTranslateX(i.getPlantx());
    	iv1.setTranslateY(i.getPlanty());
	}


	public ViewBase(Stage stage, EventHandler<? super MouseEvent> handlerP,EventHandler<? super MouseEvent> handlerN) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		if (handlerP == null) {
			throw new IllegalArgumentException("Handler cannot be null");
		}
		
		this.stage = stage;
		this.handlerP = handlerP;
		this.handlerN = handlerN;
	}

	@Override
	public Scene getScene() {
		BorderPane root = new BorderPane();
////		root.setPadding(new Insets(10));
//		Label label = new Label(labelText);
//		label.setFont(new Font(32));
//		root.setCenter(label);
		
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);
//		Button closeButton = new Button("Close");
//		closeButton.setOnMousePressed(e -> stage.close());
		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);

		return new Scene(root, WIDTH, HEIGHT);
	}
}
