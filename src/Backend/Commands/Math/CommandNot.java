package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandNot extends Command {
    public CommandNot(VariableTracker tracker){
        super(tracker);
    }
    @Override
    public String getDescription() {
        return "returns 1 if test is 0 and 0 if test is non-zero";
    }

    @Override
    public String execute(List<String> params) {
        double test = parseParameters(params);
        if(test == 0){
            return "1";
        }
        else{
            return "0";
        }
    }
}
