package Backend.Commands.Math;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
import Backend.VariableTracker;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.DoubleStream;

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
        return String.valueOf(myVals.stream().mapToDouble(d -> d).reduce((a, b) -> (a * b)).getAsDouble());
    }
}
