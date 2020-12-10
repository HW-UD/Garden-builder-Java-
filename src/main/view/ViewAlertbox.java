package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The Alertbox for the instruction button
 * 
 * @author Benny Li
 * @version final
 */
public class ViewAlertbox {
	public final int WinWidth = 600;// The width for the AlertBox
	public final int WinLength = 450;// The length for the AlertBox
	public final int TitleSize = 30;// The size for the title
	public final int TextSize = 20;// The size for the text

	/**
	 * Display Instructions for each button in the ViewDrag when the "Instruction"
	 * button is clicked
	 * 
	 * @param none
	 * 
	 * @author Benny Li
	 * @version final
	 */
	public void display() {
		Stage window = new Stage();
		window.setTitle("Instruction");
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(WinWidth);
		window.setHeight(WinLength);

		Button button = new Button("Close");
		button.setOnAction(e -> window.close());

		Label label1 = new Label("Draw:");
		label1.setTextFill(Color.web("#0076a3"));
		// Use a constructor of the Font class
		label1.setFont(new Font("Arial", TitleSize));

		Label label2 = new Label(
				"Click by using mouse left key to start drawing your garden, once you release the mouse,it stops drawing.");
		label2.setFont(new Font("Arial", TextSize));

		label2.setWrapText(true);

		Label label3 = new Label("Delete:");
		label3.setTextFill(Color.web("#0076a3"));
		label3.setFont(new Font("Arial", TitleSize));

		Label label4 = new Label(
				"Choose the plants you want to delete, then doubleclick that plant by leftmouse button.");
		label4.setFont(new Font("Arial", TextSize));
		label4.setWrapText(true);

		Label label5 = new Label("Clear:");
		label5.setTextFill(Color.web("#0076a3"));
		label5.setFont(new Font("Arial", TitleSize));

		Label label6 = new Label("Clear all the plants and garden in this page.");
		label6.setFont(new Font("Arial", TextSize));
		label6.setWrapText(true);

		Label label7 = new Label("Save:");
		label7.setTextFill(Color.web("#0076a3"));
		label7.setFont(new Font("Arial", TitleSize));

		Label label8 = new Label("Enter your garden name and save your garden.");
		label8.setFont(new Font("Arial", TextSize));
		label8.setWrapText(true);

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, label8, button);
		layout.setAlignment(Pos.TOP_LEFT);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
