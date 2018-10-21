package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.VariableTracker;

import java.util.List;

public class CommandHeading extends Command {

    public CommandHeading(){
        super();
    }

    @Override
    public String getDescription() {
        return "HEADING: returns the turtle's heading in degrees";
    }

    @Override
    public String execute(List<String> params) {
        return Double.toString(CommandManager.myTracker.getTurtle().getHeading());
    }
}
