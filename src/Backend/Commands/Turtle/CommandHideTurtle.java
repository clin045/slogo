package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;

import java.util.List;

public class CommandHideTurtle extends Command {
    public CommandHideTurtle(){
        super();
    }

    @Override
    public String getDescription() {
        return "HIDETURTLE: makes turtle invisible";
    }

    @Override
    public String execute(List<String> params) {
        return Double.toString(CommandManager.myTracker.getTurtle().hide());
    }
}
