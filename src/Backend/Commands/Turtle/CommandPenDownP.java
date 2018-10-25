package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandPenDownP extends Command {

    public CommandPenDownP(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "PENDOWN?: returns 1 if turtle's pen is down, 0 if it is up";
    }

    @Override
    public String execute(List<String> params) {
        return myTracker.getActiveTurtle().getPenDown() ? "1" : "0";
    }
}
