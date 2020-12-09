package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import controller.Main;
import controller.SurroundController;
import controller.WelcomeController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ViewWelcome implements ViewMaker {
	
	private Stage stage;
	
	/** Must inject a stage */
	public ViewWelcome(Stage stage) {
		this.stage = stage;
	}

	@Override
	public Scene getScene() {
		
		// Inject stage from Main into controller
		WelcomeController controller = new WelcomeController(stage);
		

		BorderPane root = new BorderPane();
	
		// set the background
     	Image background = new Image("file:src/main/img/rating/background.png");
     	ImageView bk = new ImageView();
       	bk.setImage(background);
       	root.getChildren().add(bk);
        
		Image img =new Image(getClass().getResourceAsStream("../img/default/welcome.png"));
		ImageView iv1 = new ImageView();
        iv1.setImage(img);
        root.getChildren().add(iv1);
        iv1.setPreserveRatio(true);
        iv1.setTranslateX(iv1.getTranslateX()+80);
        iv1.setTranslateY(iv1.getTranslateY()+90);
        
        
		Label label = new Label("    ");
		label.setFont(Font.font ("Verdana", FontWeight.BOLD, 42));
		//label.setTextFill(Color.web("#0076a3"));
		root.setTop(label);
		root.setMargin(label, new Insets(120,0,0,250));
		
		
	
		Button startButton = new Button("Start");
		startButton.setOnMousePressed(e -> controller.handleOnPressButton1(e));
//		Button exampleButton = new Button("Example");
//		exampleButton.setOnMousePressed(e -> controller.handleOnPressButton2(e));
		Button perviousworkButton = new Button("Pervious_Work");
		perviousworkButton.setOnMousePressed(e -> controller.handleOnPressButton3(e));
		Button closeButton = new Button("Close");
		closeButton.setOnMousePressed(e -> stage.close());
		//nextButton.setOnMousePressed(e -> stage.next());
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(101));
		bbar.getButtons().addAll(perviousworkButton,startButton, closeButton);
		root.setBottom(bbar);
		bbar.setPadding(new Insets(10, 4, 4, 10));
		
		
		Scene scene = new Scene(root, 1000, 600);

		
		Label length = new Label("Length in meter: ");
		TextField lengthtf = new TextField ();
		length.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
		lengthtf.textProperty().addListener(new ChangeListener<String>() {
		       @Override
		       public void changed(ObservableValue<? extends String> observable, String oldValue, 
		           String newValue) {
		           if (!newValue.matches("\\d*")) {
		        	   lengthtf.setText(newValue.replaceAll("[^\\d]", ""));
		           }
		       }
		});
	       
		Label width = new Label("Width in meter: ");
		TextField widthtf = new TextField ();
		width.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
		widthtf.textProperty().addListener(new ChangeListener<String>() {
		       @Override
		       public void changed(ObservableValue<? extends String> observable, String oldValue, 
		           String newValue) {
		           if (!newValue.matches("\\d*")) {
		        	   widthtf.setText(newValue.replaceAll("[^\\d]", ""));
		           }
		       }
		});
//		
		Label name = new Label("Garden name: ");
		TextField nametf = new TextField ();
		name.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
		GridPane grid = new GridPane();
		grid.setVgap(20);
		grid.setHgap(35);
		grid.setPadding((new Insets(12,6,6,12)));
		grid.add(name, 1, 0);
		grid.add(nametf, 1, 1);
		grid.add(length, 3, 0);
		grid.add(lengthtf, 3, 1);
		grid.add(width, 4, 0);
		grid.add(widthtf, 4, 1);
		root.setCenter(grid);
		root.setMargin(grid, new Insets(100,0,0,200));

		
		
		return scene;
	}

}
