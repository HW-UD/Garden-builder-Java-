package view;



import java.io.File;
import java.util.HashSet;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//import net.snortum.javafx.multiscene.Main;

public class ViewBase implements ViewMaker {

	private Stage stage;
	protected EventHandler<? super MouseEvent> handlerP;
	protected EventHandler<? super MouseEvent> handlerN;
	protected final double WIDTH = 800;
	protected final double HEIGHT = 600;
	
	static HashSet <Image> plants_img = new HashSet();

	
	public void getFile(String path){        
        File file = new File(path);   // get file list where the path has           
        File[] array = file.listFiles();  // get the folder list   
        System.out.println (array.toString());
        
        for(int i=0;i<array.length;i++){   
            if(array[i].isFile()){   
                // only take file name   
            	if (array[i].getName().endsWith(".jpg")) {
            		System.out.println("^^^^^" + array[i].getName());   
            		
                    String temp= "../img/spring/" + array[i].getName();
                    System.out.println("000000" + temp);
                    
                    Image img =  new Image(getClass().getResourceAsStream(temp));
                    plants_img.add(img);
            	}
                
                
            }else if(array[i].isDirectory()){   
                getFile(array[i].getPath());   
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
