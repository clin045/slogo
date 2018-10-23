package FrontEnd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TurtleManager implements Iterable<TurtleView> {

    HashSet<Integer> ids;
    ArrayList<TurtleView> turtleList;

    public TurtleManager(){
        turtleList = new ArrayList<>();
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
