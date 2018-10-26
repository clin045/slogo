package Backend.Commands.Turtle;

import Backend.Command;
import Backend.VariableTracker;

import java.util.List;


public class CommandTowards extends Command {
    int pointX;
    int pointY;

    public CommandTowards(VariableTracker tracker){
        super(tracker);
    }



    @Override
    public String getDescription() {
        return "TOWARDS: Sets heading towards a point";
    }



    //TODO: Check graphically that this works properly
    public String execute(List<String> params) {

        pointX = (int) parseParameter(params);
        pointY = (int) parseParameter(params);
        var turtleMan = myTracker.getTurtleManager();
        return Double.toString(turtleMan.towards(pointX,pointY));

    }
}
