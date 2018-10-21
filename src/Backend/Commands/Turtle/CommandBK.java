package Backend.Commands.Turtle;

import java.util.List;

import static Backend.CommandManager.myTracker;

/**
 * @author Christopher Lin cl349
 */

public class CommandBK extends TurtleCommands{
    private double amountBack;
    public static final int NUM_PARAMS = 1;
    public CommandBK(){
        super();
    }

    @Override
    public int getParamNumber() {
        return NUM_PARAMS;
    }

    @Override
    public String getDescription() {
        return "BACK: Moves Turtle backward by a set amount of pixels";
    }

    @Override
    public String execute(List<String> params) {
        var turtle = myTracker.getTurtle();
        amountBack=parseParameters(params);
        turtle.back(amountBack);
        return ""+amountBack;
    }




}
