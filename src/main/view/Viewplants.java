package view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.DragController;
import controller.Main;
import controller.PlantsController;
import model.GardenModel;
import model.Plants;

/**
 * The Viewplants page shows the attributes for all plants
 * 
 * @author Benny Li, Ruiheng Xie
 * @version final
 */
public class Viewplants extends ViewBase {
	VBox vbox = new VBox();

	/**
	 * Scene of the Browse plants page.
	 * 
	 * @param None
	 * @return Scene
	 * @author Benny Li, Ruiheng Xie
	 * @version Final
	 */
	public Scene getScene() {
		BorderPane root = new BorderPane();
		Canvas canvas = new Canvas(WIDTH, HEIGHT);

		FlowPane content = new FlowPane(20, 20);
		content.setMinHeight(Main.getModel().getPlantBank().size() * 50);
		content.setMinWidth(Main.getModel().getPlantBank().size() * 5);
		for (Plants i : Main.getModel().getPlantBank()) {
			GardenImage img = i.getImgSpring();
			GardenImgView iv1 = new GardenImgView();
			vbox.getChildren().add(iv1);
			System.out.println(img.getID());
			iv1.setImage(img);
			iv1.setPreserveRatio(true);
			iv1.setFitHeight(imgheight);
			iv1.setFitWidth(imgwidth);

			Label nameinfo = new Label("Name: " + i.getSpecies());
			Label sizeinfo = new Label("Height: " + i.getSize() + " m ");
			Label waterinfo = new Label("Water need: " + i.getWater());
			Label colorinfo = new Label("Color: " + i.getColor());
			Label leafinfo = new Label("Leaf: " + i.getLeaf());
			vbox.getChildren().add(nameinfo);
			vbox.getChildren().add(waterinfo);
			vbox.getChildren().add(sizeinfo);
			vbox = new VBox(iv1, nameinfo, sizeinfo, colorinfo, waterinfo, leafinfo);
			content.getChildren().add(vbox);
		}

		ScrollPane bank = new ScrollPane();
		bank.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		bank.fitToWidthProperty().set(true);
		bank.fitToHeightProperty().set(true);
		bank.setContent(content);
		root.setCenter(bank);

		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);

		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);

		root.setPadding(new Insets(10));
		Label label = new Label("Browse all plants");
		label.setFont(new Font("Arial", 32));// set the font and the size of the title
		root.setTop(label);

		return new Scene(root, WIDTH, HEIGHT);
	}

	/**
	 * Show next and back buttons at the bottom of this page.
	 * 
	 * @param stage Stage stage:the stage for loading the buttons
	 * @return none
	 * @author BennyLi, Ruiheng Xie,
	 * @version Final
	 */
	public Viewplants(Stage stage) {
		super(stage, e -> new PlantsController(stage).handleMousePress(e),
				e -> new PlantsController(stage).handleMousePress2(e));
	}

}