package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandTurtles extends Command {

    CommandTurtles(VariableTracker tracker){
        super(tracker);
    }
                   @Override
    public String getDescription() {
        return "returns number of turtles created so far";
    }

    @Override
    public String execute(List<String> params) {
        return Integer.toString(myTracker.getNumTurtles());
    }
}
