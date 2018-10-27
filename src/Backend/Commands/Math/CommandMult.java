package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandMult extends MultiInputCommand {

    public CommandMult(VariableTracker tracker){super(tracker);}

    @Override
    public String getDescription() {
        return "PRODUCT: returns product of the arguments";
    }


    @Override
    public String execute(List<String> params) {
        parseAllParameters(params);
        double out=1;
        for(double d: myVals){
            out*=d;
        }
        return ""+out;
    }
}
