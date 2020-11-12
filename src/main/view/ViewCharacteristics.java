package view;

import controller.CharacteristicsController;
import controller.SurroundController;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewCharacteristics extends ViewBase {
	//private Stage stage;

	public ViewCharacteristics(Stage stage) {
//		this.stage = stage;
		super(stage, e -> new CharacteristicsController(stage).handleMousePress(e), e -> new CharacteristicsController(stage).handleMousePress2(e));
	}
	public Scene getScene() {
//        stage.setTitle("ComboBoxSample");
//        Scene scene = new Scene(new Group(), 1000, 600);
		BorderPane root = new BorderPane();
        Label label = new Label("Identify your plant characteristics");
        label.setFont(new Font(32));
        label.setFont(new Font(32));
		root.setTop(label);
		root.setMargin(label, new Insets(120,0,0,250));
//        Group root = (Group)scene.getRoot();
        
        root.setPadding(new Insets(10));
        
        final ComboBox lightComboBox = new ComboBox();
        lightComboBox.getItems().addAll("glare","medium","weak");
       
        final ComboBox waterComboBox = new ComboBox();
        waterComboBox.getItems().addAll("large","medium","little");
        
        final ComboBox bloomtimeComboBox = new ComboBox();
        bloomtimeComboBox.getItems().addAll("long","medium","short");
        
        final ComboBox foodComboBox = new ComboBox();
        foodComboBox.getItems().addAll("large","medium","little");
        
        final ComboBox bloomcolorComboBox = new ComboBox();
        bloomcolorComboBox.getItems().addAll("red","yellow","white","pink","purple");
        
        final ComboBox soilreqComboBox = new ComboBox();
        soilreqComboBox.getItems().addAll("acidity","neutral","alkalinity");   
        
        
       
        Button backButton = new Button("Back");
        backButton.setOnMousePressed(handlerP);
        Button nextButton = new Button("Next");
        nextButton.setOnMousePressed(handlerN);
        Button button = new Button("?");
        ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(101));
		bbar.getButtons().addAll(button,backButton, nextButton);
		root.setBottom(bbar);
		bbar.setPadding(new Insets(10, 4, 4, 10));
 
        button.setOnAction(e -> new ViewAlertbox().display("title", "message"));
        AnchorPane layout = new AnchorPane();
        layout.getChildren().add(button);
       
        
        GridPane grid = new GridPane();
        grid.setVgap(20);
		grid.setHgap(35);
		grid.setPadding((new Insets(12,6,6,12)));
		
		Label light = new Label("Light: ");
        grid.add(light, 3, 3);
        light.setFont(Font.font ("Verdana", 20));
        grid.add(lightComboBox, 4, 3);
        
        Label water = new Label("Water: ");
        grid.add(water, 5, 3);
        water.setFont(Font.font ("Verdana", 20));
        grid.add(waterComboBox, 6, 3);
        
        Label bloomtime = new Label("Bloom time: ");
        grid.add(bloomtime, 7, 3);
        bloomtime.setFont(Font.font ("Verdana", 20));
        grid.add(bloomtimeComboBox, 8, 3);
        
        Label food = new Label("Food: ");
        grid.add(food, 3, 5);
        food.setFont(Font.font ("Verdana", 20));
        grid.add(foodComboBox, 4, 5);
        
        Label bloomcolor = new Label("Bloom color: ");
        grid.add(bloomcolor, 5, 5);
        bloomcolor.setFont(Font.font ("Verdana", 20));
        grid.add(bloomcolorComboBox, 6, 5);
        
        Label soilreqs = new Label("Soil reqs: ");
        grid.add(soilreqs, 7, 5);
        soilreqs.setFont(Font.font ("Verdana", 20));
        grid.add(soilreqComboBox, 8, 5);
        root.setCenter(grid);
		root.setMargin(grid, new Insets(10,0,0,50));
      
        
        
        //root.getChildren().add(grid);
       // root.getChildren().add(label);
//        stage.setScene(scene);
//        stage.show();
	
        
        return new Scene(root, WIDTH, HEIGHT);
    }    
	
}