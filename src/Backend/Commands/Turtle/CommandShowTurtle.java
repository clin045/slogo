package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;

import java.util.List;

public class CommandShowTurtle extends Command {
    public CommandShowTurtle(){
        super();
    }


    @Override
    public String getDescription() {
        return "SHOWTURTLE: makes turtle visible";
    }



    @Override
    public String execute(List<String> params) {
        CommandManager.myTracker.getTurtle().show();
        return "1";
    }
}
