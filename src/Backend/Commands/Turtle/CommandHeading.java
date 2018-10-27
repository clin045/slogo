package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandHeading extends Command {
    private static final String key="Heading";
    public CommandHeading(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }



    @Override
    public String execute(List<String> params) {
        return Double.toString(myTracker.getTurtleManager().getHeading());
    }
}
