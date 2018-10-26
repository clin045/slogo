package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
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
        var turtleMan = myTracker.getTurtleManager();
        leftAmt=parseParameters(params);
        return Double.toString(turtleMan.left(leftAmt));
    }
}
