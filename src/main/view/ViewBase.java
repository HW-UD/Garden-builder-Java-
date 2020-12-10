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

/** The parents class for each views
 * 
 * @author Benny Li,  Huawei Wang, yuzu Wu,Ruiheng Xie,
 * @version final*/
public class ViewBase implements ViewMaker {

	private Stage stage;//The main stage for each children views
	protected EventHandler<? super MouseEvent> handlerP;//The EventHandler for back button
	protected EventHandler<? super MouseEvent> handlerN;//The EventHandler for next button
	protected final double WIDTH = 1000;//The width for the application
	protected final double HEIGHT = 600;//The height for the application

	protected final int imgwidth = 100;//The width for the imgs
	protected final int imgheight = 100;//The height for the imgs
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
	
	/**
	  * Give imgs attributes in the Vbox
	  * 
	  * @param i, Plantbox
	  *  PLants i: plants from the plants bank
	  *  Vbox Plantbox: the vbox on the left side in Viewdrag
	  * @return None
	  * @author Huawei Wang 
	  * @version Final
	  */
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
	
	/**
	  * Load imgs to the Vbox
	  * 
	  * @param i, Plantbox, in
	  *  PLants i: plants from the plants bank
	  *  Vbox Plantbox: the vbox on the left side in Viewdrag
	  *  in:swtich for each cases
	  * @return None
	  * @author Huawei Wang, BennyLi
	  * @version Final
	  */
	public void paneimgLoading(Plants i, Pane Plantbox,int in) {
		GardenImgView iv1 = new GardenImgView();
		iv1.setID(i.getSpecies());	
		iv1.setPreserveRatio(false);
		double H = 0;//Scaler for the plants
		for (Plants pl: Main.getModel().getPlantBank()) {
			if (pl.getSpecies().equals(i.getSpecies())){
				H = pl.getSize();
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
    	DragController.move(iv1);
		DragController.delete (iv1,Plantbox);
	
	}
	
	
	/**
	  * Set imgs size and location to the Vbox
	  * 
	  * @param i, Plantbox
	  *  PLants i: plants from the plants bank
	  *  Vbox Plantbox: the vbox on the left side in Viewdrag
	  * @return None
	  * @author Huawei Wang, BennyLi
	  * @version Final
	  */
	public void paneimg(Plants i, Pane Plantbox) {

		GardenImgView iv1 = new GardenImgView();
		iv1.setID(i.getSpecies());
		GardenImage img;
		for (Plants pl:Main.getModel().getPlantBank()) {
			if (pl.getSpecies().equals(i.getSpecies())){
				iv1.setImage(pl.getImgSummer());
			}
		}
		Plantbox.getChildren().add(iv1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(imgheight);
    	iv1.setFitWidth(imgwidth);
    	iv1.setTranslateX(i.getPlantx());
    	iv1.setTranslateY(i.getPlanty());
	}

	/**
	  * Show the stages for the childrenViews and catch the null stages
	  * 
	  * @param stage, HandlerP, HandlerN
	  *  Stage stage: stage for ChildrenVIews
	  *  EventHanddler HandlerP: back button for each page 
	  *  EventHanddler HandlerN: next button for each page 
	  * @return None
	  * @author Huawei Wang, BennyLi
	  * @version Final
	  */
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

	/**
	  * Scene of the buttons below each pages.
	  * 
	  * @param None
	  * @return scene
	  * @author BennyLi,Huawei Wang,yuzu Wu,Ruiheng Xie, 
	  * @version Final
	  */
	@Override
	public Scene getScene() {
		BorderPane root = new BorderPane();		
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
}
