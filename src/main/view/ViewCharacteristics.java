package view;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewCharacteristics  {
	private Stage stage;

	public ViewCharacteristics(Stage stage) {
		this.stage = stage;
		// TODO Auto-generated constructor stub
	}
	public Scene getScene() {
        stage.setTitle("ComboBoxSample");
        Scene scene = new Scene(new Group(), 1000, 600);
        Label label = new Label("Identify your plant characteristics");
        label.setFont(new Font(32));
        
        final ComboBox lightComboBox = new ComboBox();
        lightComboBox.getItems().addAll("1111111"
            
        );
        
        final ComboBox waterComboBox = new ComboBox();
        waterComboBox.getItems().addAll("1111111"
            
        );
        
        final ComboBox bloomtimeComboBox = new ComboBox();
        bloomtimeComboBox.getItems().addAll("1111111"
            
        );
        
        final ComboBox foodComboBox = new ComboBox();
        foodComboBox.getItems().addAll("1111111"
            
        );
        
        final ComboBox bloomcolorComboBox = new ComboBox();
        bloomcolorComboBox.getItems().addAll("1111111"
            
        );
        
        final ComboBox soilreqComboBox = new ComboBox();
        soilreqComboBox.getItems().addAll("12123"
            
        );   
        
        Button nextButton = new Button("Next");
        Button backButton = new Button("Back");
 
       
        
        GridPane grid = new GridPane();
        grid.setVgap(20);
		grid.setHgap(35);
		grid.setPadding((new Insets(12,6,6,12)));
        grid.add(new Label("Light: "), 3, 3);
        grid.add(lightComboBox, 4, 3);
        grid.add(new Label("Water: "), 5, 3);
        grid.add(waterComboBox, 6, 3);
        grid.add(new Label("Bloom time: "), 7, 3);
        grid.add(bloomtimeComboBox, 8, 3);
        grid.add(new Label("Food: "), 3, 5);
        grid.add(foodComboBox, 4, 5);
        grid.add(new Label("Bloom color: "), 5, 5);
        grid.add(bloomcolorComboBox, 6, 5);
        grid.add(new Label("Soil req: "), 7, 5);
        grid.add(soilreqComboBox, 8, 5);
        grid.add(nextButton, 9, 23);
		nextButton.setMinHeight(30);
		nextButton.setMinWidth(90);
		grid.add(backButton, 1, 23);
		backButton.setMinHeight(30);
		backButton.setMinWidth(90);
       
      
        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        root.getChildren().add(label);
        stage.setScene(scene);
        stage.show();
        
        return scene;
    }    
}