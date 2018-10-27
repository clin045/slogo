package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;


public class CommandRand extends Command {
    private double d1;
    private static final String key="Random";
    public CommandRand(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        d1= parseParameter(params);
        if(d1<0){throw new IllegalArgumentException("Random ceiling mus be positive");}
        return ""+ (d1*Math.random());
    }
}
