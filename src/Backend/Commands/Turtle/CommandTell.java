package Backend.Commands.Turtle;

import Backend.Command;
import Backend.Commands.Math.MultiInputCommand;
import Backend.VariableTracker;

import java.util.List;

public class CommandTell extends MultiInputCommand {

    CommandTell(VariableTracker tracker){
        super(tracker);
    }

}
