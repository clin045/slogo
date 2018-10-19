package FrontEnd;

/*
    Represents the content inside each individual tab (all UI elements contained in it)
    @author xp19
 */

import Backend.VariableTracker;
import javafx.scene.layout.BorderPane;

public class Workspace extends BorderPane {

    TurtlePlayground area;
    TurtleView turtleView;
    VariableTracker variableTracker;

    // create a new workspace
    public Workspace(){
        setUpTurtleDisplayArea();
        variableTracker = new VariableTracker(); // possibly pass in the a reference to controller here
        Controller controller = new Controller(area, turtleView);
        ControlPanelView controlPanelView = new ControlPanelView(this, controller);
    }

    // initialize the playground in the border pane
    // TODO: do the initialization inside the turtle class
    private void setUpTurtleDisplayArea(){
        turtleView = new TurtleView();
        area = new TurtlePlayground(turtleView);
        this.setCenter(area);
    }

}
