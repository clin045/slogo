package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;



public class CommandRight extends Command {
    private double rightAmt;
  public CommandRight(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "RIGHT: Turns the turtle right by some number of degrees";
    }

    @Override
    public String execute(List<String> params) {
        var turtle = myTracker.getTurtleManager();
        rightAmt = parseParameter(params);
        return Double.toString(turtle.right(rightAmt));
    }
}
