package Backend.Commands.Display;

import Backend.Command;

import Backend.Commands.ControlStructures.CommandSet;
import Backend.VariableTracker;

import java.util.List;

public class CommandSetBackground extends Command {

public CommandSetBackground(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String execute(List<String> params) {

        return null;
    }
}
