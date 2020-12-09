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

/*
package drawingBoard;

import javafx.beans.property.Property;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.shape.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cue extends HBox
{
    private MainPane fa;
    private Label x = new Label("x: "), y = new Label("y: "), serial = new Label("serial number: "), lCommandBar = new Label("Command Bar");
    private TextField commandBar = new TextField();
    public void setSerial(String serial)
    {
        this.serial.setText("serial number: "+serial);
    }
    public Cue(MainPane fa)
    {
        super(50);
        this.fa = fa;
        x.textProperty().bind(fa.getMyCenter().getGetPos().x);
        y.textProperty().bind(fa.getMyCenter().getGetPos().y);
        
        
        
        lCommandBar.setPrefWidth(120);
        commandBar.setLayoutX(lCommandBar.getPrefWidth());
        commandBar.setFocusTraversable(false);
        commandBar.setOnKeyPressed(event ->
        {
            if(event.getCode().equals(KeyCode.TAB))
            {
                fa.getMyRight().getName().requestFocus();
            }
        });
        
        
        
        
        
        
        commandBar.setOnAction(event ->
        {
            Matcher matcher = Pattern.compile("([a-zA-Z]+)[ a-zA-Z0-9]*").matcher(commandBar.getText());
            if(matcher.matches())
            {
                try
                {
                    if(matcher.group(1).equalsIgnoreCase("find"))
                    {
                        matcher.usePattern(Pattern.compile("([0-9]{1,5})"));
                        matcher.reset();
                        if(matcher.find())
                        {
                            int number = Integer.parseInt(matcher.group());
                            if(number<fa.getMyCenter().getObject().getChildren().size())
                            {
                                fa.getMyRight().getSelected().clear();
                                Shape shape = (Shape) fa.getMyCenter().getObject().getChildren().get(number);
                                fa.getMyRight().addSelected((Shape) fa.getMyCenter().getObject().getChildren().get(number));
                                fa.getMyRight().change();
                                fa.getMyRight().changeItem(shape);
                                Thread thread = new Thread(()-> {
                                    try
                                    {
                                        shape.setStyle("-fx-fill: INDIANRED; -fx-stroke:INDIANRED");
                                        shape.setEffect(new Bloom(0.3));
                                        Thread.sleep(1000);
                                    }catch (InterruptedException e1)
                                    {
                                    }
                                    shape.setStyle(null);
                                    shape.setEffect(null);
                                });
                                thread.start();
                            }
                            else
                                new AlertBox("Cannot find.", "Error","I know", "Cancel");

                        }
                        else
                            new AlertBox("Invalid Parameter.", "Error","I know", "Cancel");
                    }
                    
                    
                    
                    
                    
                    
                    else if(matcher.group(1).equalsIgnoreCase("change"))
                    {
                        matcher.usePattern(Pattern.compile("([0-9]{1,5})[ ]+([0-9]{1,5})[ ]*"));
                        matcher.reset();
                        if(matcher.find())
                        {
                            int number1 = Integer.parseInt(matcher.group(1)), number2 = Integer.parseInt(matcher.group(2));
                            if(number1<fa.getMyCenter().getObject().getChildren().size()&&number2<fa.getMyCenter().getObject().getChildren().size())
                            {
                                Shape shape = (Shape) fa.getMyCenter().getObject().getChildren().get(number1);
                                ArrayList<Property> properties = fa.getMyRight().getObjectProperty().get(number1);
                                fa.getMyCenter().delete(shape);
                                fa.getMyCenter().getObject().getChildren().add(number2,shape);
                                fa.getMyRight().getObjectProperty().add(number2,properties);
                            }
                            else
                                new AlertBox("Cannot change.", "Error","I know", "Cancel");
                        }
                        else
                            new AlertBox("Invalid Parameters.", "Error","I know", "Cancel");

                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    else if(matcher.group(1).equalsIgnoreCase("create"))
                    {
                        matcher.usePattern(Pattern.compile("([a-zA-Z]+)"));
                        matcher.reset(commandBar.getText().split("[ ]+")[1]);
                        if(matcher.find())
                        {
                            switch (matcher.group(1).toLowerCase())
                            {
                                case "line":
                                    fa.getMyCenter().add(new Line());
                                    break;
                                case "ellipse":
                                    fa.getMyCenter().add(new Ellipse());
                                    break;
                                case "rectangle":
                                    fa.getMyCenter().add(new Rectangle());
                                    break;
                                case "polyline":
                                    fa.getMyCenter().add(new Polyline());
                                    break;
                            }
                        }
                        
                        
                        
                        
                        
                        
                        
                        else
                            new AlertBox("Invalid Type.", "Error","I know", "Cancel");
                    }
                    
                    
                    
                    
                    
                    else if(matcher.group(1).equalsIgnoreCase("delete"))
                    {
                        matcher.usePattern(Pattern.compile("([0-9]{1,5})"));
                        matcher.reset();
                        if(matcher.find())
                        {
                            int index = Integer.parseInt(matcher.group());
                            fa.getMyCenter().delete((Shape) fa.getMyCenter().getObject().getChildren().get(index));
                        }
                        else
                        {
                            matcher.usePattern(Pattern.compile("delete[ ]*"));
                            matcher.reset();
                            if (matcher.matches())
                            {
                                for (Shape shape : fa.getMyRight().getSelected())
                                    fa.getMyCenter().delete(shape);
                                fa.getMyRight().getSelected().clear();
                                fa.getMyRight().getLayout().getChildren().remove(1,fa.getMyRight().getLayout().getChildren().size());
                            }
                            else
                                new AlertBox("Invalid Input.", "Error","I know", "Cancel");
                        }
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    else
                    {
                        new AlertBox("Please input a valid command format.", "Error","I know", "Cancel");
                    }
                }catch (Exception e)
                {
                    new AlertBox("Please input a valid number.", "Error","I know", "Cancel");
                }
             
                commandBar.setText("");
            }
            
            
            
            
            
            
            else if(!commandBar.getText().equals(""))
            {
                new AlertBox("Please input a valid command format.", "Error","I know", "Cancel");
            }
        });
        
        
        
        commandBar.setStyle("-fx-base: #99c6ff");
        getChildren().addAll(x, y, serial, new Group(lCommandBar,commandBar));
    }
}




































































package drawingBoard;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;

public class MyCubicCurve implements Tool
{




    private int nowId=2;
    private CubicCurve currentCubicCurve;
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void press(MouseEvent e, Board pane)
    {
        if(!pane.getObject().getChildren().contains(currentCubicCurve))
        {
            nowId = 0;
            double x=e.getX()-pane.getWidth()/2,y=e.getY()-pane.getHeight()/2;
            currentCubicCurve = new CubicCurve(x, y, x, y, x, y, x, y);
            currentCubicCurve.setStrokeWidth(pane.fa.getMyLeft().getNowStrokeWidth());
            currentCubicCurve.setFill(pane.fa.getMyLeft().getColor());
            currentCubicCurve.setStroke(pane.fa.getMyLeft().getColor());
            pane.add(currentCubicCurve);
            return;
        }
        if(e.getButton().equals(MouseButton.SECONDARY))
        {
            nowId=2;return;
        }
        
        
        
        
        
        
        double x=e.getX()-pane.getWidth()/2,y=e.getY()-pane.getHeight()/2;
        nowId=(nowId+1)%3;
        switch (nowId)
        {
            case 0:
                currentCubicCurve = new CubicCurve(x, y, x, y, x, y, x, y);
                currentCubicCurve.setStrokeWidth(pane.fa.getMyLeft().getNowStrokeWidth());
                currentCubicCurve.setFill(pane.fa.getMyLeft().getColor());
                currentCubicCurve.setStroke(pane.fa.getMyLeft().getColor());
                pane.add(currentCubicCurve);
                break;
            case 1:
                currentCubicCurve.setControlX1(x);
                currentCubicCurve.setControlY1(y);
                break;
            case 2:
                currentCubicCurve.setControlX2(x);
                currentCubicCurve.setControlY2(y);
                break;
        }
    }



















    @Override
    public void drag(MouseEvent e, Board pane)
    {
        if(e.getButton().equals(MouseButton.SECONDARY)) return;

        double x=e.getX()-pane.getWidth()/2,y=e.getY()-pane.getHeight()/2;
        switch (nowId)
        {
            case 0:
                currentCubicCurve.setEndX(x);
                currentCubicCurve.setEndY(y);
                break;
            case 1:
                currentCubicCurve.setControlX1(x);
                currentCubicCurve.setControlY1(y);
                break;
            case 2:
                currentCubicCurve.setControlX2(x);
                currentCubicCurve.setControlY2(y);
                break;
        }
    }














    @Override
    public void release(MouseEvent e, Board pane)
    {
        if(e.getButton().equals(MouseButton.SECONDARY)) return;

        if(nowId != 0) return;
        double lengthSquare = (currentCubicCurve.getStartX()-currentCubicCurve.getEndX())*(currentCubicCurve.getStartX()-currentCubicCurve.getEndX())+(currentCubicCurve.getStartY()-currentCubicCurve.getEndY())*(currentCubicCurve.getStartY()-currentCubicCurve.getEndY());
        if(lengthSquare<4)
        {
            pane.delete(currentCubicCurve);
        }
        else if(lengthSquare<100)
        {
            AlertBox alertBox = new AlertBox("The object you draw is small, Do you still want to add it?", "Too Small", "yes", "no");
            if (alertBox.getMode() != 1)pane.delete(currentCubicCurve);
        }
    }
}*/







// Another way to build up a scence
