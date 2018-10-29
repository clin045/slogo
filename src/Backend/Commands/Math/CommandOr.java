/**
 * @author Michael Glushakov (mg367), Max Bartlett (mmb70)
 */
package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandOr extends MultiInputCommand {
    private static final String key="Or";
    public CommandOr(VariableTracker tracker){

        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        try{
            parseAllParameters(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(key);
        }
        return myVals.stream().anyMatch(i -> i == 1) ? "1" : "0";
    }
}
