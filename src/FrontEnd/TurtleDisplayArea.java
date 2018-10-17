package FrontEnd;

import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/*
    Represents the area where turtle moves
    @author xp19
 */

public class TurtleDisplayArea extends Pane {

    TurtleView turtleView;
    Pen pen;

    public TurtleDisplayArea(TurtleView turtleView){
        setBgColor(Color.WHITE);
        this.turtleView = turtleView;
        addTurtle(turtleView.getTurtleImageView());
        pen = new Pen(this, true, Color.BLACK, 10);
    }

    public TurtleDisplayArea(TurtleView turtleView, Color color){
        setBgColor(color);
        this.turtleView = turtleView;
        addTurtle(turtleView.getTurtleImageView());
        pen = new Pen(this, true, Color.BLACK, 10);
    }

    // set the background color of this pane
    public void setBgColor(Color color){
        BackgroundFill primaryLayer = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(primaryLayer);
        this.setBackground(background);
    }

    public void update(double x, double y){
//        Line trail = pen.drawLine(new Point2D(turtleView.getX(), turtleView.getY()), new Point2D(x,y));
//        Line line = new Line(10,10,80,80);
        System.out.println(turtleView.getX()+":"+turtleView.getY());
        Line trail = new Line(turtleView.getX(), turtleView.getY(), x, y);
        turtleView.update(x,y);
        this.getChildren().add(trail);
//        this.getChildren().add(line);
    }

    // put an additional turtle to the center of pane
    private void addTurtle(Node element){
        this.getChildren().add(element);
        this.widthProperty().addListener(e -> element.setLayoutX(this.getWidth() / 2.0));
        this.heightProperty().addListener(e -> element.setLayoutY(this.getHeight() / 2.0));
    }


}
