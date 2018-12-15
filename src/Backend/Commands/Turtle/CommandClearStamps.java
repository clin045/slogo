package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandClearStamps extends Command {

    public CommandClearStamps(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String execute(List<String> params) {
        myTracker.getTurtleManager().clearStamps();
        return null;
    }
}
