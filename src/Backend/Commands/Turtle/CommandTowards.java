package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;


public class CommandTowards extends Command {
    private static final String key="SetTowards";
    int pointX;
    int pointY;

    public CommandTowards(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }


    //TODO: Check graphically that this works properly
    public String execute(List<String> params) {

        pointX = (int) parseParameter(params);
        pointY = (int) parseParameter(params);
        var turtleMan = myTracker.getTurtleManager();
        return Double.toString(turtleMan.towards(pointX,pointY));

    }
}
