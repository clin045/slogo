package Backend.Commands.Turtle;

import Backend.Command;
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
        heading = parseParameter(params);
        Turtle myTurtle = myTracker.getActiveTurtle();
        return Double.toString(myTurtle.setHeading(heading));
    }
}
