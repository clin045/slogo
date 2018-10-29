package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.lang.invoke.VarHandle;
import java.util.List;

public class CommandHome extends Command {
    public static final String key="Home";
    public CommandHome(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        return String.valueOf(myTracker.getTurtleManager().home());
    }
}
