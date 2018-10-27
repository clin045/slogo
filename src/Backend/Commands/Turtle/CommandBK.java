package Backend.Commands.Turtle;

import Backend.Command;
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
        amountBack=parseParameter(params);
        return Double.toString(myTracker.getTurtleManager().back(amountBack));

    }




}
