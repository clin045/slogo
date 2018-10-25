package Backend.Commands.Math;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandATan extends Command {
    private double d1;
    public CommandATan(VariableTracker tracker){super(tracker);}



    @Override
    public String getDescription() {
        return "ATAN: returns arctangent of degrees";
    }

    @Override
    public String execute(List<String> params) {

        d1=parseParameters(params);
        return ""+(Math.atan(d1));
    }
}
