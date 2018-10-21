package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;


public class CommandXCor extends Command{
    public CommandXCor(){
        super();
    }

    @Override
    public String getDescription() {
        return "XCOR: returns the turtle's X coordinate from the center of the screen";
    }

    @Override
    public String execute(List<String> params) {
        parseParameters(params);
        return Integer.toString(CommandManager.myTracker.getTurtle().getX());
    }
}
