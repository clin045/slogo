package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandLeft extends Command {
    private double leftAmt;
    private static final String key="Left";
   public CommandLeft(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        var turtleMan = myTracker.getTurtleManager();
        leftAmt=parseParameter(params);
        return Double.toString(turtleMan.left(leftAmt));
    }
}
