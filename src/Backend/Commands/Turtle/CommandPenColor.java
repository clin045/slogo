package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;


import java.util.List;

public class CommandPenColor extends Command {
    private static final String key = "SETPENCOLOR";
    public CommandPenColor(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }
    @Override
    public String execute(List<String> params) {
        int color=(int)parseParameter(params);
        System.out.println(color);
        return Double.toString(myTracker.getTurtleManager().penColor(color));
    }
}
