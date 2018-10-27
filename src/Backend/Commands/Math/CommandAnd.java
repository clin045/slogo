package Backend.Commands.Math;

import Backend.Command;
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
        parseAllParameters(params);
        for(double d: myVals){
          if(d==0){
              return "0.0";
          }
        }

       return "1.0";
    }
}
