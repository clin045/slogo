package Backend.Commands;

import Backend.Command;
import Backend.VariableTracker;

public class CommandXCor extends TurtleQueries{
    public CommandXCor(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "XCOR: returns the turtle's X coordinate from the center of the screen";
    }

    @Override
    public String execute() {
        return Integer.toString(myTracker.getTurtle().getX());
    }
}
