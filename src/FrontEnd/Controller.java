package FrontEnd;

import javafx.scene.paint.Color;

public class Controller {

    TurtleDisplayArea turtleDisplayArea;
    TurtleView turtleView;

    public Controller(TurtleDisplayArea turtleDisplayArea, TurtleView turtleView){
        this.turtleDisplayArea = turtleDisplayArea;
        this.turtleView = turtleView;
    }

    public void setTurtleDisplayAreaColor(Color color){
        turtleDisplayArea.setBgColor(color);
    }

    public void update(double x, double y){
        turtleDisplayArea.update(x,y);
    }

    public void setPenColor(Color color){
        turtleDisplayArea.setPenColor(color);
    }

    public void setTurtleImage(String fileName){
        turtleView.setTurtleImage(fileName);
    }

}
