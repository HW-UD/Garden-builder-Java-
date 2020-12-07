package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import controller.Main;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.SceneName;

public class SaveViewbox {
	private Stage stage;
    String WorkPath = System.getProperty("user.dir");

	
	public void saveAsPng() {
		WritableImage writableImage = new WritableImage(/*int)getWidth()+ (int)getHeight() + */100,
                100);
		WritableImage image = Main.getScenes().get(SceneName. ViewDrag).snapshot(writableImage);
		
		String path= WorkPath+ "/src/main/Saved/";
		// TODO: probably use a file chooser here
//		File file = new File(path + "chart.png");
		File file = new File("chart.png");
		
	    try {
	        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
	    } catch (IOException e) {
	    	// TODO: handle exception here
	    }
	}
	
	
	public void captureAndSaveDisplay(TextField SaNameInput){
//	    FileChooser fileChooser = new FileChooser();
//
//	    //Set extension filter
//	    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
//
//	    //Prompt user to select a file
//	    File file = fileChooser.showSaveDialog(null);
		
		
// 	    File file = fileChooser.showSaveDialog(null);
//
//		
//	    if(file != null){
	        try {
	        	
	        	
	            //Pad the capture area
	            WritableImage writableImage = new WritableImage(/*int)getWidth()+ (int)getHeight() + */100,
	                    100);
	    		Main.getScenes().get(SceneName. ViewDrag).snapshot(writableImage);
	            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
	            
	            
	    		String savedName=SaNameInput.getText();
	    		
	    		String path= WorkPath + "/src/main/Saved/";
	    		
	    		FileOutputStream fos = new FileOutputStream(path+savedName+ ".png");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(renderedImage);
	            oos.close();
	            
	            //Write the snapshot to the chosen file
//	            ImageIO.write(renderedImage, "png", file);
	        } catch (IOException ex) { ex.printStackTrace(); }
//	    }
	}
	

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
        			String path=WorkPath+ "/src/main/Saved/";
        			//String path = "file:src/main/Saved/";
        			
        			
                    FileOutputStream fos = new FileOutputStream(path+savedName+ ".dat");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    
                    System.out.println("#################");
                    System.out.println(Main.getModel().getGarden().getGarden_Plants());
                    
                    oos.writeObject(Main.getModel().getGarden().getGarden_Plants());
                    oos.close();
//                    saveAsPng();
                    window.close();
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