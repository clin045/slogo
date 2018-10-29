package Backend.Commands.Display;

import Backend.Command;

import Backend.Commands.ControlStructures.CommandSet;
import Backend.VariableTracker;

import java.util.List;

public class CommandSetBackground extends Command {
    public static final String key="SETBG";

public CommandSetBackground(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        int index = (int)parseParameter(params);
        return ""+myTracker.getTurtleManager().changeBG(index);
    }
}
