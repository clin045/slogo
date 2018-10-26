package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandOr extends MultiInputCommand {
    public CommandOr(VariableTracker tracker){
        super(tracker);
    }
    @Override
    public String getDescription() {
        return "returns 1 if test1 or test2 are non-zero, otherwise 0";
    }

    @Override
    public String execute(List<String> params) {
        parseAllParameters(params);
        for(double d: myVals){
            if(d==1){return "1";}
        }
        return "0";
    }
}
