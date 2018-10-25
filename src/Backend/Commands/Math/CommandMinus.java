package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.lang.invoke.VarHandle;
import java.util.List;

public class CommandMinus extends Command {
    double d1;

    public CommandMinus(VariableTracker tracker){super(tracker);}

    @Override
    public String getDescription() {
        return "returns negative of the values of expr";
    }

    @Override
    public String execute(List<String> params) {
        d1=parseParameters(params);
        return ""+(-1*d1);
    }
}
