package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;



public class CommandRight extends Command {
    private double rightAmt;
    private static String key="Right";
  public CommandRight(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }



    @Override
    public String execute(List<String> params) {
        var turtle = myTracker.getTurtleManager();
        rightAmt = parseParameter(params);
        return Double.toString(turtle.right(rightAmt));
    }
}
