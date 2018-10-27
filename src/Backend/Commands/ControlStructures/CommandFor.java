package Backend.Commands.ControlStructures;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandFor extends LoopCommand{
    private static final String myKey="For";
    public CommandFor(VariableTracker tracker){
        super(tracker);
        setKey(myKey);
    }
    @Override
    public String getDescription() {
        return "runs command(s) for each value specified in the range, i.e., from (start - end), going by increment";
    }

    @Override
    public String execute(List<String> params) {
        if(!params.remove(0).equals(START_DELIMETER)){throw new IllegalArgumentException("Limit must be enclosed by brackets []");}//[ v s e i ]
        if(!params.remove(4).equals(END_DELIMETER)){throw new IllegalArgumentException("FOR only takes 3 limit argument");}//0 1 2 3 4 5
        key =params.remove(0);
        start=(int) parseParameter(params);
        end=(int) parseParameter(params);
        increment=(int) parseParameter(params);
        return super.execute(params);
    }
}
