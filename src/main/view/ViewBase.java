package view;



import controller.Main;
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
	private EventHandler<? super MouseEvent> handlerP;
	private EventHandler<? super MouseEvent> handlerN;
	private final double WIDTH = 800;
	private final double HEIGHT = 600;
	
	/**
	 * Construct a view base.
	 * 
	 * @param stage the primary stage from {@link Main}
	 * @param labelText the text for the label
	 * @param handler the "back" button handler
	 */
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
		backButton.setOnMousePressed(handlerN);
//		Button closeButton = new Button("Close");
//		closeButton.setOnMousePressed(e -> stage.close());
		
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(backButton, nextButton);
		root.setBottom(bbar);

		return new Scene(root, WIDTH, HEIGHT);
	}
}
