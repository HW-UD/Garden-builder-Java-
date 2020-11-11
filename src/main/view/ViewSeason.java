package view;

import controller.SeasonController;
import javafx.stage.Stage;

public class ViewSeason extends ViewBase {
	
	//	public ViewDrag(Stage stage, EventHandler<? super MouseEvent> handlerP, EventHandler<? super MouseEvent> handlerN) {
	//	super(stage, handlerP, handlerN);
	//	// TODO Auto-generated constructor stub
	//}
	
	/** Must inject a stage */
	public ViewSeason(Stage stage) {
		super(stage, e -> new SeasonController(stage).handleMousePress(e), e -> new SeasonController(stage).handleMousePress2(e));
	}
	
}
