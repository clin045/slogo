package Backend.Commands.Turtle;

import Backend.Command;
import Backend.Exceptions.InvalidSyntaxException;
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
        try{
            pointX = (int) parseParameter(params);
            pointY = (int) parseParameter(params);
        }
        catch(Exception e){
            throw new InvalidSyntaxException(key);
        }
        var myTurtle = myTracker.getTurtleManager();

        return String.valueOf(myTurtle.setXY(pointX,pointY));
    }
}
