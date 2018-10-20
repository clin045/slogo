package Backend.Commands;

import Backend.VariableTracker;

public class CommandPenDownP extends TurtleQueries {

    public CommandPenDownP(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "PENDOWN?: returns 1 if turtle's pen is down, 0 if it is up";
    }

    @Override
    public String execute() {
        return Boolean.toString(myTracker.getTurtle().getPenDown());
    }
}
