package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandCS extends Command {

    public CommandCS(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "CLEARS Screen";
    }

    @Override
    public String execute(List<String> params) {
        var turtleMan = myTracker.getTurtleManager();
        turtleMan.clearScreen();
        return "0.0";
    }
}
