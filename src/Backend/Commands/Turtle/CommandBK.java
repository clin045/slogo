package Backend.Commands.Turtle;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;



/**
 * @author Christopher Lin cl349
 */

public class CommandBK extends Command {
    private double amountBack;
    public static final String key= "Backward";
    public CommandBK(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        try{
            amountBack=parseParameter(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(key);
        }
        return Double.toString(myTracker.getTurtleManager().back(amountBack));

    }




}
