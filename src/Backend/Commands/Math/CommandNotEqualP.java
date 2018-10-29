/**
 * @author Michael Glushakov (mg367), Max Bartlett (mmb70)
 */
package Backend.Commands.Math;

import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandNotEqualP extends MultiInputCommand {
    private static final String key = "NotEqual";

    public CommandNotEqualP(VariableTracker tracker) {
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        try {
            parseAllParameters(params);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new InvalidSyntaxException(key);
        }
        return myVals.stream().distinct().count() > 1 ? "1" : "0";
    }
}
