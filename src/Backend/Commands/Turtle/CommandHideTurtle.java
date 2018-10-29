package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandHideTurtle extends Command {
    private static final String key="HideTurtle";
    public CommandHideTurtle(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        myTracker.getTurtleManager().hide();
        return "0";
    }
}
