package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.lang.invoke.VarHandle;
import java.util.List;

public class CommandHome extends Command {
    public CommandHome(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String execute(List<String> params) {
        return Double.toString(super.myTracker.getTurtle().home());
    }
}
