package view;



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

//import net.snortum.javafx.multiscene.Main;

public class ViewBase implements ViewMaker {

	private Stage stage;
	protected EventHandler<? super MouseEvent> handlerP;
	protected EventHandler<? super MouseEvent> handlerN;
	protected final double WIDTH = 800;
	protected final double HEIGHT = 600;
	

	public ViewBase(Stage stage, EventHandler<? super MouseEvent> handlerP,EventHandler<? super MouseEvent> handlerN) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		if (handlerP == null) {
			throw new IllegalArgumentException("Handler cannot be null");
		}
		
		this.stage = stage;
		this.handlerP = handlerP;
		this.handlerN = handlerN;
	}

	@Override
	public Scene getScene() {
		BorderPane root = new BorderPane();
////		root.setPadding(new Insets(10));
//		Label label = new Label(labelText);
//		label.setFont(new Font(32));
//		root.setCenter(label);
		
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
}
