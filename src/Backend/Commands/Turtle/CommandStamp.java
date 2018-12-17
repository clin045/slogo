package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandStamp extends Command {
    public CommandStamp(VariableTracker tracker) {
        super(tracker);
    }

    @Override
    public String execute(List<String> params) {
        var turtleMan = myTracker.getTurtleManager();
        System.out.println(turtleMan.getShape());
       return String.valueOf(turtleMan.stamp());
    }
}
