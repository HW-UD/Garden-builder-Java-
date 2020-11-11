package view;

import controller.DragController;
import controller.ViewFencesController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewFences  extends ViewBase{
	public Scene getScene() {
		BorderPane root = new BorderPane();
		
		root.setPadding(new Insets(10));
		Label label = new Label("Choose Fences");
		label.setFont(new Font(32));
		root.setCenter(label);
		
		Button backButton = new Button("Previous");
		backButton.setOnMousePressed(handlerP);
		Button nextButton = new Button("Next");
		nextButton.setOnMousePressed(handlerN);

		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);

		return new Scene(root, WIDTH, HEIGHT);
	}
    public ViewFences (Stage stage) {
	       //   super(stage, "Choose fences", e -> new ViewFencesController(stage).handleMousePress(e));
    	super(stage, e -> new ViewFencesController(stage).handleMousePress(e), e -> new ViewFencesController(stage).handleMousePress2(e));
   }
}
