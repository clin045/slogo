package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;


public class CommandCS extends Command {

    private static final String key = "ClearScreen";

    public CommandCS(VariableTracker tracker) {
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        var turtleMan = myTracker.getTurtleManager();
        turtleMan.clearScreen();
        return "0.0";
    }
}
