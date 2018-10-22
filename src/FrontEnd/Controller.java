package FrontEnd;

import javafx.scene.paint.Color;

/*
    Controller serves as a middle ground between frontend and backend to exchange information.
    It contains a reference to turtle playground and turtle view.
    It will be included in the turtle class.
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
//    public void turnTurtle(double degrees){
//        turtleView.turn(degrees);
//    }

    public void rotateTurtle(double heading){
        turtleView.rotate(heading);
    }

    public void setPenDown(boolean isPenDown){
        turtlePlayground.setPenDown(isPenDown);
    }

    public void hideTurtle(){
        turtleView.hide();
    }

    public void showTurtle(){
        turtleView.show();
    }

    public void setTurtleToHome(){
        turtlePlayground.setTurtleToHome();
    }

    public void reset(){
        turtlePlayground.reset();
    }

    public void setTurtlePosition(double x, double y){
        turtleView.setTurtlePosition(x,y);
    }
}
