package view;



import java.io.File;
import java.util.HashSet;

import controller.Main;
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
import javafx.scene.layout.Pane;
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
	
	
	
	public Pane getMiddle() {
		return middle;
	}


	public void setMiddle(Pane middle) {
		this.middle = middle;
	}



	public void loadImg(String path) {
		
        for (Plants i : Main.getModel().garden.getGarden_Plants()) {
    		System.out.println(i.getSpecies());
    		System.out.println(i.getSpecies());
    		System.out.println(i.getPlantx());
    		System.out.println(i.getPlanty());
    		
    		
    		String fpath = path + i.getSpecies() +".png";//need to be change to i.getspecies;
    		System.out.println(fpath);
    		Image commonMilkweed = new Image(getClass().getResourceAsStream(fpath));
        	/////
    		ImageView iv1 = new ImageView();
        	iv1.setImage(commonMilkweed);
        	middle.getChildren().add(iv1);
        	iv1.setPreserveRatio(true);
        	iv1.setFitHeight(imgheight);
        	iv1.setFitWidth(imgwidth);
        	iv1.setTranslateX(i.getPlantx());
        	iv1.setTranslateY(i.getPlanty());

        	/////
        }
	}
	
	
	
	public void loadFile(String path){        
        File file = new File(path);   // get file list where the path has           
        File[] array = file.listFiles();  // get the folder list   
        System.out.println (array.toString());
        
        for(int i=0;i<array.length;i++){   
            if(array[i].isFile()){   
                // only take file name   
            	if (array[i].getName().endsWith(".png")) {
            		System.out.println("^^^^^" + array[i].getName());   
            		
                    String temp= "../img/spring/" + array[i].getName();
                    System.out.println("000000" + temp);
                    
                    GardenImage img =  new GardenImage(getClass().getResourceAsStream(temp));
                    String pictureName = array[i].getName();
                    String flowerName = pictureName.substring(0, pictureName.indexOf("."));
                    
                    img.setID(flowerName);
                    plants_img.add(img);
            	}

                     	
            	
                
            }else if(array[i].isDirectory()){   
                loadFile(array[i].getPath());   
            }   
        }   
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
