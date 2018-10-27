package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandSin extends Command {
   private double d1;
   private static final String key ="Sine";
    public CommandSin(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        d1= parseParameter(params);
        return ""+ (Math.sin(d1));
    }
}
