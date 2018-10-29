package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandMinus extends Command {
    double d1;
    private static final String key="Minus";
    public CommandMinus(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        try{
            d1= parseParameter(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(key);
        }
        return String.valueOf(d1 * -1);
    }
}
