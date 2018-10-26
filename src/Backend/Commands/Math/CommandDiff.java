package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

/**
 * @author Michael Glushakov mg367
 */
public class CommandDiff extends MultiInputCommand {
    private double d1,d2;

    public CommandDiff(VariableTracker tracker){
        super(tracker);

    }
    @Override
    public String getDescription() {
        return "DIFFERENCE: returns difference of the arguments";
    }


    @Override
    public String execute(List<String> params) {
        parseAllParameters(params);
        double out =myVals.remove(0);
        for(double d:myVals) {
            out -= d;
        }
        return ""+out;
    }
}
