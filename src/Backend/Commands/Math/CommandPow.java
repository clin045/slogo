package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandPow extends Command {
    private double d1,d2;
    public CommandPow(VariableTracker tracker){super(tracker);}

    @Override
    public String getDescription() {
        return "returns base raised to the power of the exponent";
    }

    @Override
    public String execute(List<String> params) {
        d1= parseParameter(params);
        d2= parseParameter(params);
        return ""+Math.pow(d1,d2);
    }
}
