/**
 * @author Michael Glushakov (mg367), Max Bartlett (mmb70)
 */
package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidInputException;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandDiv extends MultiInputCommand {
    private static final String key ="Quotient";
    public CommandDiv(VariableTracker tracker){
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
        if(myVals.contains(0)){
            throw new InvalidInputException("0");
        }
        return String.valueOf(myVals.stream().mapToDouble(d -> d).reduce((a, b) -> a / b).getAsDouble());
    }
}
