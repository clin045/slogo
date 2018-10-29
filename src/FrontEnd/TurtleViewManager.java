package FrontEnd;

import Backend.TurtleManager;
import Backend.VariableTracker;
import javafx.scene.control.TitledPane;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TurtleViewManager implements Iterable<TurtleView> {

    HashSet<Integer> ids;
    ArrayList<TurtleView> turtleList;
    public static int ID = 1;
    VariableTracker variableTracker; // track the state of each turtle
    TurtleManager turtleManager;
//    TitledPane turtleStatusTitledPane;
//    TurtlePlayground turtlePlayground;

    public TurtleViewManager(VariableTracker variableTracker){
        this.variableTracker = variableTracker;
        this.turtleManager = variableTracker.getTurtleManager();
        turtleList = new ArrayList<>();
        ids = new HashSet<>();
        TurtleView view = new TurtleView(variableTracker, 1);
//        view.setTurtleStatusPane(turtleStatusTitledPane);
        addTurtleView(view);
//        this.turtlePlayground = turtlePlayground;
    }

    public void addTurtleView(TurtleView turtleView){
        turtleList.add(turtleView);
        ID++;
    }

//    public void setTurtleStatusTitlePane(TitledPane turtleStatusTitlePane){
//        this.turtleStatusTitledPane = turtleStatusTitlePane;
//    }


    public TurtleManager getTurtleManager(){
        return turtleManager;
    }

    @Override
    public Iterator<TurtleView> iterator() {
        return turtleList.iterator();
    }
}
