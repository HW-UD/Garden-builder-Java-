package view;

import controller.SurroundController;
import javafx.stage.Stage;

public class ViewSurround extends ViewBase {

//	public ViewDrag(Stage stage, EventHandler<? super MouseEvent> handlerP, EventHandler<? super MouseEvent> handlerN) {
//	super(stage, handlerP, handlerN);
//	// TODO Auto-generated constructor stub
//}

	/** Must inject a stage */
	public ViewSurround(Stage stage) {
		
		super(stage, e -> new SurroundController(stage).handleMousePress(e), e -> new SurroundController(stage).handleMousePress2(e));
//	root.setPadding(new Insets(10));
//	Label label = new Label(labelText);
//	label.setFont(new Font(32));
//	root.setCenter(label);
	}
	
	
}
