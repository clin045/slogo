package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandNotEqualP extends MultiInputCommand {

    public CommandNotEqualP(VariableTracker tracker){super(tracker);}
    @Override
    public String getDescription() {
        return "returns 1 if the value of expr1 and the value of expr2 are not equal, otherwise 0";
    }

    @Override
    public String execute(List<String> params) {
        parseAllParameters(params);
        double check=myVals.remove(0);
        for(double d: myVals){
            if(d==check){return "0";}
        }
        return "1";
    }
}
