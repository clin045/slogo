package FrontEnd;

/*
    Represents the content inside each individual tab (all UI elements contained in it)
    @author xp19
 */

import Backend.CommandManager;
import Backend.VariableTracker;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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
        CommandManager.myTracker.getTurtle().setController(controller);
        ControlPanelView controlPanelView = new ControlPanelView(this, controller);
        controlPanelView.getRightMenu().getChildren().add(addHelperMenu());
//        controlPanelView.getRightMenu().setMaxWidth(50);
//        this.setMaxWidth(50);
//        controlPanelView.getRightMenu().prefWidthProperty().bind(this.widthProperty().multiply(0.30));
        CommandInputHandler commandInputHandler = controlPanelView.getCommandInputHandler();
        commandInputHandler.setCommandManager(commandManager);
        commandInputHandler.setVariableHistory(controlPanelView.definedVariables);
        commandInputHandler.setCommandHistory(controlPanelView.commandHistory);

    }

    // initialize the playground in the border pane
    // TODO: do the initialization inside the turtle class
    private void setUpTurtleDisplayArea(){
        turtleView = new TurtleView();
        area = new TurtlePlayground(turtleView);
        this.setCenter(area);
    }

    private TitledPane addHelperMenu(){
        VBox allCommands = new VBox();
        ScrollPane sp = new ScrollPane();
        sp.setContent(allCommands);
        for(String command: CommandManager.getCommands().keySet()){
            allCommands.getChildren().add(UIFactory.createText(command+": "+CommandManager.getCommands().get(command).getDescription()));
        }
        TitledPane helperMenu = new TitledPane("User Guide", sp);
        sp.setPadding(new Insets(10));
//        helperMenu.setPrefWidth(50.0);
        helperMenu.setExpanded(false);
//        helperMenu.setMaxHeight(50);
        return helperMenu;
//        helperMenu.s
//        vBox.getChildren().add()
    }

}
