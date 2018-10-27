package Backend.Commands.Turtle;

import Backend.Command;
import Backend.CommandManager;
import Backend.Commands.Math.MultiInputCommand;
import Backend.VariableTracker;

import java.util.ArrayList;
import java.util.List;

public class CommandTell extends BracketedCommand {
    private static final String key="Tell";

    public CommandTell(VariableTracker tracker){
        super(tracker);
        setKey(key);
    }


    @Override
    public String execute(List<String> params) {
        int openBracket = params.indexOf("[");
        int closeBracket = params.indexOf("]");
        if(openBracket == -1 || closeBracket == -1 || closeBracket < openBracket){
            throw new IllegalArgumentException("Invalid brackets");
        }

        var idExp = params.subList(openBracket+1, closeBracket);
        ArrayList<Double> idListDouble = evaluateBrackets(idExp);
        ArrayList<Integer> idList = new ArrayList<>();
        for(Double d : idListDouble){
            idList.add(d.intValue());
        }
        myTracker.getTurtleManager().setActiveTurtlesByID(idList);
        return Integer.toString(idList.get(idList.size()-1));
    }




}
