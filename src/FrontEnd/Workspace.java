package FrontEnd;

/*
    Represents the content inside each individual tab (all UI elements contained in it)
    @author xp19
 */

import Backend.CommandManager;
import Backend.VariableTracker;
import javafx.scene.layout.BorderPane;

public class Workspace extends BorderPane {

    TurtlePlayground area;
    TurtleView turtleView;
    VariableTracker variableTracker;

    // create a new workspace
    public Workspace(){
        setUpTurtleDisplayArea();
        Controller controller = new Controller(area, turtleView);
//        variableTracker = new VariableTracker(controller); // possibly pass in the a reference to controller here
        CommandManager commandManager = new CommandManager("languages.English");
        commandManager.myTracker.getTurtle().setController(controller);
        ControlPanelView controlPanelView = new ControlPanelView(this, controller);
        CommandInputHandler commandInputHandler = controlPanelView.getCommandInputHandler();
        commandInputHandler.setCommandManager(commandManager);
    }

    // initialize the playground in the border pane
    // TODO: do the initialization inside the turtle class
    private void setUpTurtleDisplayArea(){
        turtleView = new TurtleView();
        area = new TurtlePlayground(turtleView);
        this.setCenter(area);
    }

}
