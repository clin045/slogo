package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;

import java.util.List;

public class CommandCS extends Command {

    public CommandCS(){
        super();
    }

    @Override
    public String getDescription() {
        return "CLEARS Screen";
    }

    @Override
    public String execute(List<String> params) {
        var turtle= CommandManager.myTracker.getActiveTurtle();
        turtle.clearScreen();
        return "0.0";
    }
}
