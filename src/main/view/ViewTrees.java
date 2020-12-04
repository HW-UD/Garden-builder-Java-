package view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
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

import controller.DragController;
import controller.TreesController;

public class ViewTrees extends ViewBase {
	final ScrollBar sc = new ScrollBar();
	final Image[] images = new Image[5];
	final ImageView[] pics = new ImageView[5];
	final VBox vb = new VBox();
	DropShadow shadow = new DropShadow();
//	private ImageView iv1 = new ImageView();
//	private ImageView iv2 = new ImageView();
//	private ImageView iv3 = new ImageView();
//	private ImageView iv4 = new ImageView();
	private final double imgwidth = 200;
	private final double imgheight = 200;
//	private final int imgTransX = 100;
//	private final int imgTransY = 100;
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
					String temp = "../img/spring/" + array[i].getName();
					String pictureName = array[i].getName();
					String flowerName = pictureName.substring(0, pictureName.indexOf("."));
					Image im1 = new Image(getClass().getResourceAsStream(temp));
					ImageView view1 = new ImageView(im1);
					view1.setFitHeight(imgheight);
					view1.setFitWidth(imgwidth);

					ToggleButton button1 = new ToggleButton(flowerName, new ImageView(im1));
//          button1.setTranslateX(10);
//          button1.setTranslateY(10);
					button1.setPrefSize(ButtonWidth, ButtonLength);

					button1.setGraphic(view1);

