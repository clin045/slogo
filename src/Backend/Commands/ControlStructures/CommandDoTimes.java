package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandDoTimes extends LoopCommand{

    public CommandDoTimes(VariableTracker tracker){super(tracker);}
    @Override
    public String getDescription() {
        return "runs command(s) for each value specified in the range, i.e., from (1 - limit) inclusive";
    }

    @Override
    public String execute(List<String> params) {
        if(!params.remove(0).equals(START_DELIMETER)){throw new IllegalArgumentException("Limit must be enclosed by brackets []");}
        if(!params.remove(2).equals(END_DELIMETER)){throw new IllegalArgumentException("DOTIMES only takes one limit argument");}
        key=params.remove(0);
        start=1;
        end=(int) parseParameter(params);
        increment=1;
        return super.execute(params);
    }
}
