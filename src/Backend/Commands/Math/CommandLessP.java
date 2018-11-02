/**
 * @author Michael Glushakov (mg367), Max Bartlett (mmb70)
 */
package Backend.Commands.Math;

import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandLessP extends MultiInputCommand {
    private static final String key = "LessThan";

    public CommandLessP(VariableTracker tracker) {
        super(tracker);
        setKey(key);
    }


    @Override
    public String execute(List<String> params) {
        try {
            parseAllParameters(params);
        } catch (Exception e) {
            throw new InvalidSyntaxException(key);
        }
        double check = myVals.remove(0);
        return myVals.stream().anyMatch(i -> i <= check) ? "0" : "1";
    }
}
