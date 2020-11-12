package view;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javax.swing.event.ChangeListener;
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

		
		Text label = new Text("Please rate for us:\nChose 1~5");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		root.setTop(label);
		ComboBox ScoreComboBox = new ComboBox();
        ScoreComboBox.getItems().addAll("5","4","3","2","1");
		
		Text category = new Text("Score:");
		category.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        GridPane grid = new GridPane();
        grid.add(category, 0, 0);
        grid.add(ScoreComboBox, 0, 1);
		grid.setVgap(20);
		grid.setHgap(100);
		grid.setPadding((new Insets(1,0,0,1)));
		root.setLeft(grid);
		
		
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(e -> controller.handleOnPressButton1(e));
		Button closeButton = new Button("Close");
		closeButton.setOnMousePressed(e -> stage.close());
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(100));
		bbar.getButtons().addAll(backButton, closeButton);
		root.setBottom(bbar);
		bbar.setPadding(new Insets(10, 5, 5, 10));
		BorderPane.setMargin(grid, new Insets(100,0,0,200));
		
		//  detect the number in Combobox.
	    System.out.println(ScoreComboBox.getEditor().getText());
	    Image img =  new Image(getClass().getResourceAsStream("../img/rating/5_star.png"));			
		ImageView iv1 = new ImageView();
		iv1.setImage(img);
		root.getChildren().add(iv1);
		iv1.setPreserveRatio(true);
		iv1.setFitWidth(350);
	    iv1.setTranslateX(iv1.getTranslateX()+325);
	    iv1.setTranslateY(iv1.getTranslateY()+170);

		Scene scene = new Scene(root, 1000, 600);
		return scene;
	}
}
