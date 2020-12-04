package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import controller.RatingController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.util.ArrayList;


public class ViewRating implements ViewMaker {
	
	private Stage stage;
	
	/** Must inject a stage */
	public ViewRating(Stage stage) {
		this.stage = stage;
}
	
	@Override
	public Scene getScene() {

		RatingController controller = new RatingController(stage);
		BorderPane root = new BorderPane();
		
		// set the background
		Image background = new Image("file:src/main/img/rating/background.png");
		ImageView bk = new ImageView();
    	bk.setImage(background);
    	root.getChildren().add(bk);
        
   

		ArrayList<ImageView> arrayList = new ArrayList<>();
		
		
		// get the number which users choose, and show the corresponding image.
		for(int i = 0;i<6;i++){
			ImageView imageView = new ImageView(new Image("file:src/main/img/rating/"+i+"_star.png "));
			imageView.setFitWidth(450);
			imageView.setFitHeight(100);
			imageView.setTranslateX(-100);
			imageView.setTranslateY(-80);
			arrayList.add(imageView);
			}

		// set the typeface, size, color of title.
		Text label = new Text("\nPlease rate your experience below:");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));
		label.setTranslateX(100);
		label.setTranslateY(50);
		
		//put 5 numbers in the combobox 
		ComboBox<String>  ScoreComboBox = new ComboBox<String>();
        ScoreComboBox.getItems().addAll("5","4","3","2","1","0");
        
        //get the value in combobox
		ScoreComboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override 
			public void changed(ObservableValue ov, String t, String t1) {
				root.setCenter(arrayList.get(Integer.parseInt(t1)));
			}
		});
		root.setTop(label);
		
		Text category = new Text("Score:");
		category.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
        GridPane grid = new GridPane();
        grid.add(category, 0, 0);
        grid.add(ScoreComboBox, 0, 1);
		
		grid.setHgap(100);
		grid.setPadding((new Insets(1,6,6,1)));
		root.setLeft(grid);
		
		// get the buttons
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(e -> controller.handleOnPressButton1(e));
		Button closeButton = new Button("Close");
		closeButton.setOnMousePressed(e -> stage.close());
		ButtonBar bbar = new ButtonBar();
		bbar.getButtons().addAll(backButton, closeButton);
		root.setBottom(bbar);
		
		// set the space between margins and buttons
		bbar.setPadding(new Insets(10, 5, 5, 10));
		
		
		// set the  space among plates
		BorderPane.setMargin(grid, new Insets(100,0,0,200));
		
	    System.out.println(ScoreComboBox.getEditor().getText());
		Scene scene = new Scene(root, 1000, 600);
		return scene;
	}
}
