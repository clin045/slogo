package FrontEnd;

import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/*
    Represents the area where turtle moves
    @author xp19
 */

public class TurtlePlayground extends Pane {

    TurtleView turtleView;
    Pen pen;

    public TurtlePlayground(TurtleView turtleView){
        setBgColor(Color.WHITE);
        this.turtleView = turtleView;
        addTurtle(turtleView.getTurtleImageView());
        pen = new Pen(this, true, Color.BLACK, 10);
    }

    public TurtlePlayground(TurtleView turtleView, Color color){
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

    // update the turtle's position and leave trail if pen is down
    public void update(double x, double y){
        if(pen.isDown()){
            Line trail = pen.drawLine(new Point2D(turtleView.getX(), turtleView.getY()), new Point2D(x,y));
            this.getChildren().add(trail);
        }
        turtleView.update(x,y);
    }

    // put an additional turtle to the center of pane
    private void addTurtle(Node element){
        this.getChildren().add(element);
        this.widthProperty().addListener(e -> element.setLayoutX(this.getWidth() / 2.0 - turtleView.getWidth()/2));
        this.heightProperty().addListener(e -> element.setLayoutY(this.getHeight() / 2.0 - turtleView.getHeight()/2));
    }

    public void setPenColor(Color color){
        pen.setColor(color);
    }

}
