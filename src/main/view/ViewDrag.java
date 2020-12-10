package view;

import java.awt.MouseInfo;
import java.awt.Point;
import controller.DragController;
import controller.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Plants;
import model.colorE;
import model.LeafE;
import model.waterE;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class ViewDrag extends ViewBase {
	String WorkPath = System.getProperty("user.dir");
	boolean flag = false;



	@Override
	public Scene getScene() {
		BorderPane root = new BorderPane();
		middle = new Pane();
		GraphicsContext gc;
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();

		FlowPane flowpane = new FlowPane();

		flowpane.setPrefWidth(imgwidth + 30);
		flowpane.setPrefHeight(imgheight + 600);

		ScrollPane scrollPane = new ScrollPane(flowpane);

		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		VBox vbox = new VBox();
		VBox Plantbox = new VBox();

		ChoiceBox<String> Leaf = new ChoiceBox<String>();
		Leaf.getItems().addAll("All", "Oval", "Linear", "Oblong", "Ovate", "Needle", "Maple", "Scale", "Spear",
				"Paddle");

		ChoiceBox<String> waterNeed = new ChoiceBox<String>();
		waterNeed.getItems().addAll("All", "High", "Medium", "Low");

		ChoiceBox<String> color = new ChoiceBox<String>();
		color.getItems().addAll("All", "White", "Purple", "Blue", "Orange", "Yellow", "Pink");

		Leaf.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				Plantbox.getChildren().clear();
				for (Plants i : Main.getModel().getPlantBank()) {
					if (i.getLeaf() == LeafE.valueOf(t1)) {
						paneimg(i, Plantbox);

					} else if (t1.equals("All")) {
							if(i.getType().equals("trees")) {
								paneimg(i, Plantbox);
							}

						}
					}
				}
		});

		color.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				System.out.println(t1);
				Plantbox.getChildren().clear();
				for (Plants i : Main.getModel().getPlantBank()) {
					if (i.getColor() == colorE.valueOf(t1)) {
						paneimg(i, Plantbox);
					} else if (t1.compareTo("All") == 0) {
						if(i.getType().equals("flowers")) {
							paneimg(i, Plantbox);
						}
					}
				}
			}
		});

		waterNeed.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				Plantbox.getChildren().clear();
				for (Plants i : Main.getModel().getPlantBank()) {
					if (i.getWater() == waterE.valueOf(t1)) {
						paneimg(i, Plantbox);

					} else if (t1.equals("All")) {
						paneimg(i, Plantbox);

					}
				}
			}
		});

		Label WaterN = new Label("WaterNeed: ");
		WaterN.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		Label LeafW = new Label("Tree Leaf Shape: ");
		LeafW.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		Label Fcolor = new Label("Flower color: ");
		Fcolor.setFont(Font.font("Verdana", FontWeight.BOLD, 10));

		vbox.getChildren().add(WaterN);
		vbox.getChildren().add(waterNeed);

		vbox.getChildren().add(LeafW);
		vbox.getChildren().add(Leaf);

		vbox.getChildren().add(Fcolor);
		vbox.getChildren().add(color);

		flowpane.getChildren().add(vbox);
		flowpane.getChildren().add(Plantbox);

		root.setLeft(scrollPane);
		root.setCenter(middle);

		for (Plants p : Main.getModel().getPlantBank()) {
			GardenImage i = p.getImgSpring();
			GardenImgView iv1 = new GardenImgView();
			iv1.setID(i.getID());
			iv1.setImage(i);
			Plantbox.getChildren().add(iv1);
			iv1.setPreserveRatio(true);
			iv1.setFitHeight(imgheight);
			iv1.setFitWidth(imgwidth);
			DragController.drag(iv1);
		}

		DragController.drop(middle);
		DragController.DragOver(middle);

		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);



		Button saveButton = new Button("Save");
		saveButton.setOnAction(e -> new SaveViewbox().display("title", "message"));

		Button clear = new Button("Clear");
		EventHandler<ActionEvent> Clearevent = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				middle.getChildren().clear();
				Main.getModel().getGarden().getGarden_Plants().clear();
				System.out.println(Main.getModel().getGarden().getGarden_Plants());
				Image background = new Image(getClass().getResourceAsStream("../img/default/clear.png"));
				gc.drawImage(background, 0, 0, WIDTH, HEIGHT);
			}
		};

		clear.setOnAction(Clearevent);

		EventHandler event_press = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				gc.beginPath();
				gc.moveTo(event.getX() + 130, event.getY());
				gc.stroke();
			}
		};

		EventHandler event_drag = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				gc.lineTo(event.getX() + 130, event.getY());
				gc.stroke();
			}
		};

		Button draw = new Button("Draw");
		draw.setOnMouseClicked(new EventHandler<MouseEvent>() {// click by using mouse left key to start drawing, once you release the mouse,it stops drawing.
			//Double click draw button won't start drawing. If you want to draw more things, you need to click the draw button again. 
			@Override
			public void handle(MouseEvent event) {

				if (event.getButton() == MouseButton.PRIMARY) {
					if (flag == false) {
						middle.addEventHandler(MouseEvent.MOUSE_PRESSED, event_press);
						middle.addEventHandler(MouseEvent.MOUSE_DRAGGED, event_drag);
						middle.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								middle.removeEventHandler(MouseEvent.MOUSE_PRESSED, event_press);
								middle.removeEventHandler(MouseEvent.MOUSE_DRAGGED, event_drag);
								flag = false;
							}
						});
						flag = true;
					} else {
						middle.removeEventHandler(MouseEvent.MOUSE_PRESSED, event_press);
						middle.removeEventHandler(MouseEvent.MOUSE_DRAGGED, event_drag);
						flag = false;
					}
				}
			}
		});
		
		Button instruc = new Button("Instruction");
		instruc.setOnAction(e -> new ViewAlertbox().display("title", "message"));
     
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(0, 0, 0, 0));
		bbar.getButtons().addAll(instruc, draw, clear, saveButton, backButton, nextButton);
		root.setBottom(bbar);
		
		
		
		
		
		Button SpringButton = new Button("Spring");
		SpringButton.setStyle("-fx-background-color:#00FF7F");
		Button SummerButton = new Button("Summer");
		SummerButton.setStyle("-fx-background-color:#228B22");
		Button FallButton = new Button("Fall");
		FallButton.setStyle("-fx-background-color:#FFB90F");
		Button WinterButton = new Button("Winter");
		WinterButton.setStyle("-fx-background-color:#838B83");
		ButtonBar topBbar = new ButtonBar();
		topBbar.setPadding(new Insets(0, 0, 0, 0));
		topBbar.getButtons().addAll(SpringButton, SummerButton,FallButton,WinterButton);
		root.setTop(topBbar);

		SpringButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		middle.getChildren().clear();
        		for (Plants i: Main.getModel().getGarden().getGarden_Plants()) {
        			paneimgLoading( i,  middle,1) ;}        	}	
        });
		
		SummerButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		middle.getChildren().clear();
        		for (Plants i: Main.getModel().getGarden().getGarden_Plants()) {
        			paneimgLoading( i,  middle,2) ;}
        		}
        });
		
		FallButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		middle.getChildren().clear();
        		for (Plants i: Main.getModel().getGarden().getGarden_Plants()) {
        			paneimgLoading( i,  middle,3) ;}
        	}	
        });
		
		WinterButton.setOnAction( new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		middle.getChildren().clear();
        		for (Plants i: Main.getModel().getGarden().getGarden_Plants()) {
        			paneimgLoading( i,  middle,4) ;}        	}	//FIXME:
        }); 
		
		


		return new Scene(root, WIDTH, HEIGHT);
	}

	public FlowPane getFlower() {
		return null;
	}

	/** Must inject a stage */
	public ViewDrag(Stage stage) {
		super(stage, e -> new DragController(stage).handleMousePress(e),
				e -> new DragController(stage).handleMousePress2(e));
	}

}
