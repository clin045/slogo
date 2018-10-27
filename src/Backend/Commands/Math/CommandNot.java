package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandNot extends Command {
    public static final String key ="Not";
    public CommandNot(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }


    @Override
    public String execute(List<String> params) {
        double test = parseParameter(params);
        if(test == 0){
            return "1";
        }
        else{
            return "0";
        }
    }
}
