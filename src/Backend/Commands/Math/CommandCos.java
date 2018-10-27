package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandCos extends Command {
private double d1;
private static final String key="Cosine";
    public CommandCos(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {
        d1= parseParameter(params);
        return ""+(Math.cos(d1));
    }
}
