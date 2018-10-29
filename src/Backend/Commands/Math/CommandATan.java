/**
 * @author Michael Glushakov (mg367), Max Bartlett (mmb70)
 */
package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandATan extends Command {
    private double d1;
    private static final String key="ArcTangent";

    public CommandATan(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        try {
            d1 = parseParameter(params);
        }
        catch(Exception e) {
            throw new InvalidSyntaxException(key);
        }
        return String.valueOf(Math.toDegrees(Math.atan(d1)));
    }
}
