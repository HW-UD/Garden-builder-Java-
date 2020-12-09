////package view;
////
////public class UsedMethod {
////	
////	//package view;
////	//
////	//import java.util.ArrayList;
////	//
////	//import drawingBoard.AlertBox;
////	//import drawingBoard.Board;
////	//import drawingBoard.Geometry;
////	//import drawingBoard.Main;
////	//import drawingBoard.Tool;
////	//import javafx.scene.Cursor;
////	//import javafx.scene.Group;
////	//import javafx.scene.ImageCursor;
////	//import javafx.scene.Node;
////	//import javafx.scene.image.Image;
////	//import javafx.scene.input.MouseButton;
////	//import javafx.scene.input.MouseEvent;
////	//import javafx.scene.shape.Ellipse;
////	//import javafx.scene.shape.Line;
////	//import javafx.scene.shape.Polyline;
////	//import javafx.scene.shape.Shape;
////	//
////	////
////	////import java.io.Serializable;
////	////
////	////import javafx.application.Application;
////	////import javafx.event.EventHandler;
////	////import javafx.geometry.Pos;
////	////import javafx.scene.Scene;
////	////import javafx.scene.SnapshotParameters;
////	////import javafx.scene.control.Button;
////	////import javafx.scene.control.TextField;
////	////import javafx.scene.image.Image;
////	////import javafx.scene.image.ImageView;
////	////import javafx.scene.image.WritableImage;
////	////import javafx.scene.input.ClipboardContent;
////	////import javafx.scene.input.DataFormat;
////	////import javafx.scene.input.DragEvent;
////	////import javafx.scene.input.Dragboard;
////	////import javafx.scene.input.MouseEvent;
////	////import javafx.scene.input.TransferMode;
////	////import javafx.scene.layout.AnchorPane;
////	////import javafx.scene.layout.VBox;
////	////import javafx.stage.Stage;
////	////
////	//////Use another project to run
////	////
////	//////Use another project to run
////	////
////	//////Use another project to run
////	////
////	//////Use another project to run
////	//
////	////public class ViewMain extends Application{
////////		public static void main(String[] args) {
////////			launch(args);
////////		}
////////		public DataFormat person_format = new DataFormat("data/person");
////	////
////////		@Override
////////		public void start(Stage primaryStage) throws Exception {
////////			// TODO Auto-generated method stub
////////			Person person = new Person("sha","shenme","file:D:/java workspace/DragTest/img/1.png");
////////			
////////			
////////			VBox view = getDataPane();
////////			
////////			view.setStyle("-fx-background-color:#EAEAEA");
////////			
////////			TextField nameview = (TextField)view.getChildren().get(1);
////////			
////////			TextField ageview = (TextField)view.getChildren().get(2);
////////			
////////		//	TextField photoview = (ImageView)view.getChildren().get(3);
////////			
////////			nameview.setText(person.getName());
////////			
////////			ageview.setText(person.getAge());
////////		//	photoview.setImage(new Image(person.getPhoto()));
////////			
////////			
////////			AnchorPane an = new AnchorPane();
////////			
////////			Button button = new Button(person.getName());
////////			
////////			VBox datapane = getDataPane();
////////		//	datapane.setStyle("-fx-border-color:#ff000");
////////			an.getChildren().addAll(button,datapane);
////////			
////////			AnchorPane.setTopAnchor(button, 100.0);
////////			AnchorPane.setLeftAnchor(button,10.0);
////////			
////////			AnchorPane.setTopAnchor(datapane, 100.0);
////////			AnchorPane.setLeftAnchor(datapane,200.0);
////////			
////////			Scene scene = new Scene(an);
////////			primaryStage.setScene(scene);
////////			
////////			primaryStage.setTitle("shenmedongxi");
////////			primaryStage.setWidth(800);
////////			primaryStage.setHeight(900);
////////			primaryStage.show();
////////			
////////			
////////			button.setOnDragDetected(new EventHandler<MouseEvent>() {
////////				public void handle(MouseEvent event) {
////////					Dragboard db = button.startDragAndDrop(TransferMode.COPY_OR_MOVE);
////////					
////////					ClipboardContent content = new ClipboardContent();
////////					
////////					an.getChildren().add(view);
////////					
////////			//		WritableImage wi = new WritableImage((int)datapne.getPreWidth(0,(int)datapane.getPrefHeight()));
////////			//		view.snapshot(new SnapshotParameters(), wi);
////////					an.getChildren().remove(2);
////////			//		db.setDragView(wi);
////////					
////////					content.put(person_format,person);
////////					
////////					db.setContent(content);
////////					
////////				}
////////			});
////////			
////////			datapane.setOnDragOver(new EventHandler<DragEvent>() {
////////				public void handle(DragEvent event) {
////////					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
////////				}
////////			});
////////			
////////			datapane.setOnDragDropped(new EventHandler<DragEvent>() {
////////				
////////				public void handle(DragEvent event) {
////////					Dragboard db =event.getDragboard();
////////					
////////					Object obj = db.getContent(DataFormat.lookupMimeType("data/person"));
////////					
////////					Person p = (Person)obj;
////////					
////////					TextField name = (TextField)datapane.getChildren().get(1);
////////					
////////					TextField age = (TextField)datapane.getChildren().get(2);
////////					
////////					ImageView photo = (ImageView)datapane.getChildren().get(3);
////////					
////////					name.setText(p.getName());
////////					
////////					age.setText(p.getAge());
////////					
////////					photo.setImage(new Image(p.getPhoto()));
////////				}
////////			});
////////			
////////			
////////			
////////			
////////			
////////			
////////			
////////		}
////////		public VBox getDataPane() {
////////			VBox datapane = new VBox(10);
////////			
////////			datapane.setPrefWidth(300);
////////			datapane.setPrefWidth(500);
////////			
////////			Button bu = new Button("baqiao");
////////			bu.prefWidthProperty().bind(datapane.prefWidthProperty());
////////			
////////			TextField t1 = new TextField();
////////			t1.setAlignment(Pos.CENTER);
////////			
////////			TextField t2 = new TextField();
////////			t2.setAlignment(Pos.CENTER);
////////			
////////			ImageView iv = new ImageView();
////////			iv.setPreserveRatio(true);
////////			iv.setFitWidth(datapane.getPrefWidth());
////////			
////////			datapane.getChildren().addAll(bu,t1,t2,iv);
////////			
////////			return datapane;
////////			
////////			
////////		}
////	////
////	////}
////	////class Person implements Serializable{
////////		private String name;
////////		private String age;
////////		private String photo;
////	////	
////////		public Person(String name, String age, String photo) {
////////			this.name = name;
////////			this.age = age;
////////			this.photo = photo;
////////		}
////	////
////////		public String getName() {
////////			return name;
////////		}
////	////
////////		public void setName(String name) {
////////			this.name = name;
////////		}
////	////
////////		public String getAge() {
////////			return age;
////////		}
////	////
////////		public void setAge(String age) {
////////			this.age = age;
////////		}
////	////
////////		public String getPhoto() {
////////			return photo;
////////		}
////	////
////////		public void setPhoto(String photo) {
////////			this.photo = photo;
////////		}
////	////}
////	//
////
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////	//
////
////	/*
////	package drawingBoard;
////
////	import javafx.beans.property.Property;
////	import javafx.scene.Group;
////	import javafx.scene.control.Label;
////	import javafx.scene.control.TextField;
////	import javafx.scene.effect.Bloom;
////	import javafx.scene.input.KeyCode;
////	import javafx.scene.layout.HBox;
////	import javafx.scene.shape.*;
////
////	import java.util.ArrayList;
////	import java.util.regex.Matcher;
////	import java.util.regex.Pattern;
////
////	public class Cue extends HBox
////	{
////	    private MainPane fa;
////	    private Label x = new Label("x: "), y = new Label("y: "), serial = new Label("serial number: "), lCommandBar = new Label("Command Bar");
////	    private TextField commandBar = new TextField();
////	    public void setSerial(String serial)
////	    {
////	        this.serial.setText("serial number: "+serial);
////	    }
////	    public Cue(MainPane fa)
////	    {
////	        super(50);
////	        this.fa = fa;
////	        x.textProperty().bind(fa.getMyCenter().getGetPos().x);
////	        y.textProperty().bind(fa.getMyCenter().getGetPos().y);
////	        
////	        
////	        
////	        lCommandBar.setPrefWidth(120);
////	        commandBar.setLayoutX(lCommandBar.getPrefWidth());
////	        commandBar.setFocusTraversable(false);
////	        commandBar.setOnKeyPressed(event ->
////	        {
////	            if(event.getCode().equals(KeyCode.TAB))
////	            {
////	                fa.getMyRight().getName().requestFocus();
////	            }
////	        });
////	        
////	        
////	        
////	        
////	        
////	        
////	        commandBar.setOnAction(event ->
////	        {
////	            Matcher matcher = Pattern.compile("([a-zA-Z]+)[ a-zA-Z0-9]*").matcher(commandBar.getText());
////	            if(matcher.matches())
////	            {
////	                try
////	                {
////	                    if(matcher.group(1).equalsIgnoreCase("find"))
////	                    {
////	                        matcher.usePattern(Pattern.compile("([0-9]{1,5})"));
////	                        matcher.reset();
////	                        if(matcher.find())
////	                        {
////	                            int number = Integer.parseInt(matcher.group());
////	                            if(number<fa.getMyCenter().getObject().getChildren().size())
////	                            {
////	                                fa.getMyRight().getSelected().clear();
////	                                Shape shape = (Shape) fa.getMyCenter().getObject().getChildren().get(number);
////	                                fa.getMyRight().addSelected((Shape) fa.getMyCenter().getObject().getChildren().get(number));
////	                                fa.getMyRight().change();
////	                                fa.getMyRight().changeItem(shape);
////	                                Thread thread = new Thread(()-> {
////	                                    try
////	                                    {
////	                                        shape.setStyle("-fx-fill: INDIANRED; -fx-stroke:INDIANRED");
////	                                        shape.setEffect(new Bloom(0.3));
////	                                        Thread.sleep(1000);
////	                                    }catch (InterruptedException e1)
////	                                    {
////	                                    }
////	                                    shape.setStyle(null);
////	                                    shape.setEffect(null);
////	                                });
////	                                thread.start();
////	                            }
////	                            else
////	                                new AlertBox("Cannot find.", "Error","I know", "Cancel");
////
////	                        }
////	                        else
////	                            new AlertBox("Invalid Parameter.", "Error","I know", "Cancel");
////	                    }
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    else if(matcher.group(1).equalsIgnoreCase("change"))
////	                    {
////	                        matcher.usePattern(Pattern.compile("([0-9]{1,5})[ ]+([0-9]{1,5})[ ]*"));
////	                        matcher.reset();
////	                        if(matcher.find())
////	                        {
////	                            int number1 = Integer.parseInt(matcher.group(1)), number2 = Integer.parseInt(matcher.group(2));
////	                            if(number1<fa.getMyCenter().getObject().getChildren().size()&&number2<fa.getMyCenter().getObject().getChildren().size())
////	                            {
////	                                Shape shape = (Shape) fa.getMyCenter().getObject().getChildren().get(number1);
////	                                ArrayList<Property> properties = fa.getMyRight().getObjectProperty().get(number1);
////	                                fa.getMyCenter().delete(shape);
////	                                fa.getMyCenter().getObject().getChildren().add(number2,shape);
////	                                fa.getMyRight().getObjectProperty().add(number2,properties);
////	                            }
////	                            else
////	                                new AlertBox("Cannot change.", "Error","I know", "Cancel");
////	                        }
////	                        else
////	                            new AlertBox("Invalid Parameters.", "Error","I know", "Cancel");
////
////	                    }
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    else if(matcher.group(1).equalsIgnoreCase("create"))
////	                    {
////	                        matcher.usePattern(Pattern.compile("([a-zA-Z]+)"));
////	                        matcher.reset(commandBar.getText().split("[ ]+")[1]);
////	                        if(matcher.find())
////	                        {
////	                            switch (matcher.group(1).toLowerCase())
////	                            {
////	                                case "line":
////	                                    fa.getMyCenter().add(new Line());
////	                                    break;
////	                                case "ellipse":
////	                                    fa.getMyCenter().add(new Ellipse());
////	                                    break;
////	                                case "rectangle":
////	                                    fa.getMyCenter().add(new Rectangle());
////	                                    break;
////	                                case "polyline":
////	                                    fa.getMyCenter().add(new Polyline());
////	                                    break;
////	                            }
////	                        }
////	                        
////	                        
////	                        
////	                        
////	                        
////	                        
////	                        
////	                        else
////	                            new AlertBox("Invalid Type.", "Error","I know", "Cancel");
////	                    }
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    else if(matcher.group(1).equalsIgnoreCase("delete"))
////	                    {
////	                        matcher.usePattern(Pattern.compile("([0-9]{1,5})"));
////	                        matcher.reset();
////	                        if(matcher.find())
////	                        {
////	                            int index = Integer.parseInt(matcher.group());
////	                            fa.getMyCenter().delete((Shape) fa.getMyCenter().getObject().getChildren().get(index));
////	                        }
////	                        else
////	                        {
////	                            matcher.usePattern(Pattern.compile("delete[ ]*"));
////	                            matcher.reset();
////	                            if (matcher.matches())
////	                            {
////	                                for (Shape shape : fa.getMyRight().getSelected())
////	                                    fa.getMyCenter().delete(shape);
////	                                fa.getMyRight().getSelected().clear();
////	                                fa.getMyRight().getLayout().getChildren().remove(1,fa.getMyRight().getLayout().getChildren().size());
////	                            }
////	                            else
////	                                new AlertBox("Invalid Input.", "Error","I know", "Cancel");
////	                        }
////	                    }
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    
////	                    else
////	                    {
////	                        new AlertBox("Please input a valid command format.", "Error","I know", "Cancel");
////	                    }
////	                }catch (Exception e)
////	                {
////	                    new AlertBox("Please input a valid number.", "Error","I know", "Cancel");
////	                }
////	             
////	                commandBar.setText("");
////	            }
////	            
////	            
////	            
////	            
////	            
////	            
////	            else if(!commandBar.getText().equals(""))
////	            {
////	                new AlertBox("Please input a valid command format.", "Error","I know", "Cancel");
////	            }
////	        });
////	        
////	        
////	        
////	        commandBar.setStyle("-fx-base: #99c6ff");
////	        getChildren().addAll(x, y, serial, new Group(lCommandBar,commandBar));
////	    }
////	}
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////	package drawingBoard;
////
////	import javafx.scene.input.MouseButton;
////	import javafx.scene.input.MouseEvent;
////	import javafx.scene.paint.Color;
////	import javafx.scene.shape.CubicCurve;
////
////	public class MyCubicCurve implements Tool
////	{
////
////
////
////
////	    private int nowId=2;
////	    private CubicCurve currentCubicCurve;
////	    
////	    
////	    
////	    
////	    
////	    
////	    
////	    
////	    
////	    
////	    
////	    @Override
////	    public void press(MouseEvent e, Board pane)
////	    {
////	        if(!pane.getObject().getChildren().contains(currentCubicCurve))
////	        {
////	            nowId = 0;
////	            double x=e.getX()-pane.getWidth()/2,y=e.getY()-pane.getHeight()/2;
////	            currentCubicCurve = new CubicCurve(x, y, x, y, x, y, x, y);
////	            currentCubicCurve.setStrokeWidth(pane.fa.getMyLeft().getNowStrokeWidth());
////	            currentCubicCurve.setFill(pane.fa.getMyLeft().getColor());
////	            currentCubicCurve.setStroke(pane.fa.getMyLeft().getColor());
////	            pane.add(currentCubicCurve);
////	            return;
////	        }
////	        if(e.getButton().equals(MouseButton.SECONDARY))
////	        {
////	            nowId=2;return;
////	        }
////	        
////	        
////	        
////	        
////	        
////	        
////	        
////	        
////	        
////	        
////	        package drawingBoard;
////
////	import javafx.geometry.Pos;
////	import javafx.scene.Scene;
////	import javafx.scene.control.Button;
////	import javafx.scene.control.Label;
////	import javafx.scene.input.KeyCode;
////	import javafx.scene.layout.HBox;
////	import javafx.scene.layout.VBox;
////	import javafx.scene.paint.Color;
////	import javafx.stage.Modality;
////	import javafx.stage.Stage;
////	import javafx.stage.StageStyle;
////
////	public class AlertBox
////	{
////	    private int mode = 0;
////	    public AlertBox(String message , String title, String yes, String no)
////	    {
////	        Stage window = new Stage();
////	        window.initModality(Modality.APPLICATION_MODAL);
////	        window.initStyle(StageStyle.UTILITY);
////	        window.setTitle(title);
////	        window.setWidth(400);
////	        window.setHeight(200);
////	        HBox hb = new HBox(50);
////	        Button confirm = new Button(yes);
////	        Button deny = new Button(no);
////	        hb.getChildren().addAll(confirm, deny);
////	        confirm.setPrefWidth(100);
////	        deny.setPrefWidth(100);
////	        confirm.setStyle("-fx-base: Silver;-fx-background-radius: 50; -fx-text-fill:Green");
////	        deny.setStyle("-fx-base: Silver;-fx-background-radius: 50; -fx-text-fill:DarkRed");
////	        confirm.requestFocus();
////	        confirm.setOnKeyPressed(event ->
////	        {
////	            if(event.getCode().equals(KeyCode.ENTER))
////	            {
////	                this.mode = 1;
////	                window.close();
////	            }
////	        });
////	        deny.setOnKeyPressed(event ->
////	        {
////	            if(event.getCode().equals(KeyCode.ENTER))
////	            {
////	                this.mode = -1;
////	                window.close();
////	            }
////	        });
////	        confirm.setOnAction(e ->
////	        {
////	            this.mode=1;
////	            window.close();
////	        });
////	        deny.setOnAction(e ->
////	        {
////	            this.mode = -1;
////	            window.close();
////	        });
////	        Label label = new Label(message);
////	        VBox layout = new VBox(40);
////	        label.setTextFill(Color.INDIANRED);
////	        label.setStyle("-fx-font-weight: bold; -fx-font-size:16;");
////	        layout.getChildren().addAll(label , hb);
////	        hb.setAlignment(Pos.CENTER);
////	        layout.setAlignment(Pos.CENTER);
////	        layout.setStyle("-fx-background-color: linear-gradient(to right,#00fffc,#00ffcc,#fff600)");
////	        Scene scene = new Scene(layout);
////	        window.setScene(scene);
////	        window.showAndWait();
////	    }
////
////	    public int getMode()
////	    {
////	        return mode;
////	    }
////	}
////
////
////
////
////
////
////
////
////
////
////
////	        double x=e.getX()-pane.getWidth()/2,y=e.getY()-pane.getHeight()/2;
////	        nowId=(nowId+1)%3;
////	        switch (nowId)
////	        {
////	            case 0:
////	                currentCubicCurve = new CubicCurve(x, y, x, y, x, y, x, y);
////	                currentCubicCurve.setStrokeWidth(pane.fa.getMyLeft().getNowStrokeWidth());
////	                currentCubicCurve.setFill(pane.fa.getMyLeft().getColor());
////	                currentCubicCurve.setStroke(pane.fa.getMyLeft().getColor());
////	                pane.add(currentCubicCurve);
////	                break;
////	            case 1:
////	                currentCubicCurve.setControlX1(x);
////	                currentCubicCurve.setControlY1(y);
////	                break;
////	            case 2:
////	                currentCubicCurve.setControlX2(x);
////	                currentCubicCurve.setControlY2(y);
////	                break;
////	        }
////	    }
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////	    @Override
////	    public void drag(MouseEvent e, Board pane)
////	    {
////	        if(e.getButton().equals(MouseButton.SECONDARY)) return;
////
////	        double x=e.getX()-pane.getWidth()/2,y=e.getY()-pane.getHeight()/2;
////	        switch (nowId)
////	        {
////	            case 0:
////	                currentCubicCurve.setEndX(x);
////	                currentCubicCurve.setEndY(y);
////	                break;
////	            case 1:
////	                currentCubicCurve.setControlX1(x);
////	                currentCubicCurve.setControlY1(y);
////	                break;
////	            case 2:
////	                currentCubicCurve.setControlX2(x);
////	                currentCubicCurve.setControlY2(y);
////	                break;
////	        }
////	    }
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////	    @Override
////	    public void release(MouseEvent e, Board pane)
////	    {
////	        if(e.getButton().equals(MouseButton.SECONDARY)) return;
////
////	        if(nowId != 0) return;
////	        double lengthSquare = (currentCubicCurve.getStartX()-currentCubicCurve.getEndX())*(currentCubicCurve.getStartX()-currentCubicCurve.getEndX())+(currentCubicCurve.getStartY()-currentCubicCurve.getEndY())*(currentCubicCurve.getStartY()-currentCubicCurve.getEndY());
////	        if(lengthSquare<4)
////	        {
////	            pane.delete(currentCubicCurve);
////	        }
////	        else if(lengthSquare<100)
////	        {
////	            AlertBox alertBox = new AlertBox("The object you draw is small, Do you still want to add it?", "Too Small", "yes", "no");
////	            if (alertBox.getMode() != 1)pane.delete(currentCubicCurve);
////	        }
////	    }
////	}*/
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////	package drawingBoard;
////
////	import javafx.scene.input.MouseEvent;
////	import javafx.scene.paint.Color;
////	import javafx.scene.shape.Rectangle;
////
////	public class MyRectangle implements Tool
////	{
////	    private double originalX,originalY;
////	    private Rectangle currentRectangle = new Rectangle();
////	    @Override
////	    public void press(MouseEvent e, Board pane)
////	    {
////	        currentRectangle=new Rectangle(e.getX()-pane.getWidth()/2,e.getY()-pane.getHeight()/2,0,0);
////	        currentRectangle.setStrokeWidth(pane.fa.getMyLeft().getNowStrokeWidth());
////	        currentRectangle.setStroke(pane.fa.getMyLeft().getColor());
////	        currentRectangle.setFill(pane.fa.getMyLeft().getColor());
////	        originalX=e.getX()-pane.getWidth()/2;originalY=e.getY()-pane.getHeight()/2;pane.add(currentRectangle);
////	    }
////	    @Override
////	    public void drag(MouseEvent e, Board pane)
////	    {
////	        double x = e.getX()-pane.getWidth()/2, y = e.getY()-pane.getHeight()/2;
////	        if(e.isShiftDown())
////	        {
////	            double a = Math.max(Math.abs(originalX - x),Math.abs(originalY - y));
////	            currentRectangle.setWidth(a);
////	            currentRectangle.setHeight(a);
////	            currentRectangle.setX(x<originalX?originalX-a:originalX);
////	            currentRectangle.setY(y<originalY?originalY-a:originalY);
////	        }
////	        else
////	        {
////	            currentRectangle.setWidth(Math.abs(originalX - x));
////	            currentRectangle.setHeight(Math.abs(originalY - y));
////	            currentRectangle.setX(Math.min(originalX,x));
////	            currentRectangle.setY(Math.min(originalY, y));
//////	            }
////	        }
////	    }
////	    @Override
////	    public void release(MouseEvent e, Board pane)
////	    {
////	        if(currentRectangle.getWidth()<3&&currentRectangle.getHeight()<3)
////	        {
////	            pane.delete(currentRectangle);
////	        }
////	        else if(currentRectangle.getWidth()<20||currentRectangle.getHeight()<20)
////	        {
////	            AlertBox alertBox = new AlertBox("The object you draw is small, Do you still want to add it?", "Too Small", "yes", "no");
////	            if (alertBox.getMode() != 1)pane.delete(currentRectangle);
////	        }
////	    }
////	}
////
////
////
////
////	// Another way to build up a scence
////
////
////}
//
//
//
//
//
//
//
//
//package drawingBoard;
//
//import javafx.beans.property.*;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.event.EventType;
//import javafx.geometry.Orientation;
//import javafx.scene.Cursor;
//import javafx.scene.Group;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ScrollBar;
//import javafx.scene.control.TextField;
//import javafx.scene.effect.Bloom;
//import javafx.scene.effect.InnerShadow;
//import javafx.scene.effect.Light;
//import javafx.scene.effect.Lighting;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.*;
//import javafx.scene.text.Font;
//
//import java.util.*;
//
//public class PropertyBar extends Pane
//{
//    MainPane fa;
//    private Label name = new Label("Hello");
//    private ArrayList<ArrayList<Property>> objectProperty = new ArrayList<>();
//    private LinkedList<Shape> selected = new LinkedList<>();
//    private Shape nowShape;
//    private ScrollBar scrollBar = new ScrollBar();
//    private Group layout = new Group();
//    public ArrayList<ArrayList<Property>> getObjectProperty()
//    {
//        return objectProperty;
//    }
//    public Label getName()
//    {
//        return name;
//    }
//
//    //    private ArrayList<TreeMap<String,String>>objectProperty = new ArrayList<>();
//    public PropertyBar(MainPane fa)
//    {
////        prefWidthProperty().bind(fa.widthProperty().divide(7));
//        scrollBar.setOrientation(Orientation.VERTICAL);
//        scrollBar.setPrefWidth(20);
//        scrollBar.layoutXProperty().bind(prefWidthProperty().subtract(scrollBar.getPrefWidth()));
//        scrollBar.prefHeightProperty().bind(heightProperty());
//        getChildren().add(scrollBar);
//        scrollBar.valueProperty().addListener((value, pre, now)->
//        {
//            layout.setLayoutY(-now.doubleValue());
//        });
//        setOnScroll(event ->
//        {
//            scrollBar.setValue(scrollBar.getValue()-event.getDeltaY());
//        });
//
//        setPrefWidth(250);
//        this.fa=fa;
//        setStyle("-fx-background-color: linear-gradient(to top, SkyBlue, RoyalBlue, SkyBlue);");
//        setStyle("-fx-background-image: url(/image/right.png)");
//        Light.Point light = new Light.Point();
//        light.setColor(Color.LIGHTBLUE);
//        light.xProperty().bind(widthProperty().divide(2));
//        light.yProperty().bind(heightProperty().divide(2));
//        light.setZ(300);
//        Lighting lighting = new Lighting();
//        lighting.setLight(light);
//        lighting.setSurfaceScale(50.0);
//        InnerShadow innerShadow = new InnerShadow(), innerShadow1 = new InnerShadow();
//        innerShadow.setOffsetX(0.5);
//        innerShadow.setOffsetY(0.5);
//        innerShadow.setColor(Color.BLACK);
//        innerShadow1.setOffsetX(3);
//        innerShadow1.setOffsetY(3);
//        innerShadow1.setColor(Color.BLACK);
//        setEffect(innerShadow);
//
//
//        name.setFont(Font.font("Arial Black", 30));
//        name.setTextFill(Color.WHITE);
//        name.setLayoutX(40);
//        name.setEffect(innerShadow);
////        layout.getChildren().add(name);
//        Group group = new Group(name);
//        group.setEffect(new Bloom(0.1));
//        layout.getChildren().add(group);
//        getChildren().add(layout);
//
//    }
//    public void initBind()
//    {
//        DragToSuit dragToSuit = new DragToSuit(Main.getChangeCursor());
//        this.setOnMouseEntered(dragToSuit);
//        this.setOnMouseExited(dragToSuit);
//        this.setOnMouseMoved(dragToSuit);
//        this.setOnMouseDragged(dragToSuit);
//        this.setOnMousePressed(dragToSuit);
//        this.setOnMouseReleased(dragToSuit);
//    }
//    public class DragToSuit implements EventHandler<MouseEvent>
//    {
//        private ChangeCursor changeCursor;
//        private boolean pressed = false;
//        public DragToSuit(ChangeCursor changeCursor)
//        {
//            this.changeCursor = changeCursor;
//        }
//        @Override
//        public void handle(MouseEvent event)
//        {
//            if(event.getEventType().equals(MouseEvent.MOUSE_ENTERED))
//            {
//                if(event.getX()<10)
//                {
//                    Main.getScene().setCursor(Cursor.E_RESIZE);
//                }
//            }
//            else if(event.getEventType().equals(MouseEvent.MOUSE_EXITED))
//            {
//                Main.getScene().setCursor(changeCursor.future);
//            }
//            else if(event.getEventType().equals(MouseEvent.MOUSE_MOVED))
//            {
//                if(!pressed)
//                {
//                    if (event.getX() >= 10)
//                    {
//                        Main.getScene().setCursor(changeCursor.future);
//                    } else
//                    {
//                        Main.getScene().setCursor(Cursor.E_RESIZE);
//                    }
//                }
//            }
//            else if(event.getEventType().equals(MouseEvent.MOUSE_PRESSED))
//            {
//                if(event.getX()<10)
//                {
//                    pressed = true;
//                    setPrefWidth(getWidth()-event.getX());
//                }
//            }
//            else if(event.getEventType().equals(MouseEvent.MOUSE_DRAGGED))
//            {
//                if(pressed)
//                {
//                    setPrefWidth(getWidth()-event.getX());
//                }
//            }
//            else if(event.getEventType().equals(MouseEvent.MOUSE_RELEASED))
//            {
//                pressed = false;
//            }
//        }
//    }
//    public void setName(String name)
//    {
//        this.name.setText(name);
//    }
//    public void update(Shape shape)
//    {
//        delete(shape);
//        add(shape);
//    }
//    public void add(Shape shape)
//    {
//        add(shape, fa.getMyCenter().getObject().getChildren().indexOf(shape));
//    }
//    public void add(Shape shape, int index)
//    {
//        objectProperty.add(new ArrayList<>());
//        ArrayList<Property> now = objectProperty.get(index);
//        if(shape instanceof Line)//startX startY endX endY strokeWidth Color blendMode
//        {
//            Line line = (Line)shape;
//            now.add(shape.layoutXProperty());
//            now.add(shape.layoutYProperty());
//            now.add(line.startXProperty());
//            now.add(line.startYProperty());
//            now.add(line.endXProperty());
//            now.add(line.endYProperty());
//            now.add(line.strokeProperty());
//            now.add(line.rotateProperty());
//            now.add(line.strokeWidthProperty());
//        }
//        else if(shape instanceof CubicCurve)
//        {
//            CubicCurve curve = (CubicCurve)shape;
//            now.add(shape.layoutXProperty());
//            now.add(shape.layoutYProperty());
//            now.add(curve.startXProperty());
//            now.add(curve.startYProperty());
//            now.add(curve.endXProperty());
//            now.add(curve.endYProperty());
//            now.add(curve.controlX1Property());
//            now.add(curve.controlY1Property());
//            now.add(curve.controlX2Property());
//            now.add(curve.controlY2Property());
//            now.add(curve.strokeProperty());
//            now.add(curve.fillProperty());
//            now.add(curve.rotateProperty());
//            now.add(curve.strokeWidthProperty());
//        }
//        else if(shape instanceof Ellipse)
//        {
//            Ellipse ellipse = (Ellipse)shape;
//            now.add(shape.layoutXProperty());
//            now.add(shape.layoutYProperty());
//            now.add(ellipse.centerXProperty());
//            now.add(ellipse.centerYProperty());
//            now.add(ellipse.radiusXProperty());
//            now.add(ellipse.radiusYProperty());
//            now.add(ellipse.strokeProperty());
//            now.add(ellipse.fillProperty());
//            now.add(ellipse.rotateProperty());
//            now.add(ellipse.strokeWidthProperty());
//        }
//        else if(shape instanceof Rectangle)
//        {
//            Rectangle rectangle = (Rectangle)shape;
//            now.add(shape.layoutXProperty());
//            now.add(shape.layoutYProperty());
//            now.add(rectangle.xProperty());
//            now.add(rectangle.yProperty());
//            now.add(rectangle.widthProperty());
//            now.add(rectangle.heightProperty());
//            now.add(rectangle.strokeProperty());
//            now.add(rectangle.fillProperty());
//            now.add(rectangle.rotateProperty());
//            now.add(rectangle.strokeWidthProperty());
//        }
//        else if(shape instanceof Polyline)
//        {
//            Polyline polyline = (Polyline) shape;
//            PointsProperty last = new PointsProperty();
//            for(int i = 0; i<polyline.getPoints().size();i+=2)
//            {
//                PointsProperty x,y;
//                now.add(x = new PointsProperty(polyline, "x"+i/2, i));
//                now.add(y = new PointsProperty(polyline, "y"+i/2, i+1));
//                x.setPair(y);
//                y.setPair(x);
//                x.setNext(y);
//                if(last.getIndex() != -1)
//                {
//                    last.setNext(x);
//                }
//                last = y;
//            }
//            now.add(shape.layoutXProperty());
//            now.add(shape.layoutYProperty());
//            now.add(polyline.strokeProperty());
//            now.add(polyline.fillProperty());
//            now.add(polyline.rotateProperty());
//            now.add(polyline.strokeWidthProperty());
//        }
//    }
//    public void delete(Shape shape)
//    {
//        int i = fa.getMyCenter().getObject().getChildren().indexOf(shape);
//        if(i != -1)
//        {
//            delete(i);
//        }
//    }
//    private void delete(int i)
//    {
//        objectProperty.remove(i);
//    }
//    public void clear()
//    {
//        objectProperty.clear();
//    }
//    public void addSelected(Shape shape)
//    {
//        if(!selected.contains(shape))
//            selected.add(shape);
//        if(selected.size() == 1)nowShape = shape;
//        else nowShape = null;
//    }
//    public void deleteSelected(Shape shape)
//    {
//        selected.remove(shape);
//        if(selected.size() == 1)nowShape = selected.get(0);
//        else nowShape = null;
//    }
//    private TreeMap<String, ArrayList<Property>> check()
//    {
////        if(selected.size() == 1)
////        {
////            changeItem((Shape) fa.getMyCenter().getObject().getChildren().get(selected.get(0)));
////        }
////        else
////        {
//            TreeMap<String, ArrayList<Property>> temp = new TreeMap<>();
//            for(Shape shape:selected)
//            {
//                int index = fa.getMyCenter().getObject().getChildren().indexOf(shape);
//                if(temp.size()!=0)
//                {
//                    for(Property property:objectProperty.get(index))//当前各个属性
//                    {
//                        if(temp.containsKey(property.getName()))
//                        {
//                            temp.get(property.getName()).add(property);
//                        }
//                    }
//                }
//                else
//                {
//                    for(Property property:objectProperty.get(index))
//                    {
//                        temp.put(property.getName(),new ArrayList<>());
//                        temp.get(property.getName()).add(property);
//                    }
//                }
//            }
//            ArrayList<String> removeList = new ArrayList<>();
//           for(String name:temp.keySet())
//            {
//                if(temp.get(name).size() < selected.size())
//                {
//                    removeList.add(name);
//                }
//            }
//           for(String name: removeList)
//           {
//               temp.remove(name);
//           }
////        }
//        return temp;
//    }
//    public void change()
//    {
//        if(selected.size() == 0)
//        {
//            setName("");
//            layout.getChildren().remove(1,layout.getChildren().size());
//        }
//        if(selected.size() == 1)
//            changeItem(nowShape);
//        else if(selected.size() > 1)
//            changeGroup();
//    }
//    private void changeGroup()
//    {
//        setName("Group");
//        TreeMap<String,ArrayList<Property>> treeMap = check();
//        layout.getChildren().remove(1, layout.getChildren().size());
//        double y = name.getLayoutY() + 40;
//        for(String key:treeMap.keySet())
//        {
//            Label lKey = new Label(key);
//            lKey.setStyle("-fx-text-fill: #dedede");
//            TextField tValue = new TextField("");
//            lKey.setLayoutY(y+=40);
//            tValue.setLayoutY(y);
//            lKey.setLayoutX(5);
//            tValue.setLayoutX(getWidth()*2/5);
//            tValue.prefWidthProperty().bind(widthProperty().divide(2));
//            layout.getChildren().addAll(lKey, tValue);
//
//            changeValue(tValue, treeMap.get(key));
//        }
//        scrollBar.setMax(y);
//    }
//    public void changeItem(Shape shape)
//    {
//        if(shape instanceof Line)setName("Line");
//        else if(shape instanceof CubicCurve)setName("Curve");
//        else if(shape instanceof Ellipse)setName("Ellipse");
//        else if(shape instanceof Rectangle)setName("Rectangle");
//        else if(shape instanceof Polyline)setName("Polyline");
//        changeItem(shape, fa.getMyCenter().getObject().getChildren().indexOf(shape));
//    }
//    private void changeItem(Shape shape, int i)
//    {
//        layout.getChildren().remove(1,layout.getChildren().size());
//        double y = name.getLayoutY()+40;
////        if( i == -1)
////        {
////            System.out.println();
////        }
//        for(Property property: objectProperty.get(i))
//        {
//            Label key = new Label(property.getName());
//            key.setStyle("-fx-text-fill: #dedede");
//            TextField value = new TextField(property.getValue() != null?property.getValue().toString():"");
//            property.addListener((val, pre, now)->
//            {
//                value.setText(property.getValue() != null?property.getValue().toString():"");
//            });
//            key.setLayoutY(y+=40);
//            value.setLayoutY(y);
//            key.setLayoutX(5);
//            value.setLayoutX(getWidth()*2/5);
//            value.prefWidthProperty().bind(widthProperty().divide(2));
//            layout.getChildren().addAll(key, value);
//
//            changeValue(value,property);
//            if(property instanceof PointsProperty)
//            {
//                if(((PointsProperty)property).getIndex()%2 == 0)
//                {
//                    Button button = new Button("x");
//                    button.setStyle("-fx-text-fill: Red");
//                    ((PointsProperty) property).setTextField(value);
//                    button.setOnAction(event ->
//                    {
//                        objectProperty.get(i).remove(property);
//                        objectProperty.get(i).remove(((PointsProperty) property).getPair());
//                        ((PointsProperty) property).update();
//                        ((PointsProperty) property).getPair().update();
//                        value.disableProperty().set(true);
//                        button.setDisable(true);
//                        ((Polyline)shape).getPoints().remove(((PointsProperty)property).getIndex()+1);
//                        ((Polyline)shape).getPoints().remove(((PointsProperty)property).getIndex());
//                        if(((Polyline)shape).getPoints().isEmpty())
//                        {
//                            selected.clear();
//                            fa.getMyCenter().delete(shape);
//                            layout.getChildren().remove(1,layout.getChildren().size());
//                        }
//                    });
//                    button.setPrefWidth(30);
//                    button.setLayoutX(scrollBar.getLayoutX()-button.getPrefWidth());
////                    button.setLayoutX(value.getLayoutX()+value.getPrefWidth());
//                    button.setLayoutY(y);
//                    layout.getChildren().add(button);
//                }
//                else
//                {
//                    value.disableProperty().bind(((PointsProperty)property).getPair().getTextField().disabledProperty());
//                }
//            }
//        }
//        scrollBar.setMax(y);
//    }
//    private void changeValue(TextField value, ArrayList<Property> properties)
//    {
//        for(Property property:properties)
//            changeValue(value, property);
//    }
//    private void changeValue(TextField value, Property property)
//    {
//        value.addEventHandler(KeyEvent.KEY_PRESSED, event ->
//        {
//            if(event.getCode().equals(KeyCode.ENTER))
//            {
//                try
//                {
//                    if (property instanceof DoubleProperty && !value.getText().equals("")) property.setValue(Double.parseDouble(value.getText()));
//                    else if (!value.getText().equals("") && (property.getName().equals("fill") || property.getName().equals("stroke")))
//                    {
//                        property.setValue(Color.valueOf(value.getText()));
//                    }
//                } catch (Exception e)
//                {
//                    new AlertBox("Wrong Input", "Error", "I Know", "Cancel");
//                    value.setText(property.getValue() != null?property.getValue().toString():"");
//                }
//                name.requestFocus();
//            }
//        });
////        value.setOnKeyPressed(event ->
////        {
////            if(event.getCode().equals(KeyCode.ENTER))
////            {
////                try
////                {
////                    if (property instanceof DoubleProperty && !value.getText().equals("")) property.setValue(Double.parseDouble(value.getText()));
////                    else if (!value.getText().equals("") && (property.getName().equals("fill") || property.getName().equals("stroke")))
////                    {
////                        property.setValue(Color.valueOf(value.getText()));
////                    }
////                } catch (Exception e)
////                {
////                    new AlertBox("Wrong Input", "Error", "I Know", "Cancel");
////                    value.setText(property.getValue() != null?property.getValue().toString():"");
////                }
////                name.requestFocus();
////            }
////        });
//        value.focusedProperty().addListener((focused, pre, now) ->
//        {
//            if(!now)
//            {
//                try
//                {
//                    if(property instanceof DoubleProperty && !value.getText().equals(""))property.setValue(Double.parseDouble(value.getText()));
//                    else if(!value.getText().equals("") && (property.getName().equals("fill")||property.getName().equals("stroke")))
//                    {
//                        property.setValue(Color.valueOf(value.getText()));
//                    }
//                }catch (Exception e)
//                {
//                    new AlertBox("Wrong Input","Error","I Know","Cancel");
//                    value.setText(property.getValue() != null?property.getValue().toString():"");
//                }
//            }
//        });
//    }
//
//    public LinkedList<Shape> getSelected()
//    {
//        return selected;
//    }
//
//    public class PointsProperty extends SimpleDoubleProperty
//    {
//        private String name;
//        private int index = -1;
//        private PointsProperty pair,next;
//        private TextField textField;
//
//        public void setTextField(TextField textField)
//        {
//            this.textField = textField;
//        }
//
//        public TextField getTextField()
//        {
//            return textField;
//        }
//
//        public int getIndex()
//        {
//            return index;
//        }
//
//        public void setNext(PointsProperty next)
//        {
//            this.next = next;
//        }
//
//        public void update()
//        {
//            if(next != null)
//            {
//                next.index--;
//                next.update();
//            }
//        }
//
//        public PointsProperty getPair()
//        {
//            return pair;
//        }
//
//        public void setPair(PointsProperty pair)
//        {
//            this.pair = pair;
//        }
//        public PointsProperty()
//        {
//
//        }
//        public PointsProperty(Polyline polyline, String name, int index)
//        {
//            super(polyline.getPoints().get(index));
//            this.name = name;
//            this.index = index;
//            addListener((number, pre, now) ->
//            {
//                polyline.getPoints().set(index, (Double)now);
//            });
//        }
//        @Override
//        public String getName()
//        {
//            return name;
//        }
//
//    }
//
//    public Group getLayout()
//    {
//        return layout;
//    }
//    //    private class PositionProperty extends ObjectProperty<Pair<Double,Double>>
////    {
////        private Polyline polyline;
////        private Pair<Double,Double> position;
////        public PositionProperty(Polyline polyline, double x ,double y)
////        {
////            this.polyline = polyline;
////            position = new Pair<>(x,y);
////        }
////        @Override
////        public void bind(ObservableValue<? extends Pair<Double, Double>> observable)
////        {
////
////        }
////        @Override
////        public void unbind()
////        {
////
////        }
////        @Override
////        public boolean isBound()
////        {
////            return false;
////        }
////        @Override
////        public Object getBean()
////        {
////            return polyline;
////        }
////        @Override
////        public String getName()
////        {
////            return "(x,y)";
////        }
////
////        @Override
////        public Pair<Double, Double> get()
////        {
////            return null;
////        }
////
////        @Override
////        public void addListener(ChangeListener<? super Pair<Double, Double>> listener)
////        {
////            listener.changed(position,);
////        }
////
////        @Override
////        public void removeListener(ChangeListener<? super Pair<Double, Double>> listener)
////        {
////
////        }
////
////        @Override
////        public void addListener(InvalidationListener listener)
////        {
////
////        }
////
////        @Override
////        public void removeListener(InvalidationListener listener)
////        {
////
////        }
////
////        @Override
////        public void set(Pair<Double, Double> value)
////        {
////
////        }
////    }
////    public void changeItem(Shape shape)
////    {
////        changeItem(shape, fa.getMyCenter().getObject().getChildren().indexOf(shape));
////    }
////    public void changeItem(Shape shape, int i)
////    {
////        getChildren().remove(1,getChildren().size());
////        name.setText(objectProperty.get(i).get("type"));
////        double y = name.getLayoutY()+40;
////        for(Map.Entry<String,String> tuple : objectProperty.get(i).entrySet())
////        {
////            Label key = new Label(tuple.getKey());
////            TextField value = new TextField(tuple.getValue());
////            key.setLayoutY(y+=40);
////            value.setLayoutY(y);
////            key.setLayoutX(5);
////            value.setLayoutX(getWidth()*2/5);
////            value.prefWidthProperty().bind(widthProperty().divide(2));
////            getChildren().addAll(key, value);
////
////            switch (objectProperty.get(i).get("type"))
////            {
////                case "line":
////                    switch (tuple.getKey())
////                    {
////                        case "startX":
////                            changeDouble(shape, i, value, ((Line)shape).startXProperty());
////                            break;
////                        case "startY":
////                            changeDouble(shape, i, value, ((Line)shape).startYProperty());
////                            break;
////                        case "endX":
////                            changeDouble(shape, i, value, ((Line)shape).endXProperty());
////                            break;
////                        case "endY":
////                            changeDouble(shape, i, value, ((Line)shape).endYProperty());
////                            break;
////                        case "stroke":
////                            break;
////                        case "rotate":
////                            changeDouble(shape, i, value, shape.rotateProperty());
////                            break;
////                    }
////                    break;
////                case "ellipse":
////                    switch (tuple.getKey())
////                    {
////                        case "centerX":
////                            changeDouble(shape, i, value, ((Ellipse)shape).centerXProperty());
////                            break;
////                        case "centerY":
////                            changeDouble(shape, i, value, ((Ellipse)shape).centerYProperty());
////                            break;
////                        case "radiusX":
////                            changeDouble(shape, i, value, ((Ellipse)shape).radiusXProperty());
////                            break;
////                        case "radiusY":
////                            changeDouble(shape, i, value, ((Ellipse)shape).radiusYProperty());
////                            break;
////                        case "stroke":
////                            break;
////                        case "fill":
////                            break;
////                        case "rotate":
////                            changeDouble(shape, i, value, shape.rotateProperty());
////                            break;
////                    }
////                    break;
////                case "rectangle":
////                    switch (tuple.getKey())
////                    {
////                        case "x":
////                            changeDouble(shape, i, value, ((Rectangle)shape).xProperty());
////                            break;
////                        case "y":
////                            changeDouble(shape, i, value, ((Rectangle)shape).yProperty());
////                            break;
////                        case "width":
////                            changeDouble(shape, i, value, ((Rectangle)shape).widthProperty());
////                            break;
////                        case "height":
////                            changeDouble(shape, i, value, ((Rectangle)shape).heightProperty());
////                            break;
////                        case "stroke":
////                            break;
////                        case "fill":
////                            break;
////                        case "rotate":
////                            changeDouble(shape, i, value, shape.rotateProperty());
////                            break;
////                    }
////                    break;
////                case "polyline":
////                    switch (tuple.getKey())
////                    {
////                        case "rotate":
////                            changeDouble(shape, i, value, shape.rotateProperty());
////                            break;
////                    }
////            }
////        }
////    }
////    private void changeColor(Shape shape, int i, TextField value, StringProperty property)
////    {
////
////    }
////    private void changeDouble(Shape shape, int i, TextField value, DoubleProperty property)
////    {
////        value.setOnAction(event ->
////        {
////            try
////            {
////                property.set(Double.parseDouble(value.getText()));
////                objectProperty.get(i).replace(property.getName(),value.getText());
////            }catch (Exception e)
////            {
////                new AlertBox.md("Wrong Input","Error","I Know","Cancel");
////            }
////            name.requestFocus();
////        });
////        value.focusedProperty().addListener((focused, pre, now) ->
////        {
////            if(!now)
////            {
////                try
////                {
////                    property.set(Double.parseDouble(value.getText()));
////                    objectProperty.get(i).replace(property.getName(),value.getText());
////                }catch (Exception e)
////                {
////                    new AlertBox.md("Wrong Input","Error","I Know","Cancel");
////                }
////            }
////        });
////    }
//}
//
