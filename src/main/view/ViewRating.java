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


		int labelsize = 30;//size of label
		int hgap = 100;//size of Hgap
		int padding1 = 1;//padding number1
		int padding2 = 6;//padding number2
		int padding3 = 10;//padding number3
		int padding4 = 5;//padding number4
		int scenel = 1000;//length of scene
		int scenew = 600;//width of scene
		int margin1 = 100;//set margin number1
		int margin2 = 200;//set margin number2
		
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

//<<<<<<< HEAD
//
//=======
//		Label pl = new Label("List of Plants in Garden :");
//		pl.setFont(Font.font("Times New Roman", FontWeight.BOLD, labelsize));
//		v.getChildren().add(pl);
//		root.setTop(v);
//>>>>>>> branch 'main' of https://github.com/CISC275-F2020/project-team-14.git
        GridPane grid = new GridPane();
		
		grid.setHgap(hgap);
		grid.setPadding((new Insets(padding1,padding2,padding2,padding1)));
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
		bbar.setPadding(new Insets(padding3, padding4, padding4, padding3));
		
		
		// set the  space among plates
		BorderPane.setMargin(grid, new Insets(margin1,0,0,margin2));
		
//<<<<<<< HEAD
////	    System.out.println(ScoreComboBox.getEditor().getText());
//		Scene scene = new Scene(root, 1000, 600);
//=======

		Scene scene = new Scene(root, scenel, scenew);
//>>>>>>> branch 'main' of https://github.com/CISC275-F2020/project-team-14.git
		return scene;
	}
}
