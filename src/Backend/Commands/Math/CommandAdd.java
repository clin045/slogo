package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

/**
 * @author Michael Glushakov (mg367)
 */
public class CommandAdd extends MultiInputCommand {
   private static final String key="Sum";
    public CommandAdd(VariableTracker tracker) {

        super(tracker);
        setKey(key);
    }





    @Override
    public String execute(List<String>params) {
        try{
            parseAllParameters(params);
        }
        catch (Exception e){
            throw new InvalidSyntaxException(key);
        }
        double out =0;
        for (double val:myVals){
            out+=val;
        }
        System.out.println("Done: "+out);
        return ""+out;
    }
}
