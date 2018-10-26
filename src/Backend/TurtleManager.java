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

    public void penDown() {
        for(Turtle t : activeTurtles){
            t.penDown();
        }
    }

    public void penUp() {
        for(Turtle t : activeTurtles){
            t.penUp();
        }
    }

    public boolean getVisibility() {
        return (activeTurtles.get(activeTurtles.size()-1).getVisibility());
    }

    public void forward(int dist) {
        for(Turtle t : activeTurtles){
            t.forward(dist);
        }
    }

    public void back(int dist){
        for(Turtle t : activeTurtles){
            t.back(dist);
        }
    }
    public void left(double degrees){
        for(Turtle t : activeTurtles){
            t.left(degrees);
        }
    }

    public void right(double degrees){
        for(Turtle t : activeTurtles){
            t.right(degrees);
        }
    }
    public void setHeading(double heading){
        for(Turtle t : activeTurtles){
            t.setHeading(heading);
        }
    }

    public void towards(double x, double y){
        for(Turtle t : activeTurtles){
            t.towards(x, y);
        }
    }
    public void setXY(double x, double y){
        for(Turtle t : activeTurtles){
            t.setXY(x,y);
        }
    }

    public void show() {
        for(Turtle t : activeTurtles){
            t.show();
        }
    }
    public void hide() {
        for(Turtle t : activeTurtles){
            t.hide();
        }
    }

    public void clearScreen() {
        for(Turtle t : activeTurtles){
            t.clearScreen();
        }
    }

    public void home() {
        for(Turtle t : activeTurtles){
            t.home();
        }
    }





    public void createTurtle(int id){
        turtleMap.put(id, new Turtle(id));
    }
}
