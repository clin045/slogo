package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandTan extends Command {
private double d1;
private static final String key="Tangent";
public CommandTan(VariableTracker tracker){
    super(tracker);
    setKey(key);
}



    @Override
    public String execute(List<String> params) {
        d1= parseParameter(params);
        if(d1%180==0){throw new IllegalArgumentException("tan of multiples of 180 is undefined");}
        return ""+(Math.tan(d1));
    }
}
