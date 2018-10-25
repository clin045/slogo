package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;

import java.util.List;

public class CommandShowingP extends Command {

    public CommandShowingP(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "SHOWING?: returns 1 if turtle is showing, 0 if it is hiding";
    }

    @Override
    public String execute(List<String> params) {
        return CommandManager.myTracker.getActiveTurtle().getVisibility() ? "1" : "0";
    }
}
