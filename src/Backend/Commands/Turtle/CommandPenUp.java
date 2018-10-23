package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;

import java.util.List;

public class CommandPenUp extends Command {

    public CommandPenUp(){
        super();
    }


    @Override
    public String getDescription() {
        return "PENUP: puts pen up such that when the turtle moves, it does not leave a trail";
    }

    public String execute(List<String> params) {
        return Integer.toString(CommandManager.myTracker.getTurtle().penUp());
    }
}
