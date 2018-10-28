package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandEqualP extends MultiInputCommand {
    private static final String key="Equal";
    public CommandEqualP(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }


    @Override
    public String execute(List<String> params) {
        try{
            parseAllParameters(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(key);
        }
        double check=myVals.remove(0);
        for(double d: myVals){
            if(d!=check){return "0";}
        }
       return "1";
    }
}
