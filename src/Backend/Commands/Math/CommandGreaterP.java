package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandGreaterP extends Command {
    public CommandGreaterP(VariableTracker tracker){
        super(tracker);
    }
    @Override
    public String getDescription() {
        return "returns 1 if the value of expr1 is strictly greater than the value of expr2, otherwise 0";
    }

    @Override
    public String execute(List<String> params) {
        double exp1 = parseParameters(params);
        double exp2 = parseParameters(params);
        if(exp1 > exp2){
            return "1";
        }
        else{
            return "0";
        }
    }
}
