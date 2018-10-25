package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandFD extends Command {
    private double amountFD;
    private final int PARAM_NUMBER=1;
    public CommandFD(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription(){
        return "FORWARD: Moves Turtle forward by a set amount of pixels";
    }

    public String execute(List<String> params) {
        var turtle = super.myTracker.getTurtle();
        amountFD=parseParameters(params);
        return Double.toString(turtle.forward(amountFD));
    }
}
