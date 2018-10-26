package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;


public class CommandRand extends Command {
    private double d1;
    public CommandRand(VariableTracker tracker){super(tracker);}

    @Override
    public String getDescription() {
        return "returns random non-negative number strictly less than max";
    }

    @Override
    public String execute(List<String> params) {
        d1= parseParameter(params);
        if(d1<0){throw new IllegalArgumentException("Random ceiling mus be positive");}
        return ""+ (d1*Math.random());
    }
}
