package FrontEnd;

import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TurtleViewManager implements Iterable<TurtleView> {

    HashSet<Integer> ids;
    ArrayList<TurtleView> turtleList;
    public static int ID = 1;
    VariableTracker variableTracker; // track the state of each turtle
//    TurtlePlayground turtlePlayground;

    public TurtleViewManager(VariableTracker variableTracker){
        this.variableTracker = variableTracker;
        turtleList = new ArrayList<>();
        ids = new HashSet<>();
        addTurtle();
//        this.turtlePlayground = turtlePlayground;
    }

    public void addTurtle(){
        turtleList.add(new TurtleView());

        variableTracker.getTurtleManager().createTurtle(ID);
        variableTracker.getTurtleManager().setActiveTurtlesByID(new ArrayList<>(ID));
        ID++;
    }

    @Override
    public Iterator<TurtleView> iterator() {
        return turtleList.iterator();
    }
}
