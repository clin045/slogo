package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandLessP extends MultiInputCommand {
    private static final String key="LessThan";
    public CommandLessP(VariableTracker tracker){

        super(tracker);
        setKey(key);
    }


    @Override
    public String execute(List<String> params) {
        parseAllParameters(params);
        double check=myVals.remove(0);
        for(double d: myVals){
            if(d<=check){return "0";}
        }
        return "1";
    }
}
