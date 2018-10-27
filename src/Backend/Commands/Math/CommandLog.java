package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandLog extends Command {
    private double d1;
    private static String key="NaturalLog";
    public CommandLog(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }
    @Override
    public String execute(List<String> params) {
        d1= parseParameter(params);
        if(d1<0){throw new IllegalArgumentException("Log input must be positive");}
        return ""+(Math.log(d1));
    }
}
