package view;

//import java.awt.Label;

import controller.SurroundController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ViewSurround extends ViewBase {

//	public ViewDrag(Stage stage, EventHandler<? super MouseEvent> handlerP, EventHandler<? super MouseEvent> handlerN) {
//	super(stage, handlerP, handlerN);
//	// TODO Auto-generated constructor stub
//}

	@Override
	public Scene getScene() {
		BorderPane root = new BorderPane();
		
		root.setPadding(new Insets(10));
		Label label = new Label("Surronding");
		label.setFont(new Font(32));
		root.setCenter(label);
		
		Button backButton = new Button("Previous");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);
//		Button closeButton = new Button("Close");
//		closeButton.setOnMousePressed(e -> stage.close());
		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);

		return new Scene(root, WIDTH, HEIGHT);
	}
	
	
	/** Must inject a stage */
	public ViewSurround(Stage stage) {
		
		super(stage, e -> new SurroundController(stage).handleMousePress(e), e -> new SurroundController(stage).handleMousePress2(e));

	}
	
	
}
