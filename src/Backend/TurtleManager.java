package Backend;

import FrontEnd.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages active turtles and executes methods on all active turtles
 * Assumptions: Turtle implements all methods called by TurtleManager
 * Dependencies: Turtle
 *
 *
 * @author Christopher Lin
 */

public class TurtleManager {

    private Map<Integer, Turtle> turtleMap;
    private List<Turtle> activeTurtles;
    private List<Turtle> stampedTurtles;


    TurtleManager() {
        turtleMap = new HashMap<>();
        activeTurtles = new ArrayList<>();
        Turtle turtle1 = new Turtle();
        activeTurtles.add(turtle1);
        stampedTurtles = new ArrayList<>();
        turtleMap.put(1, turtle1);
    }

    /**
     *
     * @return the total number of turtles in the turtleMap
     */
    public int getNumTurtles() {
        return turtleMap.size();
    }

    public void removeTurtle(int id){
        var toRemove = turtleMap.get(id);
        toRemove.getController().getTurtlePlayground().getChildren().remove(toRemove.getController().getTurtleView().getTurtleImageView());
        turtleMap.remove(id);
    }

    /**
     *
     * @return all turtles in the turtleMap
     */

    public List<Turtle> getAllTurtles() {
        var allTurtles = new ArrayList<Turtle>();
        for (Integer i : turtleMap.keySet()) {
            allTurtles.add(turtleMap.get(i));
        }
        return allTurtles;
    }

    /**
     *
     * @return a list of all active turtles
     */
    public List<Turtle> getActiveTurtles() {

        return activeTurtles;
    }

    private List<Turtle> getUnstampedTurtles(){
        var unstamped = new ArrayList<Turtle>();
        unstamped.addAll(activeTurtles);
        unstamped.removeAll(stampedTurtles);
        return unstamped;
    }



    /**
     * Directly sets the active turtles to a specified list
     * @param turtles A list of turtles
     */
    public void setActiveTurtles(List<Turtle> turtles) {
        activeTurtles.clear();
        activeTurtles.addAll(turtles);
    }



    /**
     *
     * @param id    Id of turtle
     * @return  Turtle with given id
     */

    public Turtle getTurtleByID(int id) {
        return turtleMap.get(id);
    }

    /**
     *
     * @return ID of last active turtle
     */
    public int getID() {
        return (activeTurtles.get(activeTurtles.size() - 1).getID());
    }

    public int getX() {
        return (activeTurtles.get(activeTurtles.size() - 1).getX());
    }

    public int getY() {
        return (activeTurtles.get(activeTurtles.size() - 1).getY());
    }

    public double getHeading() {
        return (activeTurtles.get(activeTurtles.size() - 1).getHeading());
    }

    public boolean getPenDown() {
        return (activeTurtles.get(activeTurtles.size() - 1).getPenDown());
    }


    public void clearStamps(){
        for(Turtle t : stampedTurtles){
            removeTurtle(t.getID());
        }
    }

    /**
     * Sets the active turtle to a list of IDs
     * @param turtlesIDs    Integer list of turtle IDs
     */

    public void setActiveTurtlesByID(List<Integer> turtlesIDs) {
        activeTurtles.clear();
        for (Integer id : turtlesIDs) {
            if (turtleMap.containsKey(id)) {
                activeTurtles.add(turtleMap.get(id));
            } else {
                turtleMap.put(id, new Turtle(id));
                activeTurtles.add(turtleMap.get(id));
            }
        }
    }


    public double penDown() {

        for (Turtle t : getUnstampedTurtles()) {
            t.penDown();
        }
        return 0;
    }

    public double penSize(int pixels) {

        for (Turtle t : getUnstampedTurtles()) {
            t.setPenStrokeWidth(pixels);
        }
        return pixels;
    }

    public double penUp() {
        for (Turtle t : getUnstampedTurtles()) {
            t.penUp();
        }
        return 1;
    }

    public double changeBG(int i) {
        for (Turtle t : getUnstampedTurtles()) {
            t.changeBgColor(i);
        }
        return i;
    }

    public double penColor(int i) {
        for (Turtle t : getUnstampedTurtles()) {
            t.changePenColor(i);
        }
        return i;
    }

    public boolean getVisibility() {
        return (activeTurtles.get(activeTurtles.size() - 1).getVisibility());
    }

    public double forward(double dist) {

        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            last = t.forward(dist);
        }
        return last;
    }

    public double back(double dist) {
        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            last = t.back(dist);
        }
        return last;
    }

    public double left(double degrees) {
        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            last = t.left(degrees);
        }
        return last;
    }

    public double right(double degrees) {
        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            last = t.right(degrees);
        }
        return last;
    }

    public double setHeading(double heading) {
        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            last = t.setHeading(heading);
        }
        return last;
    }

    public double towards(double x, double y) {
        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            last = t.towards(x, y);
        }
        return last;
    }

    public double setXY(double x, double y) {
        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            last = t.setXY(x, y);
        }
        return last;
    }

    public double show() {
        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            last = t.show();
        }
        return last;
    }

    public double getShape(){
        double index=0;
        for(Turtle t: getUnstampedTurtles()) {
            index = t.getShapeIndex();
        }
        return index;
    }

    public double hide() {
        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            last = t.hide();
        }
        return last;
    }

    public double clearScreen() {
        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            t.clearScreen();
        }
        return last;
    }

    public double home() {
        double last = 0;
        for (Turtle t : getUnstampedTurtles()) {
            last = t.home();
        }
        return last;
    }

    public double setShape(double index) {

        for (Turtle t : getUnstampedTurtles()) {
            t.setTurtleShape((int) index);
        }
        return index;
    }

    public void stampTurtle(Turtle t){
        stampedTurtles.add(t);
    }

    public double getPenColor() {
        return activeTurtles.get(activeTurtles.size() - 1).getPenColorIndex();
    }

    public double setPalette(double index, double r, double b, double g) {
        for (Turtle t : getUnstampedTurtles()) {
            t.setPalette((int) index, (int) r, (int) b, (int) g);
        }
        return index;
    }

    /**
     * Creates a new turtle with given id and controller
     * @param id    id of turtle
     * @param controller    FrontEnd controller to bind to turtle
     */

    public void createTurtle(int id, Controller controller) {
        Turtle newTurtle = new Turtle(id);
        if(!activeTurtles.contains(newTurtle)){
            activeTurtles.add(newTurtle);
        }
        newTurtle.setController(controller);
        turtleMap.put(id, newTurtle);
    }
}
