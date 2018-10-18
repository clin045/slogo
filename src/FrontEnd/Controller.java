package FrontEnd;

import javafx.scene.paint.Color;

/*
    Controller serves as a middleground for
    Each workspace has its own controller
    @author xp19
 */

public class Controller {

    TurtlePlayground turtlePlayground;
    TurtleView turtleView;

    public Controller(TurtlePlayground turtlePlayground, TurtleView turtleView){
        this.turtlePlayground = turtlePlayground;
        this.turtleView = turtleView;
    }

    public void setTurtleDisplayAreaColor(Color color){
        turtlePlayground.setBgColor(color);
    }

    public void update(double x, double y){
        turtlePlayground.update(x,y);
    }

    public void setPenColor(Color color){
        turtlePlayground.setPenColor(color);
    }

    public void setTurtleImage(String fileName){
        turtleView.setTurtleImage(fileName);
    }

    // turn the turtle clockwise by certain degrees
    public void turnTurtle(double degress){
        turtleView.turn(degress);
    }

    public void setPenDown(boolean isPenDown){
        turtlePlayground.setPenDown(isPenDown);
    }

}
