package view;


import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import controller.PworkController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ViewPwork extends ViewBase {


	public ViewPwork(Stage stage) {
		super(stage, e -> new PworkController(stage).handleMousePress(e), e -> new PworkController(stage).handleMousePress2(e));
	}
	
	public Scene getScene() {

		BorderPane root = new BorderPane();
        Label label = new Label("Chose a recent work");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		root.setTop(label);
		BorderPane.setMargin(label, new Insets(5,0,0,350));
        root.setPadding(new Insets(10));
        
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        root.setCenter(flow);
        Button work1 =  new Button("work 1");
        //work1.setOnMousePressed(e -> controller.handleOnPressButton1(e));
        Button work2 =  new Button("work 2");
        //work2.setOnMousePressed(e -> controller.handleOnPressButton1(e));
        Button work3 =  new Button("work 3");
        //work3.setOnMousePressed(e -> controller.handleOnPressButton1(e));
        Button work4 =  new Button("work 4");
        //work3.setOnMousePressed(e -> controller.handleOnPressButton1(e));
        ButtonBar works = new ButtonBar();
        works.setPadding(new Insets(10, 0, 0, 10));
        works.getButtons().addAll(work1,work2,work3,work4);
        flow.getChildren().add(works);
        
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);
		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);
        
        
        
        
        return new Scene(root, WIDTH, HEIGHT);
    }    
}