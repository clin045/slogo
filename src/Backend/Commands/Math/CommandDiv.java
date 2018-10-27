package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidInputException;
import Backend.VariableTracker;

import java.util.List;

public class CommandDiv extends MultiInputCommand {
    private double d1,d2;
    public CommandDiv(VariableTracker tracker){super(tracker);}
    @Override
    public String getDescription() {
        return "QUOTIENT: returns quotient of the parameters";
    }



    @Override
    public String execute(List<String> params) {
        parseAllParameters(params);
        double out = myVals.remove(0);
        if(myVals.contains(0)){throw new InvalidInputException("0");}
        for (double d:myVals){
            out/=d;
        }
        return ""+out;
    }
}
