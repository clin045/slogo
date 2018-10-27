package FrontEnd;

import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TurtleViewManager implements Iterable<TurtleView> {

    HashSet<Integer> ids;
    ArrayList<TurtleView> turtleList;

    VariableTracker variableTracker; // track the state of each turtle
//    TurtlePlayground turtlePlayground;

    public TurtleViewManager(VariableTracker variableTracker){
        this.variableTracker = variableTracker;
//        this.turtlePlayground = turtlePlayground;
    }

    public void addTurtle(int id){
        if(ids.contains(id)){
            throw new IllegalArgumentException(String.format("Duplicated Turtle ID: %d", id));
        }
    }

    @Override
    public Iterator<TurtleView> iterator() {
        return turtleList.iterator();
    }
}