package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.Commands.Math.MultiInputCommand;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandTell extends Command {

    public CommandTell(VariableTracker tracker){
        super(tracker);
    }

    @Override
    public String getDescription() {
        return "sets turtles that will follow commands hereafter";
    }

    @Override
    public String execute(List<String> params) {
        int openBracket = params.indexOf("[");
        int closeBracket = params.indexOf("]");
        if(openBracket == -1 || closeBracket == -1 || closeBracket < openBracket){
            throw new IllegalArgumentException("Invalid brackets");
        }

        var idExp = params;
        idExp.remove("[");
        idExp.remove("]");
        //check if each param is a command, if so, evaluate it
        var idList = new ArrayList<Integer>();
        while(idExp.size() > 0){
            if(CommandManager.isCommand(idExp.get(0))){
                var cmd = CommandManager.getCommand(idExp.get(0), myTracker);
                idExp.remove(0);
                try{
                    var doubVal = Double.parseDouble(cmd.execute(idExp.subList(0, idExp.size())));
                    var intVal = (int) doubVal;
                    idList.add(intVal);

                }
                catch(Exception e){
                    throw new IllegalArgumentException("Invalid params for Tell");
                }
            }
            else{
                try{
                    idList.add(Integer.parseInt(idExp.get(0)));
                    idExp.remove(0);
                }
                catch(Exception e){
                    throw new IllegalArgumentException("Invalid params for Tell");
                }
            }
        }
        myTracker.getTurtleManager().setActiveTurtlesByID(idList);
        return Integer.toString(idList.get(idList.size()-1));
    }


}
