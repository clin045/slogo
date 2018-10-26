package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;

public class CommandSetXY extends Command {
    int pointX;
    int pointY;
    public CommandSetXY(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "SETXY: moves turtle to an absolute screen position, where (0, 0) is the center of the screen\n" +
                "returns the distance turtle moved";
    }

    @Override
    public String execute(List<String> params) {
        pointX = (int) parseParameter(params);
        pointY = (int) parseParameter(params);
        var myTurtle = myTracker.getActiveTurtle();
        return Double.toString(myTurtle.setXY(pointX,pointY));
    }
}
