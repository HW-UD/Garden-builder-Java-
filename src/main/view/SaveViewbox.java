package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import controller.Main;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SaveViewbox {
	
	
	public void display(String title , String message){
	    Stage window = new Stage();
	    window.setTitle("title");
	    window.initModality(Modality.APPLICATION_MODAL);
	    window.setMinWidth(300);
	    window.setMinHeight(150);

	    
		Label Name = new Label("Name: ");
		TextField SaNameInput = new TextField ();
		Name.setFont(Font.font ("Verdana", 20));
//		lengthtf.textProperty().addListener(new ChangeListener<String>() {
//		       @Override
//		       public void changed(ObservableValue<? extends String> observable, String oldValue, 
//		           String newValue) {
//		           if (!newValue.matches("\\d*")) {
//		        	   lengthtf.setText(newValue.replaceAll("[^\\d]", ""));
//		           }
//		       }
//		});
	    
	    
	    
	    Button button = new Button("Close");
	    button.setOnAction(e -> window.close());
	    
		Button saveButton = new Button("Save");
		saveButton.setOnAction( new EventHandler<ActionEvent>() {
			
			
        	public void handle(ActionEvent e) {
        		try{
        			System.out.println("works");
        			String savedName=SaNameInput.getText();
        			String path= "/Users/wanghuawei/eclipse-workspace/project-team-14/src/main/Saved/";
        			//String path = "file:src/main/Saved/";
                    FileOutputStream fos = new FileOutputStream(path+savedName+ ".ser");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(Main.getModel().garden.getGarden_Plants());
                    oos.close();
                }
                catch (Exception ex)
        		{}
        	}	
        	
        	
        });


	    VBox layout = new VBox(10);
	    
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(saveButton,button);
	    
	    layout.getChildren().addAll( bbar,Name,SaNameInput);
//	    layout.setAlignment(Pos.CENTER);

	    
	    
	    




//TODO may put button other place.

	    
	    
	    Scene scene = new Scene(layout);
	    window.setScene(scene);
	    window.showAndWait();
	    
	    
	  
	    }
}