package FrontEnd;

/*
    Represents the content inside each individual tab (all UI elements contained in it)
    @author xp19
 */

import Backend.CommandManager;
import Backend.VariableTracker;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Workspace extends BorderPane {

    TurtlePlayground area;
    TurtleView turtleView;
    VariableTracker variableTracker;
    TabPane tabPane;

    // create a new workspace
    public Workspace(){
        setUpTurtleDisplayArea();
        Controller controller = new Controller(area, turtleView);
//        variableTracker = new VariableTracker(controller); // possibly pass in the a reference to controller here
        CommandManager commandManager = new CommandManager("languages.English");
        CommandManager.myTracker.getActiveTurtle().setController(controller);
        ControlPanelView controlPanelView = new ControlPanelView(this, controller);
        controlPanelView.getRightMenu().getChildren().add(getHelperMenu());

        CommandInputHandler commandInputHandler = controlPanelView.getCommandInputHandler();
        commandInputHandler.setCommandManager(commandManager);
        commandInputHandler.setVariableHistory(controlPanelView.definedVariables);
        commandInputHandler.setCommandHistory(controlPanelView.commandHistory);
        commandInputHandler.setUserDefinedCommands(controlPanelView.userDefinedCommands);
    }

    public Workspace(TabPane tabPane){
        this();
        this.tabPane = tabPane;
    }

    // initialize the playground in the border pane
    // TODO: do the initialization inside the turtle class
    private void setUpTurtleDisplayArea(){
        turtleView = new TurtleView();
        area = new TurtlePlayground(turtleView);
        this.setCenter(area);
    }

    private TitledPane getHelperMenu(){
        VBox allCommands = new VBox();
        ScrollPane sp = new ScrollPane();
        sp.setContent(allCommands);
        for(String command: CommandManager.getCommands().keySet()){
            allCommands.getChildren().add(UIFactory.createText(command+": "+CommandManager.getCommands().get(command).getDescription()));
        }
        TitledPane helperMenu = new TitledPane("User Guide", sp);
        sp.setPadding(new Insets(10));
        helperMenu.setExpanded(false);
        return helperMenu;
    }

}
