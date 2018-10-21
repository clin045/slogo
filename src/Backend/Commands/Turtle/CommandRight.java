package Backend.Commands.Turtle;

import java.util.List;

import static Backend.CommandManager.myTracker;

public class CommandRight extends TurtleCommands{
    private double rightAmt;
  public CommandRight(){
        super();
    }

    @Override
    public int getParamNumber() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "RIGHT: Turns the turtle right by some number of degrees";
    }



    @Override
    public String execute(List<String> params) {
        var turtle = myTracker.getTurtle();
        rightAmt=parseParameters(params);
        turtle.right(rightAmt);
        return Double.toString(rightAmt);
    }
}
