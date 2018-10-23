package Backend.Commands.Turtle;

import Backend.Command;

import java.util.List;

import static Backend.CommandManager.myTracker;

public class CommandRight extends Command {
    private double rightAmt;
  public CommandRight(){
        super();
    }

    @Override
    public String getDescription() {
        return "RIGHT: Turns the turtle right by some number of degrees";
    }

    @Override
    public String execute(List<String> params) {
        var turtle = myTracker.getTurtle();
        rightAmt = parseParameters(params);
        return Double.toString(turtle.right(rightAmt));
    }
}
