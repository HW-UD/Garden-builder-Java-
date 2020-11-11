package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javafx.scene.text.Font;

import controller.Main;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		Main controller = new Main();

		// Switch between scenes
//		Button button1 = new Button("Scene 1");
//		button1.setOnMousePressed(e -> controller.handleOnPressButton1(e));
//		Button button2 = new Button("Scene 2");
//		button2.setOnMousePressed(e -> controller.handleOnPressButton2(e));
//		Button button3 = new Button("Scene 3");
//		button3.setOnMousePressed(e -> controller.handleOnPressButton3(e));
		
		// Build scene
		//VBox vbox = new VBox();
		//vbox.setSpacing(10);
		//vbox.setPadding(new Insets(10));
		//vbox.getChildren().addAll(button1, button2, button3);
		
		BorderPane root = new BorderPane();
		//root.setLeft(vbox);
		Label label = new Label("Welcome to Garden Designer");
		label.setFont(new Font(32));
		root.setTop(label);
		root.setMargin(label, new Insets(120,0,0,250));
	
		Button startButton = new Button("Start");
		//nextButton.setOnMousePressed(e -> stage.next());
//		ButtonBar bbar1 = new ButtonBar();
//		bbar1.setPadding(new Insets(101));
//		bbar1.getButtons().add(nextButton);
//		root.setBottom(bbar1);
		
//		Button closeButton = new Button("Close");
//		closeButton.setOnMousePressed(e -> stage.close());
//		ButtonBar bbar = new ButtonBar();
//		bbar.setPadding(new Insets(10));
//		bbar.getButtons().add(closeButton);
//		root.setBottom(bbar);
		Scene scene = new Scene(root, 1000, 600);
		Button exampleButton = new Button("Example");
		Button perviousworkButton = new Button("Pervious_Work");
		
		Label length = new Label("Length: ");
		TextField lengthtf = new TextField ();
		Label width = new Label("Width: ");
		TextField widthtf = new TextField ();
		Label name = new Label("Garden name: ");
		TextField nametf = new TextField ();
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
		grid.add(startButton, 6, 12);
		startButton.setMinHeight(30);
		startButton.setMinWidth(90);
		grid.add(exampleButton, 5, 12);
		exampleButton.setMinHeight(30);
		exampleButton.setMinWidth(90);
		grid.add(perviousworkButton, 4, 12);
		perviousworkButton.setMinHeight(30);
		perviousworkButton.setMinWidth(90);
		root.setCenter(grid);
		root.setMargin(grid, new Insets(100,0,0,200));

		
		
		return scene;
	}

}
