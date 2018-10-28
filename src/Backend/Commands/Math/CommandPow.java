package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandPow extends Command {
    private double d1,d2;
    private static final String key="Power";
    public CommandPow(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }



    @Override
    public String execute(List<String> params) {
        try{
            d1= parseParameter(params);
            d2= parseParameter(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(key);
        }
        return ""+Math.pow(d1,d2);
    }
}
