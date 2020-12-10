package view;


import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import java.net.URL;

import controller.DragController;
import controller.Main;
import controller.PworkController;
import controller.WelcomeController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Plants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class ViewPwork extends ViewBase {
	FlowPane flowpane = new FlowPane();
	BorderPane root = new BorderPane();
    String WorkPath = System.getProperty("user.dir");
	private final double imgwidth = 200;//width of image
	private final double imgheight = 200;//height of image


	public ViewPwork(Stage stage) {
		super(stage, e -> new PworkController(stage).handleMousePress1(e),
				e -> new PworkController(stage).handleMousePress2(e));
	}
	
	
	/**
	 * Load all pastWorks, and generate buttons of them
	 * 
	 * @param
	 * 		String Path: The Path of where previous work located
	 * @return void
	 * @author Huawei Wang
	 * @version Final
	 */
	
	public void loadButtons(String path) {
		
		File file = new File(path); // get file list where the path has
		File[] array = file.listFiles(); // get the folder list

		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {
				
				if (array[i].getName().endsWith(".dat")) {
					final int ButtonLength = 300;//length of button
					final int ButtonWidth = 500;//width of button
					String fileName = array[i].getName();
					String GName = fileName.substring(0, fileName.indexOf("."));
					
					Image im1 = new Image(getClass().getResourceAsStream("../Saved/"+GName+".png"));
					ImageView view1 = new ImageView(im1);
					view1.setFitHeight(imgheight);
					view1.setFitWidth(imgwidth);

					ToggleButton button1 = new ToggleButton(GName, new ImageView(im1));
					button1.setPrefSize(ButtonWidth, ButtonLength);
					button1.setGraphic(view1);
					button1.setStyle(null);
			    	button1.setOnAction(e -> {
				    	try{
					    	ObjectInputStream oisW = new ObjectInputStream(new FileInputStream(path+"/"+GName+".ser"));
					        ArrayList rdObject = (ArrayList) oisW.readObject();
					        
					        double Height=(double )rdObject.get(0);
					        double Width=(double )rdObject.get(1);

					        Main.getModel().getGarden().setGardenHeight(Height);
					        Main.getModel().getGarden().setGardenLength(Width);
					        oisW.close();
					         //   new File("tempdata.ser").delete();
					        }
					        catch (Exception ex){}
//			    		
			    	try{
			    		System.out.println(path + "/"+fileName);
				    	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+"/"+fileName));
				        HashSet readObject = (HashSet) ois.readObject();
				        
		            	Main.getModel().getGarden().setGarden_Plants(readObject);
				        ois.close();
				         //   new File("tempdata.ser").delete();
				        }
				        catch (Exception ex){}
						
			        	});
					
			    	button1.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							button1.setStyle("-fx-background-color: blue;");

						}
					});
			    	
			    	button1.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							button1.setStyle(null);

						}
					});
			    	
					flowpane.getChildren().add(button1);
				}

			} else if (array[i].isDirectory()) {
				loadButtons(array[i].getPath());
			}
		}
	}
	
	
	/**
	 * Scene of the Previous Work page.
	 * 
	 * @param None
	 * @return Scene
	 * @author Huawei Wang,yuzu Wu,Ruiheng Xie, Benny Li 
	 * @version Final
	 */
	public Scene getScene() {
			
			int paddingnum = 10;//number fit for padding
			int fpwidth = 1000;//the width of flowpane
			int labelsize = 32;//size of label

			flowpane.setPrefWidth(fpwidth);

			ScrollPane scrollPane = new ScrollPane(flowpane);
			scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
			root.setCenter(scrollPane);

			root.setPadding(new Insets(paddingnum));
			Label label = new Label("Choose Previous Work");
			label.setFont(new Font("Arial", labelsize));// set the font and the size of the title
			root.setTop(label);

			label.setTextFill(Color.web("#0076a3"));// set the Color of the label

			// Create next and back button
			Button backButton = new Button("Back");
			backButton.setOnMousePressed(handlerP);
			
			Button nextButton = new Button("Next");
			nextButton.setOnMousePressed(handlerN);

			ButtonBar bbar = new ButtonBar();
			bbar.setPadding(new Insets(paddingnum, 0, 0, paddingnum));
			bbar.getButtons().addAll(backButton,nextButton);
			root.setBottom(bbar);


	        System.out.println("Working Directory = " + WorkPath+"/src/main/Saved");
			loadButtons(WorkPath+"/src/main/Saved");

			return new Scene(root, WIDTH, HEIGHT);
        
    }    
}