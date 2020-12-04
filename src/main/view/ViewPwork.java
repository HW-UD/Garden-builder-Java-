package view;


import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ViewPwork extends ViewBase {


	public ViewPwork(Stage stage) {
		super(stage, e -> new PworkController(stage).handleMousePress1(e), e -> new PworkController(stage).handleMousePress2(e));
	}
	
	public Scene getScene() {

		BorderPane root = new BorderPane();
        Label label = new Label("Choose a recent work");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		root.setTop(label);
		BorderPane.setMargin(label, new Insets(5,0,0,350));
        root.setPadding(new Insets(10));
        
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        root.setCenter(flow);
        
        //Deserializing planted.ser
        Button loadButton =  new Button("load");
        loadButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		try{
                    FileInputStream fis = new FileInputStream("planted.ser");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Main.getModel().garden.setGarden_Plants((ArrayList)ois.readObject());               
                    ois.close();
                }
                catch (Exception ex)
        		{}
        	}	
        });
     
        
         
        ButtonBar works = new ButtonBar();
        works.setPadding(new Insets(10, 0, 0, 10));
        works.getButtons().addAll(loadButton);
        flow.getChildren().add(works);
        
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