package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.lang.invoke.VarHandle;
import java.util.List;

public class CommandPi extends Command {
    public static final String key="Pi";
    public CommandPi(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        return ""+Math.PI;
    }
}
