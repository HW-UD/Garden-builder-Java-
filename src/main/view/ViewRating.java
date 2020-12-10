package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import controller.RatingController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.util.ArrayList;


public class ViewRating implements ViewMaker {
	
	private Stage stage;
	public VBox v;
	FlowPane flowpane = new FlowPane();

	
	/** Must inject a stage */
	public ViewRating(Stage stage) {
		this.stage = stage;
		v = new VBox();

}
	
	
	public VBox getV() {
		return v;
	}



	public void setV(VBox v) {
		this.v = v;
	}



	@Override
	public Scene getScene() {
		
		
		RatingController controller = new RatingController(stage);
		BorderPane root = new BorderPane();
		
		flowpane.setPrefWidth(1000);
		flowpane.getChildren().add(v);
		ScrollPane scrollPane = new ScrollPane(flowpane);
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		root.setCenter(scrollPane);
		
		// set the background
//		Image background = new Image("file:src/main/img/rating/background.png");
//		ImageView bk = new ImageView();
//    	bk.setImage(background);
//    	root.getChildren().add(bk);
        
   

		ArrayList<ImageView> arrayList = new ArrayList<>();


        GridPane grid = new GridPane();
		
		grid.setHgap(100);
		grid.setPadding((new Insets(1,6,6,1)));
		root.setLeft(grid);
		
		// get the buttons
		Button backButton = new Button("Back");
		backButton.setOnMousePressed(e -> controller.handleOnPressButton1(e));
		Button closeButton = new Button("Close");
		closeButton.setOnMousePressed(e -> stage.close());
		ButtonBar bbar = new ButtonBar();
		bbar.getButtons().addAll(backButton, closeButton);
		root.setBottom(bbar);
		
		// set the space between margins and buttons
		bbar.setPadding(new Insets(10, 5, 5, 10));
		
		
		// set the  space among plates
		BorderPane.setMargin(grid, new Insets(100,0,0,200));
		
//	    System.out.println(ScoreComboBox.getEditor().getText());
		Scene scene = new Scene(root, 1000, 600);
		return scene;
	}
}
