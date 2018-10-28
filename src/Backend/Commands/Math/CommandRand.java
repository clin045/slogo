package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
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
        try{
            d1= parseParameter(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(key);
        }

        if(d1<0){throw new IllegalArgumentException("Random ceiling mus be positive");}
        return ""+ (d1*Math.random());
    }
}
