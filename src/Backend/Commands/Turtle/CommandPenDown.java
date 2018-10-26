package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandPenDown extends Command {

    public CommandPenDown(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "PENDOWN: puts pen down such that when the turtle moves, it leaves a trail";
    }

    @Override
    public String execute(List<String> params) {
        return Double.toString(myTracker.getTurtleManager().penDown());
    }
}
