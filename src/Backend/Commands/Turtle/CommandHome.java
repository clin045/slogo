package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;

import java.util.List;

public class CommandHome extends Command {
    public CommandHome(){
        super();
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String execute(List<String> params) {
        return Double.toString(CommandManager.myTracker.getActiveTurtle().home());
    }
}
