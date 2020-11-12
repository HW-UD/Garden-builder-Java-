package view;

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
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewFences  extends ViewBase{
	
	final ScrollBar sc = new ScrollBar();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();
    DropShadow shadow = new DropShadow();
    private ImageView iv1 = new ImageView();
	private ImageView iv2 = new ImageView();
	private ImageView iv3 = new ImageView();
	private ImageView iv4 = new ImageView();
	private final int imgwidth1 = 250;
	private final int imgheight1 = 250;
    
	public Scene getScene() {
		BorderPane root = new BorderPane();
		
		
		root.setPadding(new Insets(10));
		Label label = new Label("Choose Fences");
		label.setFont(new Font("Arial",32));//set the font and the size of the title
		root.setTop(label);
        label.setTextFill(Color.web("#0076a3"));//set the Color of the label	 
        
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);

		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);
		
		
		//Create the 1st image and set the position of the image 
	    Image im1 = new Image(getClass().getResourceAsStream("../img/default/WhiteFence1.jpg"));
	    iv1.setImage(im1);
	    root.getChildren().add(iv1);
	    iv1.setFitHeight(imgheight1);
    	iv1.setFitWidth(imgwidth1);
    	iv1.setTranslateX(iv1.getTranslateX()+80);
    	iv1.setTranslateY(iv1.getTranslateY()+90);
    	
    	//Create the 2nd image and set the position of the image 
	    Image im2 = new Image(getClass().getResourceAsStream("../img/default/BlackFence2.jpg"));
	    iv2.setImage(im2);
	    root.getChildren().add(iv2);
	    iv2.setFitHeight(imgheight1);
    	iv2.setFitWidth(imgwidth1);
    	iv2.setTranslateX(iv2.getTranslateX()+380);
    	iv2.setTranslateY(iv2.getTranslateY()+90);
    	
    	//Create the 3rd image and set the position of the image 
	    Image im3 = new Image(getClass().getResourceAsStream("../img/default/WhiteFence3.jpg"));
	    iv3.setImage(im3);
	    root.getChildren().add(iv3);
	    iv3.setFitHeight(imgheight1);
    	iv3.setFitWidth(imgwidth1);
    	iv3.setTranslateX(iv3.getTranslateX()+80);
    	iv3.setTranslateY(iv3.getTranslateY()+390);
    	
    	//Create the 4th image and set the position of the image 
	    Image im4 = new Image(getClass().getResourceAsStream("../img/default/BlackFence4.jpg"));
	    iv4.setImage(im4);
	    root.getChildren().add(iv4);
	    iv4.setFitHeight(imgheight1);
    	iv4.setFitWidth(imgwidth1);
    	iv4.setTranslateX(iv4.getTranslateX()+380);
    	iv4.setTranslateY(iv4.getTranslateY()+390);
    	

    	
    	Label Fence1 = new Label("White Fence1");
    	Fence1.setFont(new Font("Arial",20));//set the font and the size of the title
    	Fence1.setTextFill(Color.web("#0076a3"));//set the Color of the label
		Label Fence2 = new Label("Black Fence2");
		Fence2.setFont(new Font("Arial",20));//set the font and the size of the title
		Fence2.setTextFill(Color.web("#0076a3"));//set the Color of the label
		Label Fence3 = new Label("White Fence2");
		Fence3.setFont(new Font("Arial",20));//set the font and the size of the title
		Fence3.setTextFill(Color.web("#0076a3"));//set the Color of the label
		Label Fence4 = new Label("Black Fence4");
		Fence4.setFont(new Font("Arial",20));//set the font and the size of the title
		Fence4.setTextFill(Color.web("#0076a3"));//set the Color of the label
	
		GridPane grid = new GridPane();
		grid.setVgap(20);
		grid.setHgap(35);
		grid.setPadding((new Insets(12,6,6,12)));
		grid.add(Fence1, 3, 0);//set the position of the label1
		grid.add(Fence2, 8, 0);
		grid.add(Fence3, 3, 14);
		grid.add(Fence4, 8, 14);

		root.setCenter(grid);
		
        Scene scence = new Scene(root, WIDTH, HEIGHT);
        root.getChildren().addAll(vb, sc);
 
        shadow.setColor(Color.GREY);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);
 
        vb.setLayoutX(5);
        vb.setSpacing(10);
        
        sc.setLayoutX(scence.getWidth()-sc.getWidth());
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setMax(500);
        sc.setPrefHeight(500);
        sc.setVisibleAmount(50);
        sc.setBlockIncrement(300);
        sc.setPrefWidth(30);
        sc.resize(10, 600);
 
        for (int i = 0; i < 5; i++) {
            final ImageView pic = pics[i] =
                new ImageView(images[i]);
            pic.setEffect(shadow);
            vb.getChildren().add(pics[i]);
        }

		return scence;
	}
	
	
	
	
	
	  
	
	
    public ViewFences (Stage stage) {
	       //   super(stage, "Choose fences", e -> new ViewFencesController(stage).handleMousePress(e));
    	super(stage, e -> new FencesController(stage).handleMousePress(e), e -> new FencesController(stage).handleMousePress2(e));
   }
 

}
