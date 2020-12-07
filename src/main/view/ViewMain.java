package view;

//
//import java.io.Serializable;
//
//import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.SnapshotParameters;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.image.WritableImage;
//import javafx.scene.input.ClipboardContent;
//import javafx.scene.input.DataFormat;
//import javafx.scene.input.DragEvent;
//import javafx.scene.input.Dragboard;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.input.TransferMode;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
////Use another project to run
//
////Use another project to run
//
////Use another project to run
//
////Use another project to run

//public class ViewMain extends Application{
//	public static void main(String[] args) {
//		launch(args);
//	}
//	public DataFormat person_format = new DataFormat("data/person");
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		Person person = new Person("sha","shenme","file:D:/java workspace/DragTest/img/1.png");
//		
//		
//		VBox view = getDataPane();
//		
//		view.setStyle("-fx-background-color:#EAEAEA");
//		
//		TextField nameview = (TextField)view.getChildren().get(1);
//		
//		TextField ageview = (TextField)view.getChildren().get(2);
//		
//	//	TextField photoview = (ImageView)view.getChildren().get(3);
//		
//		nameview.setText(person.getName());
//		
//		ageview.setText(person.getAge());
//	//	photoview.setImage(new Image(person.getPhoto()));
//		
//		
//		AnchorPane an = new AnchorPane();
//		
//		Button button = new Button(person.getName());
//		
//		VBox datapane = getDataPane();
//	//	datapane.setStyle("-fx-border-color:#ff000");
//		an.getChildren().addAll(button,datapane);
//		
//		AnchorPane.setTopAnchor(button, 100.0);
//		AnchorPane.setLeftAnchor(button,10.0);
//		
//		AnchorPane.setTopAnchor(datapane, 100.0);
//		AnchorPane.setLeftAnchor(datapane,200.0);
//		
//		Scene scene = new Scene(an);
//		primaryStage.setScene(scene);
//		
//		primaryStage.setTitle("shenmedongxi");
//		primaryStage.setWidth(800);
//		primaryStage.setHeight(900);
//		primaryStage.show();
//		
//		
//		button.setOnDragDetected(new EventHandler<MouseEvent>() {
//			public void handle(MouseEvent event) {
//				Dragboard db = button.startDragAndDrop(TransferMode.COPY_OR_MOVE);
//				
//				ClipboardContent content = new ClipboardContent();
//				
//				an.getChildren().add(view);
//				
//		//		WritableImage wi = new WritableImage((int)datapne.getPreWidth(0,(int)datapane.getPrefHeight()));
//		//		view.snapshot(new SnapshotParameters(), wi);
//				an.getChildren().remove(2);
//		//		db.setDragView(wi);
//				
//				content.put(person_format,person);
//				
//				db.setContent(content);
//				
//			}
//		});
//		
//		datapane.setOnDragOver(new EventHandler<DragEvent>() {
//			public void handle(DragEvent event) {
//				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//			}
//		});
//		
//		datapane.setOnDragDropped(new EventHandler<DragEvent>() {
//			
//			public void handle(DragEvent event) {
//				Dragboard db =event.getDragboard();
//				
//				Object obj = db.getContent(DataFormat.lookupMimeType("data/person"));
//				
//				Person p = (Person)obj;
//				
//				TextField name = (TextField)datapane.getChildren().get(1);
//				
//				TextField age = (TextField)datapane.getChildren().get(2);
//				
//				ImageView photo = (ImageView)datapane.getChildren().get(3);
//				
//				name.setText(p.getName());
//				
//				age.setText(p.getAge());
//				
//				photo.setImage(new Image(p.getPhoto()));
//			}
//		});
//		
//		
//		
//		
//		
//		
//		
//	}
//	public VBox getDataPane() {
//		VBox datapane = new VBox(10);
//		
//		datapane.setPrefWidth(300);
//		datapane.setPrefWidth(500);
//		
//		Button bu = new Button("baqiao");
//		bu.prefWidthProperty().bind(datapane.prefWidthProperty());
//		
//		TextField t1 = new TextField();
//		t1.setAlignment(Pos.CENTER);
//		
//		TextField t2 = new TextField();
//		t2.setAlignment(Pos.CENTER);
//		
//		ImageView iv = new ImageView();
//		iv.setPreserveRatio(true);
//		iv.setFitWidth(datapane.getPrefWidth());
//		
//		datapane.getChildren().addAll(bu,t1,t2,iv);
//		
//		return datapane;
//		
//		
//	}
//
//}
//class Person implements Serializable{
//	private String name;
//	private String age;
//	private String photo;
//	
//	public Person(String name, String age, String photo) {
//		this.name = name;
//		this.age = age;
//		this.photo = photo;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAge() {
//		return age;
//	}
//
//	public void setAge(String age) {
//		this.age = age;
//	}
//
//	public String getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(String photo) {
//		this.photo = photo;
//	}
//}
