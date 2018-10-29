package FrontEnd;

import Backend.CommandManager;
import Backend.TurtleManager;
import Backend.VariableTracker;
import javafx.geometry.Point2D;
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
    CommandManager commandManager;

    public Controller(TurtlePlayground turtlePlayground, TurtleView turtleView, CommandManager commandManager){
        this.turtlePlayground = turtlePlayground;
        this.turtleView = turtleView;
        this.commandManager = commandManager;
    }

    public void setTurtleDisplayAreaColor(Color color){
        turtlePlayground.setBgColor(color);
    }

    public void update(double x, double y){
        double originX = turtleView.getX();
        double originY = turtleView.getY();
        turtleView.update(x,y);
        turtlePlayground.leaveTrail(originX, originY, turtleView);
    }

    public void setPenColor(Color color){
        turtlePlayground.setPenColor(color);
    }

    public void setPenColor(int index){
        turtlePlayground.setPenColor(index);
    }

    public void setTurtleImage(String fileName){
        turtleView.setTurtleImage(fileName);
    }

    public void rotateTurtle(double oldHeading, double heading){
        turtleView.rotate(oldHeading, heading);
    }

    public void setPenDown(boolean isPenDown){
        turtlePlayground.setPenDown(isPenDown);
    }

    public void setTurtlePlaygroundBgColor(int index){
        turtlePlayground.setBgColor(index);
    }

    public void togglePenDown(){
        turtlePlayground.togglePenDown();
    }

    public void setPenThickness(double width){
        turtlePlayground.setPenThickNess(width);
    }

    public void setPalette(int index, Color color){
        turtlePlayground.setPalette(index, color);
    }

    public void setTurtleShape(int index){
        turtlePlayground.setTurtleShape(index);
    }

    public int getPenColor(){
        return turtlePlayground.getPenColor();
    }

    public int getImageIndex(){
        return turtlePlayground.getTurtleShape();
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
        turtlePlayground.setTurtlePosition(x,y);
    }

    public TurtleView addNewTurtle(Point2D position){
        return turtlePlayground.addNewTurtleToPlayground(position);
    }

    public VariableTracker getVariableTracker(){
        return commandManager.getMyTracker();
    }

    public TurtleManager getTurtleManager(){
        return getVariableTracker().getTurtleManager();
    }

}
