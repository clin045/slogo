package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

/**
 * @author Michael Glushakov mg367
 */
public class CommandDiff extends MultiInputCommand {
    private static final String key = "Difference";

    public CommandDiff(VariableTracker tracker){
        super(tracker);
        setKey(key);

    }



    @Override
    public String execute(List<String> params) {
        try{
            parseAllParameters(params);
        }
        catch(Exception e){
            throw new IllegalArgumentException(key);
        }
        double out =myVals.remove(0);
        for(double d:myVals) {
            out -= d;
        }
        return ""+out;
    }
}
