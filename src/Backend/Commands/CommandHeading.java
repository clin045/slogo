package Backend.Commands;

import Backend.VariableTracker;

public class CommandHeading extends TurtleQueries {

    public CommandHeading(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "returns the turtle's heading in degrees";
    }

    @Override
    public String execute() {
        return Double.toString(myTracker.getTurtle().getHeading());
    }
}
