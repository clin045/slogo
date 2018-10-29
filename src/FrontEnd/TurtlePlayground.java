package FrontEnd;

import Backend.TurtleManager;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/*
    Represents the area where turtle moves
    May be included in the turtle.java class
    @author xp19
 */

public class TurtlePlayground extends Pane {

    public static final double INIT_STROKE_WIDTH = 5;
    TurtleView turtleView; // possibly extend it to contain multiple turtles
    ArrayList<TurtleView> turtleViews;
    TurtleViewManager turtleViewManager;
    TurtleManager turtleManager;
    Map<Integer, Color> indexMap;
    Pen pen;

    // create a default white playground with one turtle
    public TurtlePlayground(TurtleView turtleView){
        setBgColor(Color.WHITE);
        this.turtleView = turtleView;
        addTurtleToCenter(turtleView.getTurtleImageView());
        pen = new Pen(this, true, Color.BLACK, INIT_STROKE_WIDTH);
    }

    // create a default white playground with many turtles
    public TurtlePlayground(TurtleViewManager turtleViewManager){
        setBgColor(Color.WHITE);
        turtleView = new TurtleView();
        this.turtleViewManager = turtleViewManager;
        this.turtleManager = turtleViewManager.getTurtleManager();
        turtleViews = new ArrayList<>();
        for(TurtleView view: turtleViewManager){
            turtleViews.add(view);
            addTurtleToCenter(view.getTurtleImageView());
        }
//        addTurtleToCenter(turtleView.getTurtleImageView());
        indexMap = new HashMap<>();
        indexMap.put(123, Color.RED);
        indexMap.put(456, Color.BLUE);
        indexMap.put(789, Color.YELLOW);
        pen = new Pen(this, true, Color.BLACK, INIT_STROKE_WIDTH);
    }

    // create a colored playground with one turtle
    public TurtlePlayground(TurtleView turtleView, Color color){
        setBgColor(color);
        this.turtleView = turtleView;
        addTurtleToCenter(turtleView.getTurtleImageView());
        pen = new Pen(this, true, Color.BLACK, INIT_STROKE_WIDTH);
    }

    // set the background color of this pane
    public void setBgColor(Color color){
        BackgroundFill primaryLayer = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(primaryLayer);
        this.setBackground(background);
    }

    public void setBgColor(int index){
        if(indexMap.containsKey(index)){
            setBgColor(indexMap.get(index));
        }
    }

    // update the turtle's position and leave trail if pen is down
    public void update(double x, double y, int id){
        double originX = turtleView.getX();
        double originY = turtleView.getY();
        double xpadding = turtleView.getWidth()/2;
        double ypadding = turtleView.getHeight()/2;
        turtleView.update(x,y);
        if(pen.isDown()){
            Line trail = pen.drawLine(new Point2D(originX+xpadding, originY+ypadding), new Point2D(turtleView.getX()+xpadding,turtleView.getY()+ypadding));
            this.getChildren().add(trail);
        }
    }

    public void leaveTrail(double originX, double originY, TurtleView view){
        double xpadding = turtleView.getWidth()/2;
        double ypadding = turtleView.getHeight()/2;
        if(pen.isDown()){
            Line trail = pen.drawLine(new Point2D(originX+xpadding, originY+ypadding), new Point2D(view.getX()+xpadding,view.getY()+ypadding));
            this.getChildren().add(trail);
        }
    }


    public TurtleView addNewTurtleToPlayground(Point2D position){
//        turtleViewManager.addTurtle();
        TurtleView view = new TurtleView(turtleManager, TurtleViewManager.ID);
        TurtleViewManager.ID++;
        turtleViewManager.addTurtleView(view);
        this.getChildren().add(view.getTurtleImageView());
        view.getTurtleImageView().setLayoutX(position.getX());
        view.getTurtleImageView().setLayoutY(position.getY());
        return view;
    }


    // put an additional turtle to the center of pane
    private void addTurtleToCenter(Node element){
        this.getChildren().add(element);
        this.widthProperty().addListener(e -> element.setLayoutX(this.getWidth() / 2.0 - turtleView.getWidth()/2));
        this.heightProperty().addListener(e -> element.setLayoutY(this.getHeight() / 2.0 - turtleView.getHeight()/2));
    }

    // setTurtleToHome turtles to its original position and
    public void setTurtleToHome(){
        turtleViews.get(0).getTurtleImageView().setLayoutX(this.getWidth()/2-turtleView.getWidth()/2);
        turtleViews.get(0).getTurtleImageView().setLayoutY(this.getHeight()/2-turtleView.getHeight()/2);
    }

    public void reset(){
        this.getChildren().clear();
        addTurtleToCenter(turtleViews.get(0).getTurtleImageView());
        setTurtleToHome();
        turtleView.resetTurtleHeading();
        ArrayList<Integer> list = new ArrayList<>();
//        if(turtleManager.getActiveTurtles().contains(turtleManager.getTurtleByID(1))){
            list.add(1);
//        }
        turtleManager.getActiveTurtles().clear();
        turtleManager.setActiveTurtlesByID(list);
    }

    public void setPenColor(Color color){
        pen.setColor(color);
    }

    public void setPenColor(int index){
        if(indexMap.containsKey(index)){
            pen.setColor(indexMap.get(index));
        }
    }

    public void setPenDown(boolean isPenDown){
        pen.setDown(isPenDown);
    }

    public void setPenThickNess(double width){
        pen.setThickness(width);
    }

    public void togglePenDown(){
        pen.togglePenDown();
    }

    public void setTurtlePosition(double x, double y){
        turtleView.getTurtleImageView().setLayoutX(x+this.getWidth()/2-turtleView.getWidth()/2);
        turtleView.getTurtleImageView().setLayoutY(y+this.getHeight()/2-turtleView.getHeight()/2);
    }

}
