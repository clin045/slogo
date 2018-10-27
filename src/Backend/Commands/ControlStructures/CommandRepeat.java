package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandRepeat extends LoopCommand {
    public CommandRepeat(VariableTracker tracker){super(tracker);}

    @Override
    public String getDescription() {
        return "runs command(s) given in the list the value of expr number of times\n" +
                "returns the value of the final command executed (or 0 if no commands are executed)\n" +
                "note, the value of the current iteration, starting at 1, is automatically assigned to the variable :repcount so that it can be accessed by the command(s)";
    }

    @Override
    public String execute(List<String> params) {
        start=1;
        end=(int)parseParameter(params);
        increment =1;
        key = "repCount";
        if(!params.get(0).equals("[")||params.indexOf("]")==-1){throw new IllegalArgumentException("Commands inside repeat block need to be surrounded by brackets");}
           return super.execute(params);
    }
}
