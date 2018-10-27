package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandMinus extends Command {
    double d1;
    private static final String key="Minus";
    public CommandMinus(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }



    @Override
    public String execute(List<String> params) {
        d1= parseParameter(params);
        return ""+(-1*d1);
    }
}
