package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.Turtle;
import Backend.VariableTracker;

import java.util.List;

public class CommandSetHeading extends Command {
    private double heading;
    public CommandSetHeading(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "SETHEADING: Sets the turtle's heading";
    }

    @Override
    public String execute(List<String> params) {
        heading = parseParameters(params);
        var turtleMan = myTracker.getTurtleManager();
        return Double.toString(turtleMan.setHeading(heading));
    }
}
