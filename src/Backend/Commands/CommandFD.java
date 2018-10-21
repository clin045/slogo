package Backend.Commands;

import Backend.VariableTracker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class CommandFD extends TurtleCommands {
    private double amountFD;
    private final int PARAM_NUMBER=1;
    public CommandFD(){
        super();
    }

    @Override
    public int getParamNumber() {
        return PARAM_NUMBER;
    }
    @Override
    public String getDescription(){
        return "FORWARD: Moves Turtle forward by a set amount of pixels";
    }


    public String execute(List<String> params) {
        System.out.println("Executing");
        var turtle = CommandManager.myTracker.getTurtle();
        amountFD=parseParameters(params);
        turtle.forward(amountFD);
        return Double.toString(amountFD);
    }



}
