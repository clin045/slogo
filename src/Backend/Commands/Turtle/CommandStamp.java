package Backend.Commands.Turtle;

import Backend.Command;
import Backend.Commands.ServiceLocator;
import Backend.VariableTracker;
import FrontEnd.Controller;
import javafx.geometry.Point2D;


import java.util.List;

/**
 * stamps the currently active turtle
 */
public class CommandStamp extends Command {

    public CommandStamp(VariableTracker tracker){
        super(tracker);

    }

    @Override
    public String execute(List<String> params) {

        var turtleMan = myTracker.getTurtleManager();
        var firstActive = turtleMan.getActiveTurtles().get(0);

        var myController = firstActive.getController();
        var firstActivePos = new Point2D(myController.getTurtleView().getX(), myController.getTurtleView().getY());
        turtleMan.stampTurtle(firstActive);

        var newController = new Controller(myController.getTurtlePlayground(), myController.addNewTurtle(firstActivePos), ServiceLocator.getMyCommandManager());
        turtleMan.createTurtle(turtleMan.getActiveTurtles().size(), newController);
        return "";
    }
}
