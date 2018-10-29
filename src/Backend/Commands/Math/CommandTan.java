/**
 * @author Michael Glushakov (mg367), Max Bartlett (mmb70)
 */
package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandTan extends Command {
    private double d1;
    private static final String key="Tangent";
    public CommandTan(VariableTracker tracker){
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
        if(d1 % 180 == 0){throw new IllegalArgumentException("tan of multiples of 180 is undefined");}
        return String.valueOf(Math.toDegrees(Math.tan(d1)));
    }
}
