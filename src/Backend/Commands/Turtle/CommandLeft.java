package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandLeft extends Command {
    private double leftAmt;
   public CommandLeft(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "LEFT: Turns the turtle left by some number of degrees";
    }

    @Override
    public String execute(List<String> params) {
        var turtle = myTracker.getActiveTurtle();
        leftAmt= parseParameter(params);
        return Double.toString(turtle.left(leftAmt));
    }
}
