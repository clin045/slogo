package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;


public class CommandTowards extends Command {
    int pointX;
    int pointY;

    public CommandTowards(){
        super();
    }



    @Override
    public String getDescription() {
        return "TOWARDS: Sets heading towards a point";
    }



    //TODO: Check graphically that this works properly
    public String execute(List<String> params) {
        pointX = (int) parseParameters(params);
        pointY = (int) parseParameters(params);
        var myTurtle = CommandManager.myTracker.getTurtle();
        return Double.toString(myTurtle.towards(pointX,pointY));
    }
}
