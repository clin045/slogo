package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandYCor extends Command {
    public CommandYCor(VariableTracker tracker){
        super(tracker);
    }
    @Override
    public String getDescription() {
        return "YCOR: returns the turtle's Y coordinate from the center of the screen";
    }

    @Override
    public String execute(List<String> params) {
        return Integer.toString(myTracker.getTurtle().getY());
    }
}
