package Backend.Commands.Turtle;

import Backend.CommandManager;

import java.util.List;

public class CommandLeft extends TurtleCommands{
    private double leftAmt;
   public CommandLeft(){
        super();
    }

    @Override
    public int getParamNumber() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "LEFT: Turns the turtle left by some number of degrees";
    }




    @Override
    public String execute(List<String> params) {
        var turtle = CommandManager.myTracker.getTurtle();
        leftAmt=parseParameters(params);
        turtle.left(leftAmt);
        return Double.toString(leftAmt);
    }
}
