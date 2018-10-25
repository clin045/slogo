package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;


public class CommandXCor extends Command{
    public CommandXCor(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "XCOR: returns the turtle's X coordinate from the center of the screen";
    }

    @Override
    public String execute(List<String> params) {
        return Integer.toString(myTracker.getTurtle().getX());
    }
}
