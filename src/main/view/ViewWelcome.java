package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import controller.Main;
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

/** The view of welcome page
 * 
 * @author Ruiheng Xie
 * @version Final
 * @return scene
 *
 */
public class ViewWelcome implements ViewMaker {
	
	private Stage stage;//The stage for holding elements
	static TextField lengthtf;
	static TextField widthtf;
	
	/** Must inject a stage */
	public ViewWelcome(Stage stage) {
		this.stage = stage;
	}

	@Override
	public Scene getScene() {
		
		int xloc = 80;//fit location for x
		int yloc = 90;//fit location for y
		int sceneX = 1000;//scene length
		int sceneY = 600;//scene width
		int M1A = 120;//margin num1A
		int M1D = 250;//margin num1D
		int M2A = 100;//margin num2A
		int M2D = 200;//margin num2D
		int labelsize = 20;//labelsize
		int padding1 = 10;//padding num1
		int padding2 = 4;//padding num2
		int padding3 = 12;//padding num3
		int padding4 = 6;//padding num4
		int paddingin = 101;//padding insert num
		int vgap = 20;//vgap num
		int hgap = 35;//hgap num
		int glth = 3;
		int gtf = 1;
		int hlth = 4;
		
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
        iv1.setTranslateX(iv1.getTranslateX()+ xloc);
        iv1.setTranslateY(iv1.getTranslateY()+ yloc);
        
        
		Label label = new Label("    ");
		label.setFont(Font.font ("Verdana", FontWeight.BOLD, labelsize));
		//label.setTextFill(Color.web("#0076a3"));
		root.setTop(label);
		root.setMargin(label, new Insets(M1A,0,0,M1D));
		
		
	
		Button startButton = new Button("Start");
		startButton.setOnMousePressed(e -> controller.handleOnPressButton1(e));
		Button perviousworkButton = new Button("Pervious_Work");
		perviousworkButton.setOnMousePressed(e -> controller.handleOnPressButton3(e));
		Button closeButton = new Button("Close");
		closeButton.setOnMousePressed(e -> stage.close());
		//nextButton.setOnMousePressed(e -> stage.next());
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(paddingin));
		bbar.getButtons().addAll(perviousworkButton,startButton, closeButton);
		root.setBottom(bbar);
		bbar.setPadding(new Insets(padding1, padding2, padding2, padding1));
		
		
		Scene scene = new Scene(root, sceneX, sceneY);

		
		Label length = new Label("Length in meter: ");
		lengthtf = new TextField ();
		length.setFont(Font.font ("Verdana",FontWeight.BOLD, labelsize));
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
		widthtf = new TextField ();
		width.setFont(Font.font ("Verdana",FontWeight.BOLD, labelsize));
		widthtf.textProperty().addListener(new ChangeListener<String>() {
		       @Override
		       public void changed(ObservableValue<? extends String> observable, String oldValue, 
		           String newValue) {
		           if (!newValue.matches("\\d*")) {
		        	   widthtf.setText(newValue.replaceAll("[^\\d]", ""));
		           }
		       }
		});

		GridPane grid = new GridPane();
		grid.setVgap(vgap);
		grid.setHgap(hgap);
		grid.setPadding((new Insets(padding3,padding4,padding4,padding3)));

		grid.add(length, glth, 0);
		grid.add(lengthtf, glth, gtf);
		grid.add(width, hlth, 0);
		grid.add(widthtf, hlth, gtf);
		root.setCenter(grid);
		root.setMargin(grid, new Insets(M2A,0,0,M2D));

		
		
		return scene;
	}

	public static TextField getLengthtf() {
		return lengthtf;
	}

	public static void setLengthtf(TextField length) {
		lengthtf = length;
	}

	public static TextField getWidthtf() {
		return widthtf;
	}

	public void setWidthtf(TextField widthtf) {
		this.widthtf = widthtf;
	}

}
