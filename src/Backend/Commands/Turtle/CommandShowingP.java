package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandShowingP extends Command {

    public CommandShowingP(){
        super();
    }

    @Override
    public String getDescription() {
        return "SHOWING?: returns 1 if turtle is showing, 0 if it is hiding";
    }

    @Override
    public String execute(List<String> params) {
        parseParameters(params);
        return Boolean.toString(CommandManager.myTracker.getTurtle().getVisibility());
    }
}
