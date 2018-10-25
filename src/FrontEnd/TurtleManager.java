package FrontEnd;

import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TurtleManager implements Iterable<TurtleView> {

    HashSet<Integer> ids;
    ArrayList<TurtleView> turtleList;

    VariableTracker variableTracker; // track the state of each turtle

    public TurtleManager(VariableTracker variableTracker){
        this.variableTracker = variableTracker;

//        turtleList = new ArrayList<>();
//        for(TurtleView view: turtleList){
//            view.getTurtleImageView().setOnMouseClicked(event -> {
//                variableTracker.setActiveTurtle();
//            });
//        }
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
