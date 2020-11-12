package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewAlertbox {

	
	
	public void display(String title , String message){
		    Stage window = new Stage();
		    window.setTitle("title");
		    window.initModality(Modality.APPLICATION_MODAL);
		    window.setMinWidth(300);
		    window.setMinHeight(150);

		    Button button = new Button("Close");
		    button.setOnAction(e -> window.close());

		    Text label = new Text(" Light: The phenomenon that plants control flowering by sensing the change of day and night length is called light cycle phenomenon, that is, the phenomenon that plants control physiological response by sensing the change of day and night length."
		    		+ "\n Water: The most abundant substance in plant cells is water, which is an essential component of plant body weight. With enough water, the stems, branches and leaves of the plant can stand upright and extend in the air, which is conducive to better photosynthesis of the plant."
		    		+ "\n Bloomtime: Temperature, humidity and light are important factors affecting the flowering time of plants."
		    		+ "\n Soil reqs: ph >7 is alkaline soil, ph=7 is neutral soil, and ph<7 is acidic soil. ");

		    VBox layout = new VBox(10);
		    layout.getChildren().addAll(label , button);
		    layout.setAlignment(Pos.CENTER);

		    Scene scene = new Scene(layout);
		    window.setScene(scene);
		    window.showAndWait();
		    }
}
