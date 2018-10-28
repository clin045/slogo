package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;

public class CommandAnd extends MultiInputCommand {
    private static final String key="And";
    public CommandAnd(VariableTracker tracker){
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
        for(double d: myVals){
          if(d==0){
              return "0.0";
          }
        }

       return "1.0";
    }
}
