package Backend.Commands.Display;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandSetShape extends Command {
    public CommandSetShape(VariableTracker tracker) {
        super(tracker);
    }

    @Override
    public String execute(List<String> params) {
        return null;
    }
}
