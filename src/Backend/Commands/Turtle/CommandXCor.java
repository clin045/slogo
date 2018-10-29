package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;


public class CommandXCor extends Command{
    private static final String key ="XCoordinate";
    public CommandXCor(VariableTracker tracker){

        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        return String.valueOf(myTracker.getTurtleManager().getX());
    }
}
