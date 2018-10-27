package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

/**
 * @author Michael Glushakov (mg367)
 */
public class CommandAdd extends MultiInputCommand {
    private Double d1,d2;
    public CommandAdd(VariableTracker tracker) {
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "SUM returns the sum of 2 numbers";
    }



    @Override
    public String execute(List<String>params) {
        parseAllParameters(params);
        double out =0;
        for (double val:myVals){
            out+=val;
        }
        System.out.println("Done: "+out);
        return ""+out;
    }
}
