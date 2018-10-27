package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandID extends Command {
    public CommandID(VariableTracker tracker){
        super(tracker);
    }
    @Override
    public String getDescription() {
        return "returns current active turtle's ID number";
    }

    @Override
    public String execute(List<String> params) {
        return Integer.toString(myTracker.getTurtleManager().getID());
    }
}
