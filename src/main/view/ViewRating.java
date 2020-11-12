package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import controller.RatingController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
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


		ArrayList<ImageView> arrayList = new ArrayList<>();
		for(int i = 1;i<6;i++){
			ImageView imageView = new ImageView(new Image("file:src/main/img/rating/"+i+"_star.png "));
			imageView.setFitWidth(230);
			imageView.setFitHeight(50);
			arrayList.add(imageView);
			}

		Text label = new Text("Please rate for us:\nChose 1~5");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		ComboBox<String>  ScoreComboBox = new ComboBox<String>();
        ScoreComboBox.getItems().addAll("5","4","3","2","1");
        
        //get the value in combobox
		ScoreComboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override 
			public void changed(ObservableValue ov, String t, String t1) {
				root.setCenter(arrayList.get(Integer.parseInt(t1)-1));
			}
		});
		root.setTop(label);
		
		Text category = new Text("Score:");
		category.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        GridPane grid = new GridPane();
        grid.add(category, 0, 0);
        grid.add(ScoreComboBox, 0, 1);
		grid.setVgap(20);
		grid.setHgap(100);
		grid.setPadding((new Insets(1,6,6,1)));
		root.setLeft(grid);
		
		
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(e -> controller.handleOnPressButton1(e));
		Button closeButton = new Button("Close");
		closeButton.setOnMousePressed(e -> stage.close());
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(101));
		bbar.getButtons().addAll(backButton, closeButton);
		root.setBottom(bbar);
		bbar.setPadding(new Insets(10, 4, 4, 10));
		BorderPane.setMargin(grid, new Insets(100,0,0,200));
		
	    System.out.println(ScoreComboBox.getEditor().getText());
		Scene scene = new Scene(root, 1000, 600);
		return scene;
	}
}
