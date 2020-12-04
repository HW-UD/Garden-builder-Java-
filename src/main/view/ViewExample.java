package view;

import controller.CharacteristicsController;
import controller.DragController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewExample extends ViewBase {
	
	public ViewExample(Stage stage) {
//		this.stage = stage;
		super(stage, e -> new CharacteristicsController(stage).handleMousePress(e), e -> new CharacteristicsController(stage).handleMousePress2(e));
	}
	public Scene getScene() {
		BorderPane root = new BorderPane();
        Label label = new Label("Please see examples");
        label.setFont(new Font(32));
		root.setTop(label);
		root.setMargin(label, new Insets(120,0,0,300));
		
		Image img =new Image(getClass().getResourceAsStream("../img/default/garden1.jpg"));
		ImageView iv1 = new ImageView();
        iv1.setImage(img);
        root.getChildren().add(iv1);
        iv1.setPreserveRatio(true);
        iv1.setTranslateX(iv1.getTranslateX()+80);
        iv1.setTranslateY(iv1.getTranslateY()+190);
        
        Image img1 =new Image(getClass().getResourceAsStream("../img/default/garden2.jpg"));
		ImageView iv2 = new ImageView();
        iv2.setImage(img1);
        root.getChildren().add(iv2);
        iv2.setPreserveRatio(true);
        iv2.setTranslateX(iv1.getTranslateX()+290);
        iv2.setTranslateY(iv1.getTranslateY()+0);
        
        Image img2 =new Image(getClass().getResourceAsStream("../img/default/garden3.jpg"));
		ImageView iv3 = new ImageView();
        iv3.setImage(img2);
        root.getChildren().add(iv3);
        iv3.setPreserveRatio(true);
        iv3.setTranslateX(iv1.getTranslateX()+600);
        iv3.setTranslateY(iv1.getTranslateY()+0);
        
        Image img3 =new Image(getClass().getResourceAsStream("../img/default/garden4.jpg"));
		ImageView iv4 = new ImageView();
        iv4.setImage(img3);
        root.getChildren().add(iv4);
        iv4.setPreserveRatio(true);
        iv4.setTranslateX(iv1.getTranslateX()+150);
        iv4.setTranslateY(iv1.getTranslateY()+210);
        
        Image img4 =new Image(getClass().getResourceAsStream("../img/default/garden5.jpg"));
		ImageView iv5 = new ImageView();
        iv5.setImage(img4);
        root.getChildren().add(iv5);
        iv5.setPreserveRatio(true);
        iv5.setTranslateX(iv1.getTranslateX()+450);
        iv5.setTranslateY(iv1.getTranslateY()+210);
		
//		TilePane tilepane = new TilePane();
//		tilepane.setPrefWidth(imgwidth+20);
//	    tilepane.setPrefColumns(1);
//		
//		getFile("/Users/ruiheng/eclipse-workspace/project-team-14/src/main/img/spring");
//    	for (Image i: plants_img) {
//
//    		ImageView iv1 = new ImageView();
//        	iv1.setImage(i);
//        	tilepane.getChildren().add(iv1);
//        	iv1.setPreserveRatio(true);
//        	iv1.setFitHeight(imgheight);
//        	iv1.setFitWidth(imgwidth);
////        	DragController.drag (iv1);
//    	}
    	
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 4, 4, 10));
		bbar.getButtons().addAll(backButton);
		root.setBottom(bbar);
		 
		return new Scene(root, WIDTH, HEIGHT);
	}
}
