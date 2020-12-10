package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import controller.Main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
    BufferedImage bufferedImage = new BufferedImage(550, 400, BufferedImage.TYPE_INT_ARGB);

	public void saveSize(TextField SaNameInput) {
		try {
		String savedName=SaNameInput.getText();
		String path=WorkPath+ "/src/main/Saved/";
		
		
        FileOutputStream fos = new FileOutputStream(path+savedName+ ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        ArrayList WidthAdLength=new ArrayList();
        
        WidthAdLength.add(Main.getModel().getGarden().getGardenHeight());
        WidthAdLength.add(Main.getModel().getGarden().getGardenLength());

        oos.writeObject(WidthAdLength);
        oos.close();
		}catch(Exception ex){}
		
	}
	
	
	public void saveAsPng(String savedName) {

	       WritableImage snapshot = Main.getDrag().getMiddle().snapshot(new SnapshotParameters(), null);

           BufferedImage image;
           image = javafx.embed.swing.SwingFXUtils.fromFXImage(snapshot, bufferedImage);
           try {
               Graphics2D gd = (Graphics2D) image.getGraphics();
               int WandH=200;
               gd.translate(WandH, WandH);
               File file=new File(WorkPath+"/src/main/Saved/"+savedName+".png");
               ImageIO.write(image, "png", file);
           } catch (IOException ex) {
//               Logger.getLogger(TrySnapshot.class.getName()).log(Level.SEVERE, null, ex);
           };
           
		
	}
	

	

	public void display(String title , String message){
	    Stage window = new Stage();
	    window.setTitle("Save");
	    window.initModality(Modality.APPLICATION_MODAL);
	    window.setMinWidth(300);
	    window.setMinHeight(150);


		Label Name = new Label("Name: ");
		TextField SaNameInput = new TextField ();
		Name.setFont(Font.font ("Verdana", 20));

	    Button button = new Button("Close");
	    button.setOnAction(e -> window.close());

		Button saveButton = new Button("Save");
		saveButton.setOnAction( new EventHandler<ActionEvent>() {


        	public void handle(ActionEvent e) {
        		try{
        			String savedName=SaNameInput.getText();
        			String path=WorkPath+ "/src/main/Saved/";
        			//String path = "file:src/main/Saved/";
        			
        			
                    FileOutputStream fos = new FileOutputStream(path+savedName+ ".dat");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    
                    
                    oos.writeObject(Main.getModel().getGarden().getGarden_Plants());
                    oos.close();
                    saveAsPng(savedName);
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