/**
 * @author Michael Glushakov (mg367), Max Bartlett (mmb70)
 */
package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandNot extends Command {
    public static final String key = "Not";

    public CommandNot(VariableTracker tracker) {
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        double test;
        try {
            test = parseParameter(params);
        } catch (Exception e) {
            throw new InvalidSyntaxException(key);
        }
        return test == 0 ? "1" : "0";
    }
}
