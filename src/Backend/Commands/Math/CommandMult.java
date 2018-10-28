package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;
import java.util.ResourceBundle;

public class CommandMult extends MultiInputCommand {
    private static final String key="Product";
    public CommandMult(VariableTracker tracker){
        super(tracker);
        super.setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        try{
            parseAllParameters(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(key);
        }
        double out=1;
        for(double d: myVals){
            out*=d;
        }
        return ""+out;
    }
}
