package Backend.Commands.Turtle;

import Backend.Command;
import Backend.Turtle;
import Backend.VariableTracker;

import java.util.List;

public class CommandSetHeading extends Command {
    private double heading;
    private static final String key="SetHeading";
    public CommandSetHeading(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {

        heading = parseParameter(params);
        var turtleMan = myTracker.getTurtleManager();
        return Double.toString(turtleMan.setHeading(heading));

    }
}