					button1.selectedProperty().addListener((observable, oldValue, newValue) -> {
						// If selected, color the background blue
						if (newValue) {
							button1.setStyle("-fx-background-color: blue;");
							// button1.setOnMousePressed(handlerP); //��ʱ�Ļ�������Ҫɾ��
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
		Label label = new Label("Choose PLants");
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

		// Create the 1st image and set the position of the image
		/*
		 * Image im1 = new
		 * Image(getClass().getResourceAsStream("../img/default/FloridaAniseTree.jpg"));
		 * ImageView view1 = new ImageView(im1);
		 * 
		 * view1.setFitHeight(imgheight); view1.setFitWidth(imgwidth);
		 * 
		 * ToggleButton button1 = new ToggleButton(); button1.setTranslateX(10);
		 * button1.setTranslateY(10); button1.setPrefSize(ButtonSize, ButtonSize);
		 * button1.setGraphic(view1); button1.setOnMousePressed(handlerP); //��ʱ�Ļ�������Ҫɾ��
		 */

		/*
		 * if(button1.onMouseClickedProperty() != null) { System.out.println("��������Ŀ"); }
		 */

		loadButtons("/Users/wanghuawei/eclipse-workspace/project-team-14/src/main/img/spring");
//     	    Image im1 = new Image(getClass().getResourceAsStream("../img/default/FloridaAniseTree.jpg"));
//    	    ImageView view1 = new ImageView(im1);
//    	  
//    	    view1.setFitHeight(imgheight);
//        	view1.setFitWidth(imgwidth);
//        	
//        	ToggleButton button1 = new ToggleButton("alalal", new ImageView(im1));
//     	    button1.setTranslateX(10);
//     	    button1.setTranslateY(10);
//     	    button1.setPrefSize(ButtonSize, ButtonSize);
//     
//     	    button1.setGraphic(view1);
//        	
//            button1.selectedProperty().addListener((observable, oldValue, newValue) -> {
//                 // If selected, color the background red
//            if (newValue) {
//                 button1.setStyle(
//                        "-fx-background-color: red;");
//            //     button1.setOnMousePressed(handlerP); 	//��ʱ�Ļ�������Ҫɾ��
//                 newValue = false;
//                 } else {
//                     button1.setStyle(null);
//                 }
//             });
//
//    	     tilepane.getChildren().add(button1);

		// Create the 2nd image and set the position of the image
		/*
		 * Image im2 = new
		 * Image(getClass().getResourceAsStream("../img/default/FringeTree.jpg"));
		 * iv2.setImage(im2); tilepane.getChildren().add(iv2);
		 * iv2.setFitHeight(imgheight); iv2.setFitWidth(imgwidth);
		 * iv2.setTranslateX(5*imgTransX); iv2.setTranslateY(-2*imgTransY);
		 */

//    	Image im2 = new Image(getClass().getResourceAsStream("../img/default/FringeTree.jpg"));
//	    ImageView view2 = new ImageView(im2);
//	  
//	    view2.setFitHeight(imgheight);
//    	view2.setFitWidth(imgwidth);
//    	
//    	ToggleButton button2 = new ToggleButton();
// 	    button2.setTranslateX(100);
// 	    button2.setTranslateY(100);
// 	    button2.setGraphic(view2);
//    	button2.setOnMousePressed(handlerP); 	//��ʱ�Ļ�������Ҫɾ��
//    	
//    
//    	
//    	tilepane.getChildren().add(button2);
//    	
//    	//Create the 3rd image and set the position of the image 
//	    Image im3 = new Image(getClass().getResourceAsStream("../img/default/PagodaTree.jpg"));
//	    iv3.setImage(im3);
//	    tilepane.getChildren().add(iv3);
//	    iv3.setFitHeight(imgheight);
//    	iv3.setFitWidth(imgwidth);
//    	iv3.setTranslateX(imgTransX);
//    	iv3.setTranslateY(-imgTransY);
//    	
//    	//Create the 4th image and set the position of the image 
//	    Image im4 = new Image(getClass().getResourceAsStream("../img/default/TulipTree.jpg"));
//	    iv4.setImage(im4);
//	    tilepane.getChildren().add(iv4);
//	    iv4.setFitHeight(imgheight);
//    	iv4.setFitWidth(imgwidth);
//    	iv4.setTranslateX(5*imgTransX);
//    	iv4.setTranslateY(-4*imgTransY);
//    	
//
//    	
//    	Label Tree1 = new Label("Florida Anise Tree");
//    	Tree1.setFont(new Font("Arial",20));//set the font and the size of the title
//    	Tree1.setTextFill(Color.web("#0076a3"));//set the Color of the label
//		Label Tree2 = new Label("Fringe Tree ");
//		Tree2.setFont(new Font("Arial",20));//set the font and the size of the title
//		Tree2.setTextFill(Color.web("#0076a3"));//set the Color of the label
//		Label Tree3 = new Label("Pagoda Tree ");
//		Tree3.setFont(new Font("Arial",20));//set the font and the size of the title
//		Tree3.setTextFill(Color.web("#0076a3"));//set the Color of the label
//		Label Tree4 = new Label("Tulip Tree");
//		Tree4.setFont(new Font("Arial",20));//set the font and the size of the title
//		Tree4.setTextFill(Color.web("#0076a3"));//set the Color of the label

		/*
		 * GridPane grid = new GridPane(); grid.setVgap(20); grid.setHgap(35);
		 * grid.setPadding((new Insets(12,6,6,12))); grid.add(Tree1, 3, 0);//set the
		 * position of the label1 grid.add(Tree2, 8, 0); grid.add(Tree3, 3, 14);
		 * grid.add(Tree4, 8, 14);
		 * 
		 * root.setCenter(grid); // root.setMargin(grid, new Insets(100,0,0,200));
		 * 
		 * 
		 * Scene scence = new Scene(root, WIDTH, HEIGHT); root.getChildren().addAll(vb,
		 * sc);
		 * 
		 * shadow.setColor(Color.GREY); shadow.setOffsetX(2); shadow.setOffsetY(2);
		 * 
		 * /* vb.setLayoutX(5); vb.setSpacing(10);
		 * 
		 * sc.setLayoutX(scence.getWidth()-sc.getWidth()); sc.setMin(0);
		 * sc.setOrientation(Orientation.VERTICAL); sc.setMax(500);
		 * sc.setPrefHeight(500); sc.setVisibleAmount(50); sc.setBlockIncrement(300);
		 * sc.setPrefWidth(30); sc.resize(10, 600);
		 * 
		 * for (int i = 0; i < 5; i++) { final ImageView pic = pics[i] = new
		 * ImageView(images[i]); pic.setEffect(shadow); vb.getChildren().add(pics[i]); }
		 */

		return new Scene(root, WIDTH, HEIGHT);
	}

	public ViewTrees(Stage stage) {
		super(stage, e -> new TreesController(stage).handleMousePress(e),
				e -> new TreesController(stage).handleMousePress2(e));
	}

}
