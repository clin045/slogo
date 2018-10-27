package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandID extends Command {
    public static final String key="ID";
    public CommandID(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }


    @Override
    public String execute(List<String> params) {
        return Integer.toString(myTracker.getTurtleManager().getID());
    }
}
