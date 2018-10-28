package Backend.Commands.Display;

import Backend.Command;
import Backend.VariableTracker;
import FrontEnd.TurtlePlayground;
import FrontEnd.Workspace;

import java.util.List;

public class CommandSetBackground extends Command {
    private static final String key = "SetBackgroud";
    public CommandSetBackground(VariableTracker tracker){
        super (tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {

        return null;
    }
}
