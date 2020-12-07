package view;

import java.io.File;

import javax.swing.event.ChangeListener;

import controller.DragController;
import controller.FencesController;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewFences extends ViewBase {

	final ScrollBar sc = new ScrollBar();
	final Image[] images = new Image[5];
	final ImageView[] pics = new ImageView[5];
	final VBox vb = new VBox();
	DropShadow shadow = new DropShadow();
	private final double imgwidth = 200;
	private final double imgheight = 200;
	private final int ButtonLength = 300;
	private final int ButtonWidth = 500;
	BorderPane root = new BorderPane();
	FlowPane flowpane = new FlowPane();

	public void loadButtons(String path) {
		File file = new File(path); // get file list where the path has
		File[] array = file.listFiles(); // get the folder list
		System.out.println(array.toString());

		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {
				// only take file name
				if (array[i].getName().endsWith(".png")) {

					String temp = "../img/fences/" + array[i].getName();

					String pictureName = array[i].getName();
					String flowerName = pictureName.substring(0, pictureName.indexOf("."));

					Image im1 = new Image(getClass().getResourceAsStream(temp));

					ImageView view1 = new ImageView(im1);

					view1.setFitHeight(imgheight);
					view1.setFitWidth(imgwidth);

					ToggleButton button1 = new ToggleButton(flowerName, new ImageView(im1));

					button1.setPrefSize(ButtonWidth, ButtonLength);

					button1.setGraphic(view1);

					button1.selectedProperty().addListener((observable, oldValue, newValue) -> {
						// If selected, color the background blue
						if (newValue) {
							button1.setStyle("-fx-background-color: blue;");
							newValue = false;
						} else {
							button1.setStyle(null);
						}
					});

					flowpane.getChildren().add(button1);

				}

			} else if (array[i].isDirectory()) {
				loadButtons(array[i].getPath());
			}
		}
	}

	public Scene getScene() {

		flowpane.setPrefWidth(1000);

		ScrollPane scrollPane = new ScrollPane(flowpane);
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		root.setCenter(scrollPane);

		root.setPadding(new Insets(10));
		Label label = new Label("Choose Fences");
		label.setFont(new Font("Arial", 32));// set the font and the size of the title
		root.setTop(label);

		label.setTextFill(Color.web("#0076a3"));// set the Color of the label

		// Create next and back button
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);

		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);

		String path1= "/Users/wanghuawei/eclipse-workspace/project-team-14/src/main/Saved/";
		loadButtons(path1);

		return new Scene(root, WIDTH, HEIGHT);
	}

	public ViewFences(Stage stage) {
		// super(stage, "Choose fences", e -> new
		// ViewFencesController(stage).handleMousePress(e));
		super(stage, e -> new FencesController(stage).handleMousePress(e),
				e -> new FencesController(stage).handleMousePress2(e));
	}

}
