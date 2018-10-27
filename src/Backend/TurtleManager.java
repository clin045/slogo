package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurtleManager {

    private Map<Integer, Turtle> turtleMap;
    private List<Turtle> activeTurtles;


    TurtleManager(){
        turtleMap = new HashMap<>();
        activeTurtles = new ArrayList<>();
        Turtle turtle1=new Turtle();
        activeTurtles.add(turtle1);
        turtleMap.put(1,turtle1);
    }

    public int getNumTurtles(){
        return turtleMap.size();
    }

    public List<Turtle> getActiveTurtles() {
        return activeTurtles;
    }

    public int getID(){
        return(activeTurtles.get(activeTurtles.size()-1).getID());
    }

    public int getX() {
        return (activeTurtles.get(activeTurtles.size()-1).getX());
    }

    public int getY() {
        return (activeTurtles.get(activeTurtles.size()-1).getY());
    }

    public double getHeading() {
        return (activeTurtles.get(activeTurtles.size()-1).getHeading());
    }
    public boolean getPenDown() {
        return (activeTurtles.get(activeTurtles.size()-1).getPenDown());
    }

    public double penDown() {
        for(Turtle t : activeTurtles){
            t.penDown();
        }
        return 0;
    }

    public double penUp() {
        for(Turtle t : activeTurtles){
            t.penUp();
        }
        return 1;
    }

    public boolean getVisibility() {
        return (activeTurtles.get(activeTurtles.size()-1).getVisibility());
    }

    public double forward(double dist) {
        double last = 0;
        for(Turtle t : activeTurtles){
            last = t.forward(dist);
        }
        return last;
    }

    public double back(double dist){
        double last = 0;
        for(Turtle t : activeTurtles){
            last = t.back(dist);
        }
        return last;
    }
    public double left(double degrees){
        double last = 0;
        for(Turtle t : activeTurtles){
            t.left(degrees);
        }
        return last;
    }

    public double right(double degrees){
        double last = 0;
        for(Turtle t : activeTurtles){
            t.right(degrees);
        }
        return last;
    }
    public double setHeading(double heading){
        double last = 0;
        for(Turtle t : activeTurtles){
            t.setHeading(heading);
        }
        return last;
    }

    public double towards(double x, double y){
        double last = 0;
        for(Turtle t : activeTurtles){
            t.towards(x, y);
        }
        return last;
    }
    public double setXY(double x, double y){
        double last = 0;
        for(Turtle t : activeTurtles){
            t.setXY(x,y);
        }
        return last;
    }

    public double show() {
        double last = 0;
        for(Turtle t : activeTurtles){
            t.show();
        }
        return last;
    }
    public double hide() {
        double last = 0;
        for(Turtle t : activeTurtles){
            t.hide();
        }
        return last;
    }

    public double clearScreen() {
        double last = 0;
        for(Turtle t : activeTurtles){
            t.clearScreen();
        }
        return last;
    }

    public double home() {
        double last = 0;
        for(Turtle t : activeTurtles){
            last = t.home();
        }
        return last;
    }





    public void createTurtle(int id){
        turtleMap.put(id, new Turtle(id));
    }
}
