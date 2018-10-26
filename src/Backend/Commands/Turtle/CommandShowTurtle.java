package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandShowTurtle extends Command {
    public CommandShowTurtle(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "SHOWTURTLE: makes turtle visible";
    }

    @Override
    public String execute(List<String> params) {
        return Double.toString(myTracker.getTurtleManager().show());
    }
}
