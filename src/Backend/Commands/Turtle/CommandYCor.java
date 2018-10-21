package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandYCor extends Command {
    public CommandYCor(){
        super();
    }
    @Override
    public String getDescription() {
        return "YCOR: returns the turtle's Y coordinate from the center of the screen";
    }

    @Override
    public String execute(List<String> params) {
        parseParameters(params);
        return Integer.toString(CommandManager.myTracker.getTurtle().getY());
    }
}
