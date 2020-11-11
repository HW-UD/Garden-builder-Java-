package view;
import controller.DragController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class ViewDrag extends ViewBase {

//	public ViewDrag(Stage stage, EventHandler<? super MouseEvent> handlerP, EventHandler<? super MouseEvent> handlerN) {
//		super(stage, handlerP, handlerN);
//		// TODO Auto-generated constructor stub
//	}

	/** Must inject a stage */
	public ViewDrag(Stage stage) {
		super(stage, e -> new DragController(stage).handleMousePress(e), e -> new DragController(stage).handleMousePress2(e));
	}

}
