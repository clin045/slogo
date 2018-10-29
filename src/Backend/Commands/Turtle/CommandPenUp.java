package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandPenUp extends Command {
    private static final String key ="PenUp";

    public CommandPenUp(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }




    public String execute(List<String> params) {
        return String.valueOf(myTracker.getTurtleManager().penUp());
    }
}
