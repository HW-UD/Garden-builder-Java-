package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import controller.Main;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ViewRating implements ViewMaker {
	
	private Stage stage;
	
	/** Must inject a stage */
	public ViewRating(Stage stage) {
		this.stage = stage;
	}

	@Override
	public Scene getScene() {
		
		Main controller = new Main();
		
		BorderPane root = new BorderPane();

		
		Text label = new Text("Please rate for us:\nChose 1~5");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		final ComboBox ScoreComboBox = new ComboBox();
        ScoreComboBox.getItems().addAll("5","4","3","2","1");
		root.setTop(label);
		root.setMargin(label, new Insets(50,0,0,200));
		
		Text category = new Text("Score:");
		category.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        GridPane grid = new GridPane();
        grid.add(category, 0, 0);
        grid.add(ScoreComboBox, 0, 1);

		Scene scene = new Scene(root, 1000, 600);
		Button CloseButton = new Button("Close");
		Button BackButton = new Button("Back");
		grid.setVgap(20);
		grid.setHgap(100);
		grid.setPadding((new Insets(1,6,6,1)));
		grid.add(CloseButton, 5, 12);
		CloseButton.setMinHeight(30);
		CloseButton.setMinWidth(90);
		grid.add(BackButton, 0, 12);
		BackButton.setMinHeight(30);
		BackButton.setMinWidth(90);
		root.setCenter(grid);
		root.setMargin(grid, new Insets(100,0,0,200));
		return scene;
	}
}
