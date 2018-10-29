package Backend.Commands.Display;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandShape extends Command {

    CommandShape(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String execute(List<String> params) {

        return null;
    }
}
