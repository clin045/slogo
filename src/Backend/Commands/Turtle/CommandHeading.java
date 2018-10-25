package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandHeading extends Command {

    public CommandHeading(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "HEADING: returns the turtle's heading in degrees";
    }

    @Override
    public String execute(List<String> params) {
        return Double.toString(myTracker.getActiveTurtle().getHeading());
    }
}
