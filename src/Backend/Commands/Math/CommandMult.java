/**
 * @author Michael Glushakov (mg367), Max Bartlett (mmb70)
 */
package Backend.Commands.Math;

import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandMult extends MultiInputCommand {
    private static final String key="Product";
    public CommandMult(VariableTracker tracker){
        super(tracker);
        super.setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        try{
            parseAllParameters(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(key);
        }
        return String.valueOf(myVals.stream().mapToDouble(d -> d).reduce((a, b) -> (a * b)).getAsDouble());
    }
}
