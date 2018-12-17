package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandUnstamp extends Command {
    public CommandUnstamp(VariableTracker tracker) {
        super(tracker);
    }

    @Override
    public String execute(List<String> params) {
        var turtleMan=myTracker.getTurtleManager();
        return String.valueOf(turtleMan.unstamp());
    }
}
