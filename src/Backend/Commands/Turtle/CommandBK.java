package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;



/**
 * @author Christopher Lin cl349
 */

public class CommandBK extends Command {
    private double amountBack;
    public static final int NUM_PARAMS = 1;
    public CommandBK(VariableTracker tracker){
        super(tracker);
    }


    @Override
    public String getDescription() {
        return "BACK: Moves Turtle backward by a set amount of pixels";
    }

    @Override
    public String execute(List<String> params) {
        var turtle = myTracker.getTurtle();
        amountBack=parseParameters(params);
        return Double.toString(turtle.back(amountBack));
    }




}
