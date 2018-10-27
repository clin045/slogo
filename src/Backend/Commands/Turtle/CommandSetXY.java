package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandSetXY extends Command {
    int pointX;
    int pointY;
    private static final String key="SetPosition";
    public CommandSetXY(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }

    @Override
    public String execute(List<String> params) {

        pointX = (int) parseParameter(params);
        pointY = (int) parseParameter(params);
        var myTurtle = myTracker.getTurtleManager();

        return Double.toString(myTurtle.setXY(pointX,pointY));
    }
}
