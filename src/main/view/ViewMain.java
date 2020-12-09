//package view;
//
//import java.util.ArrayList;
//
//import drawingBoard.AlertBox;
//import drawingBoard.Board;
//import drawingBoard.Geometry;
//import drawingBoard.Main;
//import drawingBoard.Tool;
//import javafx.scene.Cursor;
//import javafx.scene.Group;
//import javafx.scene.ImageCursor;
//import javafx.scene.Node;
//import javafx.scene.image.Image;
//import javafx.scene.input.MouseButton;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.shape.Ellipse;
//import javafx.scene.shape.Line;
//import javafx.scene.shape.Polyline;
//import javafx.scene.shape.Shape;
//
////
////import java.io.Serializable;
////
////import javafx.application.Application;
////import javafx.event.EventHandler;
////import javafx.geometry.Pos;
////import javafx.scene.Scene;
////import javafx.scene.SnapshotParameters;
////import javafx.scene.control.Button;
////import javafx.scene.control.TextField;
////import javafx.scene.image.Image;
////import javafx.scene.image.ImageView;
////import javafx.scene.image.WritableImage;
////import javafx.scene.input.ClipboardContent;
////import javafx.scene.input.DataFormat;
////import javafx.scene.input.DragEvent;
////import javafx.scene.input.Dragboard;
////import javafx.scene.input.MouseEvent;
////import javafx.scene.input.TransferMode;
////import javafx.scene.layout.AnchorPane;
////import javafx.scene.layout.VBox;
////import javafx.stage.Stage;
////
//////Use another project to run
////
//////Use another project to run
////
//////Use another project to run
////
//////Use another project to run
//
////public class ViewMain extends Application{
////	public static void main(String[] args) {
////		launch(args);
////	}
////	public DataFormat person_format = new DataFormat("data/person");
////
////	@Override
////	public void start(Stage primaryStage) throws Exception {
////		// TODO Auto-generated method stub
////		Person person = new Person("sha","shenme","file:D:/java workspace/DragTest/img/1.png");
////		
////		
////		VBox view = getDataPane();
////		
////		view.setStyle("-fx-background-color:#EAEAEA");
////		
////		TextField nameview = (TextField)view.getChildren().get(1);
////		
////		TextField ageview = (TextField)view.getChildren().get(2);
////		
////	//	TextField photoview = (ImageView)view.getChildren().get(3);
////		
////		nameview.setText(person.getName());
////		
////		ageview.setText(person.getAge());
////	//	photoview.setImage(new Image(person.getPhoto()));
////		
////		
////		AnchorPane an = new AnchorPane();
////		
////		Button button = new Button(person.getName());
////		
////		VBox datapane = getDataPane();
////	//	datapane.setStyle("-fx-border-color:#ff000");
////		an.getChildren().addAll(button,datapane);
////		
////		AnchorPane.setTopAnchor(button, 100.0);
////		AnchorPane.setLeftAnchor(button,10.0);
////		
////		AnchorPane.setTopAnchor(datapane, 100.0);
////		AnchorPane.setLeftAnchor(datapane,200.0);
////		
////		Scene scene = new Scene(an);
////		primaryStage.setScene(scene);
////		
////		primaryStage.setTitle("shenmedongxi");
////		primaryStage.setWidth(800);
////		primaryStage.setHeight(900);
////		primaryStage.show();
////		
////		
////		button.setOnDragDetected(new EventHandler<MouseEvent>() {
////			public void handle(MouseEvent event) {
////				Dragboard db = button.startDragAndDrop(TransferMode.COPY_OR_MOVE);
////				
////				ClipboardContent content = new ClipboardContent();
////				
////				an.getChildren().add(view);
////				
////		//		WritableImage wi = new WritableImage((int)datapne.getPreWidth(0,(int)datapane.getPrefHeight()));
////		//		view.snapshot(new SnapshotParameters(), wi);
////				an.getChildren().remove(2);
////		//		db.setDragView(wi);
////				
////				content.put(person_format,person);
////				
////				db.setContent(content);
////				
////			}
////		});
////		
////		datapane.setOnDragOver(new EventHandler<DragEvent>() {
////			public void handle(DragEvent event) {
////				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
////			}
////		});
////		
////		datapane.setOnDragDropped(new EventHandler<DragEvent>() {
////			
////			public void handle(DragEvent event) {
////				Dragboard db =event.getDragboard();
////				
////				Object obj = db.getContent(DataFormat.lookupMimeType("data/person"));
////				
////				Person p = (Person)obj;
////				
////				TextField name = (TextField)datapane.getChildren().get(1);
////				
////				TextField age = (TextField)datapane.getChildren().get(2);
////				
////				ImageView photo = (ImageView)datapane.getChildren().get(3);
////				
////				name.setText(p.getName());
////				
////				age.setText(p.getAge());
////				
////				photo.setImage(new Image(p.getPhoto()));
////			}
////		});
////		
////		
////		
////		
////		
////		
////		
////	}
////	public VBox getDataPane() {
////		VBox datapane = new VBox(10);
////		
////		datapane.setPrefWidth(300);
////		datapane.setPrefWidth(500);
////		
////		Button bu = new Button("baqiao");
////		bu.prefWidthProperty().bind(datapane.prefWidthProperty());
////		
////		TextField t1 = new TextField();
////		t1.setAlignment(Pos.CENTER);
////		
////		TextField t2 = new TextField();
////		t2.setAlignment(Pos.CENTER);
////		
////		ImageView iv = new ImageView();
////		iv.setPreserveRatio(true);
////		iv.setFitWidth(datapane.getPrefWidth());
////		
////		datapane.getChildren().addAll(bu,t1,t2,iv);
////		
////		return datapane;
////		
////		
////	}
////
////}
////class Person implements Serializable{
////	private String name;
////	private String age;
////	private String photo;
////	
////	public Person(String name, String age, String photo) {
////		this.name = name;
////		this.age = age;
////		this.photo = photo;
////	}
////
////	public String getName() {
////		return name;
////	}
////
////	public void setName(String name) {
////		this.name = name;
////	}
////
////	public String getAge() {
////		return age;
////	}
////
////	public void setAge(String age) {
////		this.age = age;
////	}
////
////	public String getPhoto() {
////		return photo;
////	}
////
////	public void setPhoto(String photo) {
////		this.photo = photo;
////	}
////}
//
//private double leftx,lefty;
//private Ellipse currentEllipse = new Ellipse();
//@Override
//public void press(MouseEvent e, Board pane)
//{
//    currentEllipse=new Ellipse(e.getX()-pane.getWidth()/2,e.getY()-pane.getHeight()/2,0,0);
//    currentEllipse.setStrokeWidth(pane.fa.getMyLeft().getNowStrokeWidth());
//    currentEllipse.setFill(pane.fa.getMyLeft().getColor());
//    currentEllipse.setStroke(pane.fa.getMyLeft().getColor());
//    leftx=e.getX();lefty=e.getY();
//    pane.add(currentEllipse);
//}
//@Override
//public void drag(MouseEvent e, Board pane)
//{
//    if(e.isShiftDown())
//    {
//        currentEllipse.setRadiusX(Math.max(Math.abs(e.getX()-leftx)/2,Math.abs(e.getY()-lefty)/2));
//        currentEllipse.setRadiusY(Math.max(Math.abs(e.getX()-leftx)/2,Math.abs(e.getY()-lefty)/2));
//    }
//    else
//    {
//        currentEllipse.setRadiusX(Math.abs(e.getX()-leftx)/2);
//        currentEllipse.setRadiusY(Math.abs(e.getY()-lefty)/2);
//    }
//    currentEllipse.setCenterX((e.getX()+leftx)/2-pane.getWidth()/2);
//    currentEllipse.setCenterY((e.getY()+lefty)/2-pane.getHeight()/2);
//}
//@Override
//public void release(MouseEvent e, Board pane)
//{
//    if(currentEllipse.getRadiusX()<1&&currentEllipse.getRadiusY()<1)
//    {
//        pane.delete(currentEllipse);
//    }
//    else if(currentEllipse.getRadiusX()<20||currentEllipse.getRadiusY()<20)
//    {
//        AlertBox alertBox = new AlertBox("The object you draw is small, Do you still want to add it?", "Too Small", "yes", "no");
//        if (alertBox.getMode() != 1)pane.delete(currentEllipse);
//    }
//}
//
//
//
//
//
//
//
//
//
//public class MyEraser implements Tool
//{
//    @Override
//    public void press(MouseEvent e, Board pane)
//    {
//        Main.getScene().setCursor(new ImageCursor(new Image("image/rectangle.png"),100, 100));
//        delete(e.getX()-12.8-pane.getWidth()/2,e.getY()-12.8-pane.getHeight()/2,e.getX()+12.8-pane.getWidth()/2,e.getY()+12.8-pane.getHeight()/2,pane.getObject(), pane);
//    }
//
//    @Override
//    public void drag(MouseEvent e, Board pane)
//    {
////      pane.addEventFilter(MouseEvent.DRAG_DETECTED, event -> pane.startFullDrag());
//        delete(e.getX()-12.8-pane.getWidth()/2,e.getY()-12.8-pane.getHeight()/2,e.getX()+12.8-pane.getWidth()/2,e.getY()+12.8-pane.getHeight()/2,pane.getObject(), pane);
//    }
//
//    @Override
//    public void release(MouseEvent e, Board pane)
//    {
//        Main.getScene().setCursor(Cursor.DEFAULT);
//    }
//
//    private void delete(double x1, double y1, double x2, double y2, Group object, Board pane)
//    {
//        ArrayList<Shape> deleteBuffer = new ArrayList<>();
//        for(Node node:object.getChildren())
//            if(Geometry.inRange(x1,y1,x2,y2,node))
//            {
//                deleteBuffer.add((Shape)node);
//            }
//        for(Shape shape:deleteBuffer)
//        {
//            pane.fa.getMyRight().deleteSelected(shape);
//            pane.delete(shape);
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//public class MyLine extends Line implements Tool
//{
//    private Line currentLine = new Line();
//    @Override
//    public void press(MouseEvent e,Board pane)
//    {
//        currentLine=new Line(e.getX()-pane.getWidth()/2,e.getY()-pane.getHeight()/2,e.getX()-pane.getWidth()/2,e.getY()-pane.getHeight()/2);
//        currentLine.setStrokeWidth(pane.fa.getMyLeft().getNowStrokeWidth());
//        currentLine.setStroke(pane.fa.getMyLeft().getColor());
//        pane.add(currentLine);
//    }
//    @Override
//    public void drag(MouseEvent e,Board pane)
//    {
//        currentLine.setEndX(e.getX()-pane.getWidth()/2);
//        currentLine.setEndY(e.getY()-pane.getHeight()/2);
//    }
//    @Override
//    public void release(MouseEvent e, Board pane)
//    {
//        double lengthSquare = (currentLine.getStartX()-currentLine.getEndX())*(currentLine.getStartX()-currentLine.getEndX())+(currentLine.getStartY()-currentLine.getEndY())*(currentLine.getStartY()-currentLine.getEndY());
//        if(lengthSquare<4)
//        {
//            pane.delete(currentLine);
//        }
//        else if(lengthSquare<100)
//        {
//            AlertBox alertBox = new AlertBox("The object you draw is small, Do you still want to add it?", "Too Small", "yes", "no");
//            if (alertBox.getMode() != 1)pane.delete(currentLine);
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//public class MyPolyline implements Tool
//{
//    private Polyline currentPolyline =new Polyline();
//    @Override
//    public void press(MouseEvent e, Board pane)
//    {
//        if(!pane.getObject().getChildren().contains(currentPolyline))
//        {
//            currentPolyline =new Polyline();
//            currentPolyline.setStrokeWidth(pane.fa.getMyLeft().getNowStrokeWidth());
//            currentPolyline.setFill(pane.fa.getMyLeft().getColor());
//            currentPolyline.setStroke(pane.fa.getMyLeft().getColor());
//            if(currentPolyline.getPoints().isEmpty())
//            {
//                pane.add(currentPolyline);
//                currentPolyline.getPoints().addAll(e.getX()-pane.getWidth()/2, e.getY()-pane.getHeight()/2);
//            }
//            currentPolyline.getPoints().addAll(e.getX()-pane.getWidth()/2, e.getY()-pane.getHeight()/2);
//            return;
//        }
//        if(e.getButton().equals(MouseButton.SECONDARY))
//        {
//            if(currentPolyline.getPoints().isEmpty()) return;
//
//            currentPolyline.getPoints().addAll(currentPolyline.getPoints().get(0), currentPolyline.getPoints().get(1));
//            currentPolyline.setStrokeWidth(pane.fa.getMyLeft().getNowStrokeWidth());
//            currentPolyline.setStroke(pane.fa.getMyLeft().getColor());
//            currentPolyline.setFill(pane.fa.getMyLeft().getColor());
//            pane.fa.getMyRight().update(currentPolyline);
//            currentPolyline =new Polyline();
//            return;
//        }
//        currentPolyline.setStrokeWidth(pane.fa.getMyLeft().getNowStrokeWidth());
//        currentPolyline.setFill(pane.fa.getMyLeft().getColor());
//        currentPolyline.setStroke(pane.fa.getMyLeft().getColor());
//        if(currentPolyline.getPoints().isEmpty())
//        {
//            pane.add(currentPolyline);
//            currentPolyline.getPoints().addAll(e.getX()-pane.getWidth()/2, e.getY()-pane.getHeight()/2);
//        }
//        currentPolyline.getPoints().addAll(e.getX()-pane.getWidth()/2, e.getY()-pane.getHeight()/2);
//    }
//
//    @Override
//    public void drag(MouseEvent e, Board pane)
//    {
//        if(e.getButton().equals(MouseButton.SECONDARY)) return;
//        currentPolyline.getPoints().remove(currentPolyline.getPoints().size()-1);
//        currentPolyline.getPoints().remove(currentPolyline.getPoints().size()-1);
//        currentPolyline.getPoints().addAll(e.getX()-pane.getWidth()/2, e.getY()-pane.getHeight()/2);
//    }
//
//    @Override
//    public void release(MouseEvent e, Board pane)
//    {
//
//    }
//}
