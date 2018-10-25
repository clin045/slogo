package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.Turtle;

import java.util.List;

public class CommandSetHeading extends Command {
    private double heading;
    public CommandSetHeading(){
        super();
    }

    @Override
    public String getDescription() {
        return "SETHEADING: Sets the turtle's heading";
    }

    @Override
    public String execute(List<String> params) {
        heading = parseParameters(params);
        Turtle myTurtle = CommandManager.myTracker.getActiveTurtle();
        return Double.toString(myTurtle.setHeading(heading));
    }
}
