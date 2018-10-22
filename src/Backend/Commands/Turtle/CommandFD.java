package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;

import java.util.List;

public class CommandFD extends Command {
    private double amountFD;
    private final int PARAM_NUMBER=1;
    public CommandFD(){
        super();
    }


    @Override
    public String getDescription(){
        return "FORWARD: Moves Turtle forward by a set amount of pixels";
    }


    public String execute(List<String> params) {
//        System.out.println("Executing");
        var turtle = CommandManager.myTracker.getTurtle();
        amountFD=parseParameters(params);
//        System.out.println("MOVING" +amountFD);
        turtle.forward(amountFD);
        return Double.toString(amountFD);
    }



}
