package Backend.Commands;

import Backend.VariableTracker;

public class CommandShowingP extends TurtleQueries {

    public CommandShowingP(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "SHOWING?: returns 1 if turtle is showing, 0 if it is hiding";
    }

    @Override
    public String execute() {
        return Boolean.toString(myTracker.getTurtle().getVisibility());
    }
}
